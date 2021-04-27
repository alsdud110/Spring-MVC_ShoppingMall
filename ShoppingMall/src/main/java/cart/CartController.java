package cart;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {
	
	@RequestMapping("/cart")
	public String cart(HttpSession session) {
		if(session.getAttribute("authInfo") != null) {
			return "cart/cartList";
		}
		return "login";
	}
}