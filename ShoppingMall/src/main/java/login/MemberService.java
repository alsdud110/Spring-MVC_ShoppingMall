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

	//아이디 찾기
	public String findId(Member member) {
		
		String resultId = memberDao.selectFindId(member);  //m_id
		System.out.println(resultId);
		return resultId;
	}
	
	

}
