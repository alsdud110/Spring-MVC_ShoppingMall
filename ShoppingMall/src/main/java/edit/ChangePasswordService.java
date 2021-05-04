package edit;

import org.springframework.transaction.annotation.Transactional;

import login.MemberNotFoundException;
import member.Member;
import member.MemberDao;

public class ChangePasswordService {

	private MemberDao memberDao;

	public ChangePasswordService(MemberDao memberDao) {
		// TODO Auto-generated constructor stub
		this.memberDao = memberDao;
	}

	//회원이 로그인 이후에 비밀번호를 변경할 때 사용하는 함수
	@Transactional
	public void changePassword(String m_code, String m_pw, String new_m_pw) throws Exception {
		Member member = memberDao.selectByCode(m_code);
		if (member == null)
			throw new MemberNotFoundException();

		member.changePassword(m_code, m_pw, new_m_pw);
		
		memberDao.updatePwAfterLogin(member);

	}
	
	//비밀번호 찾기
		public String findPw(Member member) throws Exception {
			
			String m_code = memberDao.selectFindPW(member);
			
			return m_code;
		}
		
		//비밀번호 변경
		public void changePw(String m_pw, String m_code) throws Exception {
			memberDao.updatePw(m_pw, m_code);
		}
}
