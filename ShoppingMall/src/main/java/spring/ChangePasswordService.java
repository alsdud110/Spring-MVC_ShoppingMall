package spring;

import org.springframework.transaction.annotation.Transactional;

public class ChangePasswordService {

	private MemberDao memberDao;

	@Transactional
	public void changePassword(String M_id, String M_pw, String new_M_pw) {
		Member member = memberDao.selectById(M_id);
		if (member == null)
			throw new MemberNotFoundException();

		member.changePassword(M_pw, new_M_pw);

		memberDao.update(member);
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

}
