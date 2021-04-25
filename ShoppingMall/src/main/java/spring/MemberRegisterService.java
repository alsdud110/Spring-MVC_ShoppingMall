package spring;

import controller.RegisterCommand;

public class MemberRegisterService {

	private MemberDao memberDao;

	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	


	public String regist(RegisterCommand req) {
		Member member = memberDao.selectById(req.getM_id());
		if (member != null) {
			throw new DuplicateMemberException("dup id " + req.getM_id());
		}
		Member newMember = new Member(req.getM_id(), req.getM_pw(), req.getM_addr(), req.getM_contact(), req.getM_email(), req.getRec_login(), req.getM_birth(), req.getM_name());
		memberDao.insert(newMember);
		return newMember.getM_id();
	}
}

