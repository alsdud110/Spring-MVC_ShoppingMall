package member;

import javax.servlet.http.HttpServletResponse;

public interface MemberService {
	//이메일발송
	public void sendEmail(Member mem, String div) throws Exception;

	//비밀번호찾기
	public void findPw(HttpServletResponse resp, Member mem) throws Exception;

}
