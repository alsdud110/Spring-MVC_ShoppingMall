package order;


public class OrderService {
	
	private OrderDAO orderDAO;

	public OrderService(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public void purchaseByCart(String m_code, String o_addr) {
		
		orderDAO.insertOrderByCart(m_code, o_addr);
	}
	
	public void purchaseByPstd(String m_code, String o_addr, String p_code, String p_size, String p_color, String qty) {
		
		orderDAO.insertOrderByPstd(m_code, p_code,  p_size, p_color, o_addr, qty);
	}
}
