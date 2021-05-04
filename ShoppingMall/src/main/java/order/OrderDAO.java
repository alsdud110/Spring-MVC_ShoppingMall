package order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import cart.CartVO;

public class OrderDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public OrderDAO(DataSource dataSource) {
		this.jdbcTemplate=new JdbcTemplate(dataSource);
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
				pstmt = con.prepareStatement(
							  "insert into ORDER_LIST(M_CODE, O_APPR, O_DATE, O_ADDR)"
							+ " VALUES(?, SYSDATE, ?)");
				pstmt.setString(1, m_code);
				pstmt.setString(2, o_addr);
				
				pstmt.executeUpdate();
				//-------------아래 sql문 에러
				pstmt = con.prepareStatement(
						"INSERT INTO ORDER_PRODUCT" + 
						"SELECT O.O_CODE, C.P_SIZE, C.P_COLOR, C.P_CODE, C.QTY" + 
						"FROM ORDER_LIST O, CART C" + 
						"WHERE" + 
						"    1=1 AND" + 
						"    C.M_CODE = ? AND" + 
						"    O.M_CODE = C.M_CODE");
				pstmt.setString(1, m_code);
				return pstmt;
			}
		});
	}
	
	//상품 정보 페이지에서 주문 정보 담기
	public void insertOrderByPstd(String m_code,String o_addr,String p_color,String p_size,String p_code,int qty) {

		//결론적으로 orderlist에 담기는 정보는 하나가 아닌 한꺼번에 bulk insert 과정이 절대적으로 필요
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
				PreparedStatement pstmt = null;
				// 인덱스 파라미터 값 설정
				pstmt = con.prepareStatement(
							  "insert into ORDER_LIST(M_CODE, O_DATE, O_ADDR)"
							+ " VALUES(?, SYSDATE, ?)");
				pstmt.setString(1, m_code);
				pstmt.setString(2, o_addr);
				
				
				pstmt = con.prepareStatement(
						"iNSERT INTO ORDER_PRODUCT                           \r\n" + 
						"SELECT O.O_CODE, INFO.*, ? FROM  ORDER_LIST O, (SELECT STD.P_SIZE, STD.P_COLOR,STD.P_CODE FROM PRODUCT_STD STD WHERE STD.P_CODE = ?) INFO\r\n" + 
						"WHERE \r\n" + 
						"1=1 AND\r\n" + 
						"O.M_CODE =? and INFO.P_COLOR=? and INFO.P_SIZE=?");
				pstmt.setInt(1, qty);
				pstmt.setString(2, p_code);
				pstmt.setString(3, m_code);
				pstmt.setString(4, p_color);
				pstmt.setString(5, p_size);
				return pstmt;
			}
		});
	}
}
