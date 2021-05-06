package order;

import java.util.List;

public class OrderService {
	
	private OrderDAO orderDao;

	public OrderService(OrderDAO orderDao) {
		this.orderDao = orderDao;
	}

	public List<OrderVO> orderview(String arr){
		List<OrderVO> order_list = orderDao.selectOrder(arr);
		return order_list;
	}
	
	public void purchaseByCart(String m_code, String o_addr) {
		
		orderDao.insertOrderByCart(m_code, o_addr);
	}
	
	public void purchaseByPstd(String m_code,String o_addr,String p_color,String p_size,String p_code,int qty) {
		
		orderDao.insertOrderByPstd(m_code,o_addr,p_color,p_size,p_code,qty);
	}

	public void insertOrderList(String arr[]) {
		orderDao.insertOrderList(arr);
	}
}
