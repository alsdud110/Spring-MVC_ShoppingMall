package delete;

import member.Member;
import member.MemberDao;

public class DeleteMemberService {

	private MemberDao memberDao;

	public DeleteMemberService(MemberDao memberDao) {
		// TODO Auto-generated constructor stub
		this.memberDao = memberDao;
	}

	//실행 완료시 삭제
	public void delete(String m_code) throws Exception {

		memberDao.deleteMember(m_code);
		System.out.println("YES");
	}

}
