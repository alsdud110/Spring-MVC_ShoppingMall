package cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import product.CartVO;

public class CartDAO {

	// JdbcTemplate 객체 생성
		private JdbcTemplate jdbcTemplate;
		
		public CartDAO(DataSource dataSource) {
			this.jdbcTemplate=new JdbcTemplate(dataSource);
		}
		
		public void insert(CartVO cartvo) {
			jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection con)
						throws SQLException {
					// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
					PreparedStatement pstmt = con.prepareStatement(
							"insert into cart(m_code, p_code,qty, p_size, p_color, reg_date) values(?,?,?,?,?,sysdate)");
					// 인덱스 파라미터 값 설정
					pstmt.setString(1, cartvo.getM_code());
					pstmt.setString(2, cartvo.getP_code());
					pstmt.setInt(3, cartvo.getQty());
					pstmt.setString(4, cartvo.getP_size());
					pstmt.setString(5, cartvo.getP_color());
					return pstmt;
				}
			});
		}
}
