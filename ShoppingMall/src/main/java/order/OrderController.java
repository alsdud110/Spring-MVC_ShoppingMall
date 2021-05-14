package order;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cart.CartService;
import member.Member;
@Controller
public class OrderController {

	private OrderService orderService;
	private CartService cartService;
	
	public void setOrderService(OrderService orderService,CartService cartService) {
		this.orderService = orderService;
		this.cartService=cartService;
	}

	//상세페이지에서 구매하기 정보로 넘어갈 때
	@PostMapping("/order/detailToOrder")
	public String detailToOrder(OrderVO orderVO, Model model, HttpServletResponse response, HttpSession session, HttpServletRequest request) throws IOException {
			
		Member member = (Member)session.getAttribute("authInfo");
		String m_code = member.getM_code();
		orderVO.setM_code(m_code);
		orderVO.setP_code(request.getParameter("p_code"));
		orderVO.setP_image(request.getParameter("p_img"));
		orderVO.setP_name(request.getParameter("p_name"));
			
		List<OrderVO> vo = new ArrayList<>();
		vo.add(orderVO);
		model.addAttribute("orderlist", vo);
		return "order/order";
		
	}
		
	//장바구니에서 구매하기 정보로 넘어갈 때
	@PostMapping("/order/orderList")
	public String cartToOrder(Model model, HttpSession session , HttpServletRequest request) {
			
		if (session.getAttribute("cartInfo") == null) {
			return "redirect:/main";
		}
			
		try {
			String[] arr = request.getParameterValues("checkid"); // arr배열에 c_code를 담음
			session.setAttribute("cartid", arr); //선택 카트 아이디 세션에 추가
	         List<OrderVO> order_list = orderService.orderview(arr);
	         model.addAttribute("orderlist",order_list);
	         session.setAttribute("orderlist", order_list);
		         return "order/order";			
				} catch(Exception e) {
					//Exception 처리 나중에
					return "redirect:/order";
				}
			//return "redirect:/order";
	}			
	
	@PostMapping("/orderConfirmed")
	public String orderToOrderConfirmed(OrderCommand orderCommand, Model model, HttpSession session , HttpServletRequest request) {

		Member authInfo = (Member)session.getAttribute("authInfo");
		String m_code = authInfo.getM_code();
		orderCommand.setM_code(m_code);
		//카트아이디 세션으로 받아오기
		String[] id=null; //배열 선언
		if(session.getAttribute("cartid")!=null) {
		id=(String[]) session.getAttribute("cartid");  //카트에서 구매하기
		orderService.purchaseByCart(id,orderCommand);
		cartService.deleteCart(id);	//구매 진행후 카트 삭제
		}else {
			id=null;	//바로 구매하기
		orderService.purchaseByCart(id,orderCommand);
		}
		session.removeAttribute("cartid"); //구매후 세션 삭제
		model.addAttribute("orderCommand", orderCommand);
		session.setAttribute("orderCommand", orderCommand);
		return "order/orderConfirmed";
	}

	
	@RequestMapping("/order/orderConfirmed")
	public String mainToOrder(Model model, HttpSession session, HttpServletRequest request) {
//		Member authInfo = (Member)session.getAttribute("authInfo");
//		String m_code = authInfo.getM_code();
//		
//		System.out.println(m_code + "앰코드 받아와짐-------------");
//		List<OrderVO> vo = orderService.getOrderCode(m_code);
//
//		//o_code 불러오고
//		String o_code[] = new String[vo.size()];
//		
//		//o_code 배열에 저장하고
//		for(int i = 0; i<vo.size(); i++) {
//			o_code[i] = vo.get(i).getO_code();
//			System.out.println(o_code[i]);
//		}
//		
//		List<OrderVO> orderList = orderService.getOrderList(o_code);
//		System.out.println("리스트에 저장");
//	
//		model.addAttribute("orderCode", vo);
//		model.addAttribute("orderList", orderList);
		
		
		return "order/orderHistory";
	}
	
	@RequestMapping(value = "order/orderHistory", method = RequestMethod.POST)
	@ResponseBody
	public String mainOrder(String code, Model model, HttpSession session, HttpServletRequest request) {
		System.out.println(code);
		String o_code = code;
		List<OrderVO> orderList = orderService.getOrder(o_code);
		
		if(orderList == null) {
			return "fail";
		}else {
		model.addAttribute("order_List", orderList);
		session.setAttribute("order_List", orderList);
		
		return "true";
		}
	}
}
