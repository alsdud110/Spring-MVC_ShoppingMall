package edit;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import login.WrongIdPasswordException;
import member.Member;

@Controller
@RequestMapping("/edit/changePassword")
public class ChangePwdController {

	private ChangePasswordService changePasswordService;

	public void setChangePasswordService(
			ChangePasswordService changePasswordService) {
		this.changePasswordService = changePasswordService;
	}

	@GetMapping("/changePwdForm")
	public String changPwForm(
			@ModelAttribute("command") ChangePwdCommand pwdCmd) {
		return "edit/changePwdForm";
	}

	@PostMapping("/changePwd")
	public String changePw(
			@ModelAttribute("command") ChangePwdCommand pwdCmd,
			Errors errors,
			HttpSession session) throws Exception {
		new ChangePwdCommandValidator().validate(pwdCmd, errors);
		if (errors.hasErrors()) {
			return "redirect:/changePwdForm";
		}
		Member authInfo = (Member) session.getAttribute("authInfo");
		try {

			changePasswordService.changePassword(
					authInfo.getM_code(), authInfo.getM_pw(), pwdCmd.getNewPassword());
			return "edit/changePwd";
		} catch (WrongIdPasswordException e) {
			errors.rejectValue("currentPassword", "notMatching");
			return "redirect:/changePwdForm";
		}
	}
	
	@RequestMapping("/findPw")
	public String findPW() {
		return "edit/findPw";
	}
	
	@PostMapping("/findPwSuccess")
	public String findChangePwForm(HttpSession session, Errors errors, HttpServletRequest request) {
		String m_code = (String)session.getAttribute("findpw");
		String m_pw = request.getParameter("m_pw");
		String m_pw_confirmed = request.getParameter("m_pw_confirmed");
		
		if (m_pw == null || m_pw_confirmed == null) {
			//errors.rejectValue("");
			return "redirect:/findPw";
		}
		
		else if (m_pw != m_pw_confirmed) {
			//errors.rejectValue("");
			return "redirect:/findPw";
		}
		
		try {
			
			changePasswordService.findChangePassword(
					m_code , m_pw);
			return "redirect:/login";
			
		} catch (Exception e) {
			//errors.rejectValue("");
			return "redirect:/findPw";
		}
		
		
	}
}
