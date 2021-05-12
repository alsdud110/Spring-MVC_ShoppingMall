package order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

public class OrderDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public OrderDAO(DataSource dataSource) {
        this.jdbcTemplate=new JdbcTemplate(dataSource);
     }
	
     private RowMapper<OrderVO> orderRowMapper = new RowMapper<OrderVO>() {
        @Override
        public OrderVO mapRow(ResultSet rs, int rowNum) throws SQLException {
           System.out.println("------------mapRow 실행");
           OrderVO order = new OrderVO();
           order.setP_code(rs.getString("P_CODE"));
           order.setM_code(rs.getString("M_CODE"));
           order.setP_name(rs.getString("P_NAME"));
           order.setP_image(rs.getString("P_IMAGE"));
           order.setP_price(rs.getInt("P_PRICE"));
           order.setQty(rs.getInt("QTY"));
           order.setP_size(rs.getNString("P_SIZE"));
           order.setP_color(rs.getString("P_COLOR"));
           order.setSumMoney(0);
           order.setStr("");
           order.setC_code(rs.getInt("C_CODE"));

           return order;
        }

     };
     
     public OrderVO selectOrder(int c_code) {
         List<OrderVO> result =jdbcTemplate.query("select c.*,p.p_name,p.p_price,p.p_image from cart c,product p where 1=1 and c.p_code=p.p_code and c_code=?", orderRowMapper, c_code);
      
         return result.isEmpty() ? null : result.get(0);
      }
     
	//장바구니 선택 상품 구매 리스트 이동
//	public List<OrderVO> selectOrder(String p_code, String m_code) {
//		List<OrderVO> result = null;
//			result = jdbcTemplate.query("select c.*,p.p_name,p.p_price,p.p_image from cart c,product p where c.p_code = p.p_code and c.p_code = ? and c.m_code = ?"
//					, orderRowMapper
//					, p_code
//					, m_code);
//		
//		return result.isEmpty() ? null : result;
//	}

	public List<OrderVO> selectOrder2(String[] arr){
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = null;
				for(int i = 0; i <= arr.length ; i++) {
				pstmt = con.prepareStatement("select c.*,p.p_name,p.p_price,p.p_image from cart c,product p where 1=1 and c.p_code=p.p_code and c_code=?");
				pstmt.setInt(1, Integer.parseInt(arr[i]));
				pstmt.executeUpdate();
				}
				return pstmt;
			}		
		});
		return null;
	}
	
	//장바구니에서 주문 정보 담기
	public void insertOrderByCart(String m_code, String o_addr) {

		//결론적으로 orderlist에 담기는 정보는 하나가 아닌 한꺼번에 bulk insert 과정이 절대적으로 필요
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
				PreparedStatement pstmt = null;
				// 인덱스 파라미터 값 설정
				pstmt = con.prepareStatement("insert into order_list (m_code, o_date, o_addr) values (?, sysdate, ?)");
				pstmt.setString(1, m_code);
				pstmt.setString(2, o_addr);

				pstmt.executeUpdate();
				
				System.out.println("여기까진 된다?");
				
				pstmt = con.prepareStatement("insert into order_product select o.o_code, c.p_size, c.p_color, c.p_code, c.qty from order_list o, cart c where 1=1 and c.m_code = ? and o.m_code = c.m_code");
				pstmt.setString(1, m_code);
				
				System.out.println("여기까지도 됨!");
				return pstmt;
			}
		});
	}
	
	public void insertOrderList(String[] arr) {
		//결론적으로 orderlist에 담기는 정보는 하나가 아닌 한꺼번에 bulk insert 과정이 절대적으로 필요
				jdbcTemplate.update(new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection con)
							throws SQLException {
						// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
						PreparedStatement pstmt = null;
						// 인덱스 파라미터 값 설정
						for(int i = 0; i < arr.length ; i++) {
							int c_code = Integer.parseInt(arr[i]);
							pstmt = con.prepareStatement("insert into ORDER_LIST(c_code) VALUES(?)");
							pstmt.setInt(1, c_code);
							pstmt.executeUpdate();
						}
						
						return pstmt;
					}
				});
	}
}
