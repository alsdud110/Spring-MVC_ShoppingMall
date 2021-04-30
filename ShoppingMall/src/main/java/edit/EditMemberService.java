package edit;

import member.Member;
import member.MemberDao;

public class EditMemberService {

	private MemberDao memberDao;
	
	public EditMemberService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void edit(EditMemberCommand edit, String m_code) {

		Member newMember = new Member(
				m_code, edit.getM_addr(), 
				edit.getM_contact(), edit.getM_email(), 
				edit.getM_birth(), edit.getM_name());
		memberDao.updateMember(newMember);
	}
	
	public void editFindPw(String m_code, String new_pw) {

		Member member = new Member();
		
		member.setM_code(m_code);
		member.setM_pw(new_pw);
		memberDao.updateMember(member);
	}
}
