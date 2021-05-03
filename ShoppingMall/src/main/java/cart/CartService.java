package cart;

import java.util.List;

import product.CartVO;
import product.ProductStdVO;
import product.ProductVO;

public class CartService {

private CartDAO cartDAO;
	
	public CartService(CartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}

	
	public CartVO addCart(CartVO cartVO) {
		System.out.println("동작?");
		cartDAO.insert(cartVO);
		return cartVO;
	}
	
	public List<CartVO> listByM_CODE(){
		System.out.println("------서비스----------listByM_CODE 시작");
		List<CartVO> vo=cartDAO.selectAll();
		for (CartVO m : vo) { 
			System.out.println("getP_code=" + m.getP_code() + ", " +"getP_color=" + m.getP_color() + ", " +
					"getP_image=" + m.getP_image() + ", " +"getP_name=" + m.getP_name() + ", " + "getP_price=" + m.getP_price() +" getP_size "+ m.getP_size());
			}
		return vo;
	}

}

