package spring;

public class AuthService {

	private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public AuthInfo authenticate(String m_id, String any_pw) {
		Member member = memberDao.selectById(m_id);
		if (member == null) {
			throw new WrongIdPasswordException();
		}
		if (!member.matchPassword(any_pw)) {
			throw new WrongIdPasswordException();
		}
		return new AuthInfo(member.getM_id(),
				member.getM_name());
	}

}
