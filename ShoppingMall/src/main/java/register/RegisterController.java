package register;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class RegisterController {
	
	@Autowired
	private MemberRegisterService memberRegisterService;		//하나만의 빈 주입시 @Autowired애노테이션 생각하능 하나 두개 이상부터는 꼭 붙여야한다.

	public void setMemberRegisterService(
			MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}
	
	@Autowired
	private IdCheckService idCheckService;
	
	public void setIdCheckService(IdCheckService idCheckService) {
		this.idCheckService = idCheckService;
	}
	
	@RequestMapping("/join")
	public String registerMember(Model model) {
		model.addAttribute("registerCommand", new RegisterCommand());
		return "register/join";
	}

	
	// 아이디 중복 검사
	@RequestMapping(value = "/id_check", method = RequestMethod.POST)
	@ResponseBody
	public String memberIdChkPOST(String m_id, HttpSession session) throws Exception{
		int result = idCheckService.checkId(m_id);
		
		session.setAttribute("id check", null);
		if(result != 0) {
			session.setAttribute("id check", "fail");
			return "fail";	
		} else {
			session.setAttribute("id check", "success");
			return "success";
		}	
		
		
	} // memberIdChkPOST() 종료

	@PostMapping("/congrats")
	public String registerMember(RegisterCommand req, Errors errors, HttpSession session) {
		
		if (session.getAttribute("id check") != "success") {
			return "register/join";
		}
		
		new RegisterRequestValidator().validate(req, errors);
		
		if (errors.hasErrors())
			return "register/join";
		try {
			memberRegisterService.regist(req);
			return "register/congrats";
		}
		catch (DuplicateMemberException ex){
			errors.rejectValue("email", "duplicate");
			return "register/join";
		}
	}


}
