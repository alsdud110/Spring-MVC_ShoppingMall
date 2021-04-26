package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;


public class MemberDao {

	private JdbcTemplate jdbcTemplate;
	
	public MemberDao() {}
	
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private RowMapper<Member> memRowMapper = new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int nowNum) throws SQLException{
				Member member = new Member();
				member.setM_id(rs.getNString("m_id"));
				member.setM_pw(rs.getString("m_pw"));
				member.setM_addr(rs.getString("m_addr"));
				member.setM_contact(rs.getNString("m_contact"));
				member.setM_email(rs.getString("m_email"));
				member.setReg_login(rs.getTimestamp("reg_login").toLocalDateTime());
				member.setM_name(rs.getString("m_name"));
				member.setM_birth(rs.getString("m_birth"));
				return member;
			}
		};
	
	
	public int checkById(String M_id) {
		List<Member> results = jdbcTemplate.query("SELECT * FROM MEMBER WHERE M_ID = ?", memRowMapper, M_id);
		
		return results.isEmpty() ? 0 : 1;  //비어있으면 0, 비어있지 않으면 즉 있으면 1
	}

	public Member selectById(String M_id) {
		List<Member> results = jdbcTemplate.query("select * from member where m_id = ?",memRowMapper, M_id);
		
		return results.isEmpty() ? null : results.get(0);  //results가 비어잇으면 null, 잇으면 0
	}
	public void insert(Member member) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
				PreparedStatement pstmt = con.prepareStatement(
						"insert into member values(?,?,?,?,?,?,?,?)");
				// 인덱스 파라미터 값 설정
				pstmt.setString(1, member.getM_id());
				pstmt.setString(2, member.getM_pw());
				pstmt.setString(3, member.getM_addr());
				pstmt.setString(4, member.getM_contact());
				pstmt.setString(5, member.getM_email());
				pstmt.setTimestamp(6,
						Timestamp.valueOf(member.getReg_login()));
				pstmt.setString(7, member.getM_birth());
				pstmt.setString(8, member.getM_name());
//				pstmt.executeUpdate();
				// 생성한 PreparedStatement 객체 리턴
				return pstmt;
			}
		});
	}

	public void update(Member member) {
		// TODO Auto-generated method stub
		
	}
//Product
	
/*상품 전체에 대한 데이터 가져오기
 *	SELECT *
	 FROM PRODUCT;
 */
	
/*
 * SELECT P.*, P_STD.*
	FROM PRODUCT P, PRODUCT_STD P_STD
   WHERE
    	1 =1 AND
    	P.P_CODE = ? AND
    	P.P_CODE = P_STD.P_CODE(+);
 */
	
/*현재 판매량 탑 3
 * WITH 
    SUM_QTY AS(
          SELECT SUM(QTY) AS A_QTY, P_CODE
           FROM ORDER_PRODUCT
          GROUP BY P_CODE
        ),
    QTY_R AS(
           SELECT P_CODE, ROWNUM R 
            FROM( 
             SELECT * 
              FROM SUM_QTY
             ORDER BY A_QTY DESC
            )
    ),
    QTY_TOP_3 AS(
               SELECT P_CODE
                FROM QTY_R
               WHERE R < 3
    )
    
	SELECT P.*
	FROM PRODUCT P, PRODUCT_STD P_STD, QTY_TOP_3
	WHERE
	    1 =1 AND
	    P.P_CODE = QTY_TOP_3.P_CODE AND
	    P.P_CODE = P_STD.P_CODE(+);
 * */
}