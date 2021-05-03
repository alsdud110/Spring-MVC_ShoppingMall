package cart;

import java.util.List;


public class CartService {

private CartDAO cartDAO;
	
	public CartService(CartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}

	//아직 오류 처리 안됨
	public int addCart(CartVO cart) {
		int num = 0;
		
		try {
			cartDAO.insertCart(cart);
			
			num = 1;
		}
		catch(Exception e) {
			num = 0;
		}
		
		return num;
	}
	
	public void updateQty(String m_code, String[] p_code_list, String[] qty_list) {
		
		cartDAO.updateQty(m_code, p_code_list, qty_list);
	}
	
	//카트 정보 불러오기
	public List<CartVO> cartview(String m_code) {
		
		List<CartVO> cart_list = cartDAO.showCart(m_code);
			
		return cart_list;
	}

	//카트 정보 삭제
	public void deleteCart(String[] p_code_list, String m_code) {
		
		cartDAO.deleteCart(p_code_list, m_code);

	}

}

