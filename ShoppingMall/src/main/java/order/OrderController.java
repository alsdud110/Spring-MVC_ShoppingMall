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

import member.Member;
@Controller
public class OrderController {

	private OrderService orderService;
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
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
			String[] arr = request.getParameterValues("checkid"); // arr배열에 c_code를 담
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
		System.out.println("오더 컨펌 ㅅ ㅣ작.  세션확인 - " + session.getAttribute("cartid") );
		Member authInfo = (Member)session.getAttribute("authInfo");
		String m_code = authInfo.getM_code();
		orderCommand.setM_code(m_code);
		//카트아이디 세션으로 받아오기
		String[] id=null; //배열 선언
		if(session.getAttribute("cartid")!=null) {
		id=(String[]) session.getAttribute("cartid");  //선택한 체크박스 체크박스 값 있으면 추가
		}else {
			id=null;	//선택한 카트 없으면 null
		}
		System.out.println(orderCommand.getP_color() + "  " + orderCommand.getP_size());


		orderService.purchaseByCart(m_code, id,orderCommand);
		session.removeAttribute("cartid"); //구매후 세션 삭제
		System.out.println("오더 컨펌  데이터 삽입후 삭제..  세션확인 - " + session.getAttribute("cartid") );
		model.addAttribute("orderCommand", orderCommand);
		session.setAttribute("orderCommand", orderCommand);
		return "order/orderConfirmed";
	}
}
