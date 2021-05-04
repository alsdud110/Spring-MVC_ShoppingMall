package order;


public class OrderService {
	
	private OrderDAO orderDAO;

	public OrderService(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public void purchaseByCart(String m_code, String o_addr) {
		
		orderDAO.insertOrderByCart(m_code, o_addr);
	}
	
	public void purchaseByPstd(String m_code,String o_addr,String p_color,String p_size,String p_code,int qty) {
		
		orderDAO.insertOrderByPstd(m_code,o_addr,p_color,p_size,p_code,qty);
	}
}
