package cart;

import product.CartVO;

public class CartService {

private CartDAO cartDAO;
	
	public CartService(CartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}
	
	public void cartview() {
		System.out.println("동작?");
	}
}

