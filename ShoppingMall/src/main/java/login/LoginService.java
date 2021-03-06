package login;

import member.Member;
import member.MemberDao;

public class LoginService {

	private MemberDao memberDao;

	public LoginService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	//로그인 성공시 회원정보 return
	public Member authenticate(String any_id, String any_pw) {

		Member member = memberDao.selectById(any_id);
		if (member == null) {
			throw new WrongIdPasswordException();
		}
		if (!member.matchPassword(any_pw)) {
			return null;
		}
		Member auth = new Member(member.getM_code(), member.getM_id(), member.getM_pw(), member.getM_addr(), member.getM_contact(), member.getM_email(), member.getM_birth(), member.getM_name());
		
		memberDao.updateRecLogin(member.getM_code());
		
		return auth;
	}

}
