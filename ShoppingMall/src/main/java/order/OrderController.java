package order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cart.CartVO;
import member.Member;

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
	@PostMapping("/purchase")
	public String purchaseProduct(HttpSession session, HttpServletRequest request) {
		
		if (session.getAttribute("cartInfo") == null) {
			return "redirect:/main";
		}
		
		//바로 구매하기 정보
		if (session.getAttribute("Info") == null) {
			return "redirect:/main";
		}
		
		String o_addr = request.getParameter("o_addr");
		String m_code = (String)((Member) session.getAttribute("authInfo")).getM_code();
		
		//상품 정보페이지에서 구매하기 정보로 넘어갈 때
		if(request.getParameter("order_route") == "p_std") {
			
			String p_code = request.getParameter("p_code");
			String qty = request.getParameter("qty");
			
			try {
				
				orderService.purchaseByPstd(m_code, o_addr, p_code, qty);
				
				return "order/purchaseComplete";
				
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
		
		return "redirect:/order";

	}
}
