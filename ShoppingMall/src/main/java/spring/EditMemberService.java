package spring;

import controller.EditMemberCommand;

public class EditMemberService {

	private MemberDao memberDao;
	
	public EditMemberService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void edit(EditMemberCommand edit, String id) {
		Member member = memberDao.selectById(id);
		
		Member newMember = new Member(member.getM_id(), member.getM_pw(), edit.getM_addr(), 
				edit.getM_contact(), edit.getM_email(), 
				edit.getM_birth(), edit.getM_name());
		memberDao.update(newMember);
	}
}
