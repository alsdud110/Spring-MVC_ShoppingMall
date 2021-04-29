package login;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import member.Member;
import member.MemberDao;

public class MemberService {
	
	private MemberDao memberDao;
	
	public MemberService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	//비밀번호 찾기
	public String findPw(Member member) throws Exception {
		
		String m_code = memberDao.selectFindPW(member);
		
		return m_code;
	}

	public List<Member> findId(Member member) {
		
		List<Member> result = memberDao.selectFindId(member);
		
		return result;
	}

}
