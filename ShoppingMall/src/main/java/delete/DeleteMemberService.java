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
	public void authenticate(String any_id, String any_pw) {

		memberDao.selectById(any_id);

	}

}
