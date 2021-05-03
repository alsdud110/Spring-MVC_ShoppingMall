package cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import product.CartVO;

public class CartDAO {

	// JdbcTemplate 객체 생성
	private JdbcTemplate jdbcTemplate;

	public CartDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void insert(CartVO cartvo) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
				PreparedStatement pstmt = con.prepareStatement("insert into cart values(?,?,sysdate,?,?,?)");
				// 인덱스 파라미터 값 설정
				if (cartvo.getM_code() != null) {
					pstmt.setString(1, cartvo.getM_code());
				} else {
					pstmt.setString(1, "1");
				}

				pstmt.setString(2, cartvo.getP_code());
				pstmt.setInt(3, cartvo.getQty());
				pstmt.setString(4, cartvo.getP_size());
				pstmt.setString(5, cartvo.getP_color());
				return pstmt;
			}
		});
	}
	//카트에 들어갈 목록. M_CODE 관련 추가예정
	public List<CartVO> selectAll() {
		List<CartVO> results = jdbcTemplate.query(
				"select c.*,p.p_name,p.p_price,p.p_image from cart c,product p where c.p_code=p.p_code",
				new RowMapper<CartVO>() {

					@Override
					public CartVO mapRow(ResultSet rs, int rowNum) throws SQLException {
						CartVO vo = new CartVO();
						//vo.setM_code(rs.getString("M_CODE"));
						vo.setP_code(rs.getString("P_CODE"));
						vo.setP_color(rs.getString("P_COLOR"));
						vo.setP_image(rs.getString("P_IMAGE"));
						vo.setP_name(rs.getString("P_NAME"));
						vo.setP_price(rs.getInt("P_PRICE"));
						vo.setP_size(rs.getString("P_SIZE"));
						vo.setQty(rs.getInt("QTY"));
						return vo;
					}
				});
		return results;
	}
}
