package cart;

import java.util.List;

<<<<<<< HEAD
import product.CartVO;
import product.ProductStdVO;
import product.ProductVO;

=======
>>>>>>> 황현
public class CartService {

private CartDAO cartDAO;
	
	public CartService(CartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}
	
<<<<<<< HEAD
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
=======
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
>>>>>>> 황현
	}

}

