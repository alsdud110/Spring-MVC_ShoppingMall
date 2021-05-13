package order;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
	
	private OrderDAO orderDAO;

	public OrderService(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	
	
	
//	public List<OrderVO> orderview(String p_code, String m_code){
//		System.out.println(p_code);
//		List<OrderVO> order_list = orderDAO.selectOrder(p_code, m_code);
//		return order_list;
//	}
	
	public List<OrderVO> orderview(String[] arr){
	      List<OrderVO> order_list =new ArrayList();
	      for(int i=0; i<arr.length; i++) {
	         int c_code=Integer.parseInt(arr[i]);
	         order_list.add(orderDAO.selectOrder(c_code));
	      }
	      return order_list;
	   }
	
	public void purchaseByCart(String[] id,OrderCommand orderCommand) {
		
		orderDAO.insertOrderByCart(id,orderCommand);
	}
	
	public void insertOrderList(String arr[]) {
		orderDAO.insertOrderList(arr);
	}
}
