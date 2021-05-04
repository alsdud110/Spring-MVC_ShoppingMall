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

public class CartDAO {

   // JdbcTemplate 객체 생성
      private JdbcTemplate jdbcTemplate;
      
      public CartDAO(DataSource dataSource) {
         this.jdbcTemplate=new JdbcTemplate(dataSource);
      }
      private RowMapper<CartVO> cartRowMapper = new RowMapper<CartVO>() {
         @Override
         public CartVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            System.out.println("------------mapRow 실행");
            CartVO cart = new CartVO();
            cart.setP_code(rs.getString("P_CODE"));
            cart.setM_code(rs.getString("M_CODE"));
            cart.setP_name(rs.getString("P_NAME"));
            cart.setP_image(rs.getString("P_IMAGE"));
            cart.setP_price(rs.getInt("P_PRICE"));
            cart.setQty(rs.getInt("QTY"));
            cart.setP_size(rs.getNString("P_SIZE"));
            cart.setP_color(rs.getString("P_COLOR"));
            cart.setSumMoney(0);
            cart.setStr("");

            return cart;
         }


      };
      
      //Cart, Product 정보 가져오기
      public List<CartVO> showCart(String m_code) {
 List<CartVO> results = jdbcTemplate.query("select c.*,p.p_name,p.p_price,p.p_image from cart c,product p where 1=1 and c.p_code=p.p_code and m_code=?", cartRowMapper, m_code);

         return results.isEmpty() ? null : results;
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
					pstmt.setString(1, "C1644DED398F5EF1E05011AC140021AA");
				}

				pstmt.setString(2, cartvo.getP_code());
				pstmt.setInt(3, cartvo.getQty());
				pstmt.setString(4, cartvo.getP_size());
				pstmt.setString(5, cartvo.getP_color());
				return pstmt;
			}
		});
	}
      
      public void deleteCart(String[] p_code_list, String[] p_size_list, String[] p_color_list, String m_code) {
         jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con)
                  throws SQLException {
               // 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
               PreparedStatement pstmt = null;
               // 인덱스 파라미터 값 설정
               for(int i=0; i < p_code_list.length; i++ ) {
                   String p_code = p_code_list[i];
                   String p_size = p_size_list[i];
                   String p_color = p_size_list[i];
                  pstmt = con.prepareStatement(
                        "DELETE FROM CART "
                        + "WHERE "
                        + "		1=1 AND"
                        + "		M_CODE = ? AND "
                        + "		P_CODE = ? AND"
                        + "		P_SIZE = ? AND"
                        + "		P_COLOR = ?");
                  pstmt.setString(1, m_code);
                  pstmt.setString(2, p_code);
                  pstmt.setString(3, p_size);
                  pstmt.setString(4, p_color);
               }
               return pstmt;
            }
         });
      }

      public void updateQty(String m_code, String[] p_code_list, String[] qty_list, String[] p_size_list, String[] p_color_list) {
         // TODO Auto-generated method stub
         jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con)
                  throws SQLException {
               // 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
               PreparedStatement pstmt = null;
               // 인덱스 파라미터 값 설정
               for(int i=0; i < p_code_list.length; i++ ) {
                  String p_code = p_code_list[i];
                  String p_size = p_size_list[i];
                  String p_color = p_size_list[i];
                  String qty = qty_list[i];
                  pstmt = con.prepareStatement(
                        "UPDATE CART"
                        + " SET QTY = ? "
                        + "WHERE M_CODE = ? AND"
                        + "P_CODE = ? AND"
                        + "P_SIZE = ? AND"
                        + "P_COLOR = ?"
                        );
                  pstmt.setString(1, qty);
                  pstmt.setString(2, m_code);
                  pstmt.setString(3, p_code);
                  pstmt.setString(4, p_size);
                  pstmt.setString(5, p_color);
               }
               return pstmt;
            }
         });
      }
}