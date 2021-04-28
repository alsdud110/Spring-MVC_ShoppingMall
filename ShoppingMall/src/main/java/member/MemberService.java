package member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.HtmlEmail;

public class MemberService {
	private MemberDao memberDao;
	
	public MemberService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	//이메일 발송
	public void sendEmail(Member mem, String div) throws Exception {
		// TODO Auto-generated method stub
		String charSet = "utf-8";
		String hostSMTP = "smtp.gmail.com"; //네이버 이용시 smtp.naver.com
		//서버 이메일 주소(보내는 사람 이메일 주소)
		String hostSMTPid = "";
		//서버 이메일 비번(보내는 사람 이메일 비번)
		String hostSMTPpwd = "";

		// 보내는 사람 EMail, 제목, 내용
		String fromEmail = "";
		//프로젝트이름 또는 보내는 사람 이름
		String fromName = "4조 프로젝트";
		String subject = "";
		String msg = "";

		if(div.equals("findPw")) {
			subject = "4조 프로젝트 임시 비밀번호 입니다.";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "<h3 style='color: blue;'>";
			msg += mem.getM_id() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요.</h3>";
			msg += "<p>임시 비밀번호 : ";
			msg += mem.getM_pw() + "</p></div>";
		}

		// 받는 사람 E-Mail 주소
		String mail = mem.getM_email();
		try {
			HtmlEmail email = new HtmlEmail();
			email.setDebug(true);
			email.setCharset(charSet);
			email.setSSL(true);
			email.setHostName(hostSMTP);
			email.setSmtpPort(465); 

			email.setAuthentication(hostSMTPid, hostSMTPpwd);
			email.setTLS(true);
			email.addTo(mail, charSet);
			email.setFrom(fromEmail, fromName, charSet);
			email.setSubject(subject);
			email.setHtmlMsg(msg);
			email.send();
		} catch (Exception e) {
			System.out.println("메일발송 실패 : " + e);
		}
	}

	//비밀번호 찾기
	public void findPw(Member mem, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		Member ck = memberDao.selectById(mem.getM_id());
		PrintWriter out = response.getWriter();
		// 가입된 아이디가 없으면
		if(memberDao.checkById(mem.getM_id()) == 0) {
			out.print("<script>alert('아이디를 확인해 주세요.'); history.go(-1);</script>");
			out.close();
		}
		// 가입된 이메일이 아니면
		else if(!mem.getM_email().equals(ck.getM_email())) {
			out.print("<script>alert('이메일을 확인해 주세요.'); history.go(-1);</script>");
			out.close();
		}else {
			// 임시 비밀번호 생성
			String pw = "";
			for (int i = 0; i < 12; i++) {
				pw += (char) ((Math.random() * 26) + 97);
			}
			mem.setM_pw(pw);
			// 비밀번호 변경
			memberDao.updatePw(mem);
			// 비밀번호 변경 메일 발송
			sendEmail(mem, "findPw");

			out.print("<script>alert('이메일로 임시 비밀번호를 발송하였습니다.'); history.go(-1);</script>");
			out.close();
		}
	}

}
