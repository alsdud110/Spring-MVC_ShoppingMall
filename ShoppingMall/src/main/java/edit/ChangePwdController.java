package edit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import login.FindPw;
import login.FindPwValidator;
import login.LoginCommand;
import login.WrongIdPasswordException;
import member.Member;

@Controller
public class ChangePwdController {

	@Autowired
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
	    public String findPw(FindPw findPw, Errors errors, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception{
	    	
	    	Member member = new Member();
	    	
	    	member.setM_id(findPw.getM_id());
	    	member.setM_name(findPw.getM_name());
	    	member.setM_birth(findPw.getM_birth());
	    	member.setM_email(findPw.getM_email());
	    	member.setM_contact(findPw.getM_contact());
	    	
	    	System.out.println(member.getM_id());
	    	System.out.println(member.getM_name());
	    	new FindPwValidator().validate(member, errors);
	    	
	    	if(errors.hasErrors()) {
	    		return "redirect:/findIdPassword";
	    	}
	    	try {
	        	String m_code = changePasswordService.findPw(member);  	//m_code
	        	session.setAttribute("m_code", m_code);
	        	return "edit/findPw";
	    	}catch(Exception e){
	    		//errors.reject("");
	    		return "redirect:/findIdPassword";
	    	}
	    }
	    
	    @PostMapping("/findPwSuccess")
	    public String findPwSuccess(FindPw findPw, LoginCommand loginCommand,Errors errors, HttpSession session, HttpServletResponse response, HttpServletRequest request) {
	    	if(errors.hasErrors()) {
	    		return "redirect:/findPw";
	    	}
	    	
	    	try {
	    		String m_pw = findPw.getM_pw();
	    		String m_pw_new = findPw.getM_pw_new();
	    		String m_code = (String)session.getAttribute("m_code");
	    		
	    		if(m_pw == null || m_pw_new == null) {
	    			return "redirect:/findPw";
	    		}
	    		
	    		if(!m_pw.equals(m_pw_new)) {
	    			return "redirect:/findPw";
	    		}
	    		
	    		System.out.println(m_code);
	    		System.out.println(m_pw);
	    		changePasswordService.changePw(m_pw, m_code);
	    		
	    		return "redirect:/login";
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    		return "redirect:/findPw";
	    	}
	    }
}
