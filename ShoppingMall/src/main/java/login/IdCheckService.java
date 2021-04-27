package login;

import member.MemberDao;

public class IdCheckService {
	private MemberDao memberDao;
	
	public IdCheckService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public int checkId(String m_id) {
		int check = memberDao.checkById(m_id); //check = 0이면 축하합니다, 1이면 중복아이디입니다
		return check;
	}
}

//$('.id_input').on("propertychange change keyup paste input", function(){