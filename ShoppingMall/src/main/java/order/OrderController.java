package order;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import member.Member;
@Controller
public class OrderController {

	private OrderService orderService;
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	//상세페이지에서 구매하기 정보로 넘어갈 때
	@RequestMapping("/order/detailToOrder")
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
	@RequestMapping("/order/orderList")
	public String cartToOrder(Model model, HttpSession session , HttpServletRequest request) {
			
		if (session.getAttribute("cartInfo") == null) {
			return "redirect:/main";
		}
			
		try {
			String[] arr = request.getParameterValues("checkid"); // arr배열에 c_code를 담
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
}
