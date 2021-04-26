package spring;

import org.springframework.transaction.annotation.Transactional;

public class ChangePasswordService {

	private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Transactional
	public void changePassword(String m_id, String m_pw, String new_m_pw) {
		Member member = memberDao.selectById(m_id);
		if (member == null)
			throw new MemberNotFoundException();

		member.changePassword(m_pw, new_m_pw);

		memberDao.update(member);
	}


}
