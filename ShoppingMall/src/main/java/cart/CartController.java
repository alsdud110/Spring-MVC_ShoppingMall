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
	public String cart(HttpSession session,Model model) {
		
		if(session.getAttribute("authInfo") != null) {
			Member authInfo=(Member)session.getAttribute("authInfo");
			String m_code=authInfo.getM_code();
			List<CartVO> vo=cartService.cartview(m_code);
			model.addAttribute("cartlist", vo);
			session.setAttribute("cartInfo", vo);
			return "cart/cartList";
		}
		return "login/loginForm";
	}
	
	//카트에 상품 추가
	@PostMapping("/cart/addCart")
	public String addCart(HttpSession session,Model model,CartVO cartVO) {
		Member authInfo=(Member)session.getAttribute("authInfo");
		String m_code=authInfo.getM_code();
		cartVO.setM_code(m_code);
		System.out.println("-----------------cart테스트 =-=-=-=-=--------------------");
		System.out.println(" p_code " +cartVO.getP_code() +	" m_code " + cartVO.getM_code() +"p_name;" + cartVO.getP_name() +
				"p_image;" + cartVO.getP_image() + "p_price;" + cartVO.getP_price() + "qty;" + cartVO.getQty() +" p_size=" + cartVO.getP_size() 
				+" p_color=" +cartVO.getP_color() +"sumMoney;" + cartVO.getSumMoney());
		if(m_code==null) {
			return "redirect:/main";
		}
		cartService.addCart(cartVO);
		model.addAttribute("CartVO", cartVO);
		//값 넘어 왔는지 확인. 비 회원시 m_code는??
		
		return "redirect:/cart";
		
//		new CartValidator().validate(cartVO, errors);
//		
//		if (errors.hasErrors()) {
//			return "redirect:/productDetail/{"+ cartVO.getP_code() + "}";
//		}
//		
//		try {
//			cartService.addCart(cart);
//
//			//갱신된 정보 session에 재설정
//			if (session.getAttribute("cartInfo") != null) {
//				List<CartVO> cart_list = cartService.cartview(m_code);
//				
//				session.setAttribute("cartInfo", cart_list);
//			}
//			
//			//추가 성공
//			return "redirect:/productDetail/{"+ p_code + "}";
//		}
//		catch(Exception e) {
//			
//			//추가 실패
//			return "redirect:/productDetail/{"+ p_code + "}";
//		}
		
	}
	
	@PostMapping("/updateCart")
	public String updateCart(HttpServletRequest request, HttpSession session, Errors errors) {
		
		String m_code = (String)((Member) session.getAttribute("authInfo")).getM_code();
		String[] p_size_list = request.getParameterValues("p_size");
		String[] p_color_list = request.getParameterValues("p_color");
		String[] p_code_list = request.getParameterValues("p_code");
		String[] qty_list = request.getParameterValues("qty");
		
		try {

			//갱신된 정보 session에 재설정
			if (session.getAttribute("cartInfo") != null) {
				List<CartVO> cart_list = cartService.cartview(m_code);
				
				session.setAttribute("cartInfo", cart_list);
			}
			
			cartService.updateQty(m_code, p_code_list, qty_list, p_size_list, p_color_list);
			//추가 성공
			return "redirect:/cart";
		}
		catch(Exception e) {
			
			//추가 실패
			return "redirect:/cart";
		}
		
	}
	
	//장바구니 정보 삭제

	@PostMapping("/cart/delete")
	public String deleteCart(HttpServletRequest request, HttpSession session) {

		System.out.println("-----------------delete 테스트 =-=-=-=-=--------------------");
		String[] arr=request.getParameterValues("checkid");
		if(arr==null) {
			System.out.println("볐다");
			return "redirect:/cart";
		}
		for(String check : arr) {
			System.out.println(check);
		}
		cartService.deleteCart(arr);
		return "redirect:/cart";
		

	}
	
}
