package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
				member.setM_code(rs.getString("m_code"));
				member.setM_id(rs.getString("m_id"));
				member.setM_pw(rs.getString("m_pw"));
				member.setM_addr(rs.getString("m_addr"));
				member.setM_contact(rs.getString("m_contact"));
				member.setM_email(rs.getString("m_email"));
				member.setRec_login(rs.getTimestamp("rec_login"));
				member.setM_birth(rs.getString("m_birth"));
				member.setM_name(rs.getString("m_name"));
				return member;
			}
		};
	
	
	public int checkById(String m_id) {
		List<Member> results = jdbcTemplate.query("SELECT * FROM MEMBER WHERE M_ID = ?", memRowMapper, m_id);
		
		return results.isEmpty() ? 0 : 1;  //비어있으면 0, 비어있지 않으면 즉 있으면 1
	}
	
	public Member selectByCode(String m_code) {
		
		List<Member> results = jdbcTemplate.query("select m_code from member where m_code = ?", memRowMapper, m_code);

		return results.isEmpty() ? null : results.get(0);
	}

	public Member selectById(String m_id) {
		List<Member> results = jdbcTemplate.query("select * from member where m_id = ?", memRowMapper, m_id);
	
		return results.isEmpty() ? null : results.get(0);  //results가 비어잇으면 null, 잇으면 0
	}
	
	public String selectFindId(Member member) {
		List<Member> resultId = jdbcTemplate.query("select * from member where m_email = ? and m_name = ?",
				memRowMapper, 
				member.getM_email(),
				member.getM_name()
				);
		
		return resultId.isEmpty() ? null : resultId.get(0).getM_id();  //results가 비어잇으면 null, 잇으면 0
	}
	
	public String selectFindPW(Member member) {
		List<Member> results = jdbcTemplate.query("select * from member where m_id = ? and m_name = ? and m_email = ? and m_contact = ? and m_birth = ?",
				memRowMapper, 
				member.getM_id(),
				member.getM_name(),
				member.getM_email(),
				member.getM_contact(),
				member.getM_birth()
				);
	
		return results.isEmpty() ? null : results.get(0).getM_code();  //results가 비어잇으면 null, 잇으면 0
	}
	
	public void insertMember(Member member) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
				PreparedStatement pstmt = con.prepareStatement(
						"insert into member(m_id, m_pw, m_addr, m_contact, m_email, m_birth, m_name) values(?,?,?,?,?,?,?)");
				// 인덱스 파라미터 값 설정
				pstmt.setString(1, member.getM_id());
				pstmt.setString(2, member.getM_pw());
				pstmt.setString(3, member.getM_addr());
				pstmt.setString(4, member.getM_contact());
				pstmt.setString(5, member.getM_email());
//				pstmt.setTimestamp(6, Timestamp.valueOf(member.getRec_login()));
				pstmt.setString(6, member.getM_birth());
				pstmt.setString(7, member.getM_name());
//				pstmt.executeUpdate();
				// 생성한 PreparedStatement 객체 리턴
				return pstmt;
			}
		});
	}
	
	//Login마다 REC_LOGIN 갱신
	public void updateRecLogin(String m_code) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
				PreparedStatement pstmt = con.prepareStatement(
						"UPDATE MEMBER SET REC_LOGIN = SYSDATE WHERE M_CODE = ?");
				// 인덱스 파라미터 값 설정
				pstmt.setString(1, m_code);
				//pstmt.setDate(2, new Date(0));

				return pstmt;
			}
		});
	}

	public void updateMember(Member member) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
				PreparedStatement pstmt = con.prepareStatement(
						"update member set m_addr = ?, m_contact = ?, m_email = ?, m_birth = ?, m_name = ? where m_code = ?");
				// 인덱스 파라미터 값 설정
				pstmt.setString(1, member.getM_addr());
				pstmt.setString(2, member.getM_contact());
				pstmt.setString(3, member.getM_email());
				pstmt.setString(4, member.getM_birth());
				pstmt.setString(5, member.getM_name());
				pstmt.setString(6, member.getM_code());
				
				// 생성한 PreparedStatement 객체 리턴
				return pstmt;
			}
		});
	}

	public void updatePw(String m_pw, String m_code) throws Exception {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
				PreparedStatement pstmt = con.prepareStatement(
						"UPDATE MEMBER SET M_PW = ? WHERE M_CODE = ?");
				// 인덱스 파라미터 값 설정
				pstmt.setString(1, m_pw);
				pstmt.setString(2, m_code);
				
				return pstmt;
			}
		});
	}
	
	public void deleteMember(String m_code) throws Exception {
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
				PreparedStatement pstmt = con.prepareStatement("delete from member where m_code = ?");
				// 인덱스 파라미터 값 설정
				pstmt.setString(1, m_code);

				return pstmt;
			}
		});
		
	}

	public void updatePwAfterLogin(Member member) {
		// TODO Auto-generated method stub
		
	}


	
}