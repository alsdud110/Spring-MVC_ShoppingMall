package edit;

import member.Member;
import member.MemberDao;

public class EditMemberService {

	private MemberDao memberDao;
	
	public EditMemberService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void edit(EditMemberCommand edit, String m_code) {
		Member member = memberDao.selectByCode(m_code);
		
		Member newMember = new Member(member.getM_code(), member.getM_id(), member.getM_pw(), edit.getM_addr(), 
				edit.getM_contact(), edit.getM_email(), 
				edit.getM_birth(), edit.getM_name());
		memberDao.update(newMember);
	}
}
