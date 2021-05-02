package cart;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import product.CartVO;

@Controller
public class CartController {
	
	private CartService cartService;
	
	public void setCartService(CartService cartService) {
		this.cartService=cartService;
	}
	
//	@RequestMapping("/cart")
//	public String cart(HttpSession session) {
//		if(session.getAttribute("authInfo") != null) {
//			return "cart/cartList";
//		}
//		return "login/loginForm";
//	}
	
	@RequestMapping("/AddCart")  //form url 지정
	public String addCart(Model model,CartVO cartVO) {
		cartService.addCart(cartVO);
		model.addAttribute("CartVO", cartVO);
		//값 넘어 왔는지 확인. 비 회원시 m_code는??
		System.out.println("-----------------cart테스트 =-=-=-=-=--------------------");
		System.out.println(" p_code " +cartVO.getP_code() +	" m_code " + cartVO.getM_code() +"p_name;" + cartVO.getP_name() +
				"p_image;" + cartVO.getP_image() + "p_price;" + cartVO.getP_price() + "qty;" + cartVO.getQty() +" p_size=" + cartVO.getP_size() 
				+" p_color=" +cartVO.getP_color() +"sumMoney;" + cartVO.getSumMoney());
			return "cart/insert";  //이동 페이지 지정. [메인 or 카트목록] 이동예정
	}
}