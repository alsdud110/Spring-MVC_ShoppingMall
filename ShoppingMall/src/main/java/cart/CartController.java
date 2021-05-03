package cart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import member.Member;

@Controller
public class CartController {
	
	private CartService cartService;
	
	public void setCartService(CartService cartService) {
		this.cartService=cartService;
	}
	
	@RequestMapping("/cart")
	public String cart(HttpSession session) {
		
		if(session.getAttribute("authInfo") != null) {
			
			//session에 카트 정보 설정
			if(session.getAttribute("cartInfo") == null) {
				String m_code = (String)((Member) session.getAttribute("authInfo")).getM_code();
				
				List<CartVO> cart_list = cartService.cartview(m_code);
				
				session.setAttribute("cartInfo", cart_list);
			}
			return "cart/cartList";
		}
		return "login/loginForm";
	}
	
	//카트에 상품 추가
	@PostMapping("/addCart")
	public int addCart(HttpServletRequest request, HttpSession session, Errors errors) {
		
		//추가 실행 자체가 안됨
		int cart_val = 0;
		
		String p_code = request.getParameter("p_code");
		String m_code = (String)((Member) session.getAttribute("authInfo")).getM_code();
		String p_size = request.getParameter("p_size");
		String p_color = request.getParameter("p_color");
		int qty = Integer.valueOf(request.getParameter("qty"));
		
		CartVO cart = new CartVO(p_code, m_code, p_size, p_color, qty);
		
		new CartValidator().validate(cart, errors);
		
		if (errors.hasErrors()) {
			cart_val = -1;
		}
		
		try {
			cartService.addCart(cart);

			//갱신된 정보 session에 재설정
			if (session.getAttribute("cartInfo") != null) {
				List<CartVO> cart_list = cartService.cartview(m_code);
				
				session.setAttribute("cartInfo", cart_list);
			}
			
			//추가 성공
			cart_val = 1;
		}
		catch(Exception e) {
			
			//추가 실패
			cart_val = -1;
		}
		
		return cart_val;
		
	}
	
	public int updateCart(HttpServletRequest request, HttpSession session, Errors errors) {
		
		int upt_cart_val = 0;
		
		String m_code = (String)((Member) session.getAttribute("authInfo")).getM_code();
		String[] p_code_list = request.getParameterValues("p_code");
		String[] qty_list = request.getParameterValues("qty");
		
		
		try {

			//갱신된 정보 session에 재설정
			if (session.getAttribute("cartInfo") != null) {
				List<CartVO> cart_list = cartService.cartview(m_code);
				
				session.setAttribute("cartInfo", cart_list);
			}
			
			cartService.updateQty(m_code, p_code_list, qty_list);
			//추가 성공
			upt_cart_val = 1;
		}
		catch(Exception e) {
			
			//추가 실패
			upt_cart_val = -1;
		}
		
		return upt_cart_val;
	}
	
	//장바구니 정보 삭제
	public int deleteCart(HttpServletRequest request, HttpSession session, Errors errors) {
		
		//삭제 자체가 실행 안됨
		int cart_del_val = 0;
		
		//p_code를 list로 형태로 가져옴
		String[] p_code = request.getParameterValues("p_code");
		String m_code = (String)((Member) session.getAttribute("authInfo")).getM_code();
		
		try {
			cartService.deleteCart(p_code, m_code);

			//갱신된 정보 session에 재설정
			if (session.getAttribute("cartInfo") != null) {
				List<CartVO> cart_list = cartService.cartview(m_code);
				
				session.setAttribute("cartInfo", cart_list);
			}
			
			//삭제 성공
			cart_del_val = 1;
		}
		catch(Exception e) {
			//삭제 실패
			cart_del_val = -1;
		}
		
		return cart_del_val;
	}
	
}