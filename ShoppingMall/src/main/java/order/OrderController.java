package order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import member.Member;
@Controller
public class OrderController {

	private OrderService orderService;
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@RequestMapping("/order")
	public String showOrderCart(HttpSession session) {
		
		if (session.getAttribute("cartInfo") == null) {
			return "redirect:/main";
		}
		return "order/orderProduct";
		
	}
	
	//구매하기 버튼
	@RequestMapping("/purchase/{route}")
	public String purchaseProduct(@PathVariable("route") String route,HttpSession session, HttpServletRequest request) {
		System.out.println("----------오더컨트롤러---------" +route);
//		if (session.getAttribute("cartInfo") == null) {
//			return "redirect:/main";
//		}
//		
		Member authInfo=(Member)session.getAttribute("authInfo");
		String m_code=authInfo.getM_code();
		String o_addr = authInfo.getM_addr();
		String p_color=request.getParameter("p_color");
		String p_size=request.getParameter("p_size");
		String p_code=request.getParameter("p_code");
		int qty= Integer.parseInt(request.getParameter("qty"));
		
		//바로 구매하기 정보
		if (m_code == null) {
			return "redirect:/main";
		}
		
		
		//상품 정보페이지에서 구매하기 정보로 넘어갈 때
		if(route.equals("productDetail")) {
			System.out.println("------------상세페이지 에서 구매하기----------");
		
			System.out.println("  "+m_code +"  " +o_addr + "  "+p_code +"  "+ qty +"  "+ p_size +"  "+ p_color );
			try {
				
				orderService.purchaseByPstd(m_code,o_addr,p_color,p_size,p_code,qty);
				
				return "order/123";
				
			} catch(Exception e) {
				//Exception 처리 나중에
				return "redirect:/order";
			}
		}

		//장바구니에서 구매하기 정보로 넘어갈 때
		if(request.getParameter("order_route") == "cart") {
			
			try {
				orderService.purchaseByCart(m_code, o_addr);
				
				return "order/purchaseComplete";
				
			} catch(Exception e) {
				//Exception 처리 나중에
				return "redirect:/order";
			}
		}
		
		//return "redirect:/order";
		return "order/123";

	}
}
