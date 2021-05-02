package cart;

import product.CartVO;

public class CartService {

private CartDAO cartDAO;
	
	public CartService(CartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}
	//장바구니 담기
	public CartVO addCart(CartVO cartVO) {
		System.out.println("동작?");
		cartDAO.insert(cartVO);
		return cartVO;
	}

}

