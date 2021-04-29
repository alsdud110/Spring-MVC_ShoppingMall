package register;

import member.Member;
import member.MemberDao;

public class MemberRegisterService {

	private MemberDao memberDao;

	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	

	public String regist(RegisterCommand req) {
		int num = memberDao.checkById(req.getM_id());
		if (num == 1) {
			throw new DuplicateMemberException("dup id " + req.getM_id());
		}
		//M_code가 일치하는 경우
		/*
		if (
		*/
		/*
		 * 문제점 1번
		 * 현재 birth가 어떤식으로 합쳐지는지 전혀 모름 => birth 값이 유동적으로 변함: 원래는 birth값을 고정값으로 원했음
		 * 
		 * 문제점 2번
		 * 자꾸 모르는 함수들이 생겨남
		 * 
		 * */
		System.out.println("m_brith: " + req.getM_birth());
		Member newMember = new Member(req.getM_code(), req.getM_id(), req.getM_pw(), req.getM_addr(), req.getM_contact(), req.getM_email(), req.getM_birth(), req.getM_name());
		memberDao.insert(newMember);
		return newMember.getM_id();
	}
}

