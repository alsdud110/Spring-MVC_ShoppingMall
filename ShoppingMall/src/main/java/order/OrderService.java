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

	
	public List<OrderVO> getOrderCode(String m_code) {
		System.out.println("서비스는 들어옴");
		List<OrderVO> vo = orderDAO.getOrderCode(m_code);
		
		System.out.println("DAO까지는 OK");
		
		return vo;
	}
	
	public List<OrderVO> getOrderList(String[] o_code){
		System.out.println("서비스 들어옴");
		List<OrderVO> order_list = new ArrayList<>();
		for(int i = 0; i < o_code.length;i++) {
			System.out.println(o_code[i]);
			List<OrderVO> vo = orderDAO.getOrder(o_code[i]);
			for(OrderVO orderVO : vo) {
				order_list.add(orderVO);
			}
		}
		System.out.println("DAO까지도 OK");
		return order_list;
		
	}
	
	public List<OrderVO> getOrder(String o_code){
		System.out.println("서비스 들어와ㅣㅅ고");
		List<OrderVO> orderList = orderDAO.getOrder(o_code);
		
		System.out.println("서비스에서 가져와지나?");
		return orderList;
	}
}