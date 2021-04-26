package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.DuplicateMemberException;
import spring.IdCheckService;
import spring.MemberRegisterService;


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
	
	// 아이디 중복 검사
	@RequestMapping(value = "id_check", method = RequestMethod.POST)
	@ResponseBody
	public String memberIdChkPOST(String memberId) throws Exception{
		int result = idCheckService.checkId(memberId);  //result = 0 이면 중복 아이디 없음, 1이면 있음
		if(result != 0) {		//result = 1
			return "fail";	// 중복 아이디가 존재 1 -> fail
		} else {
			return "success";	// 중복 아이디 x 0 -> success
		}	
		
		
	} // memberIdChkPOST() 종료

	
	@RequestMapping("/join")
	public String signUp(Model model) {
		model.addAttribute("registerCommand", new RegisterCommand());
		return "register/join";
	}


	@PostMapping("/congrats")
	public String handleStep3(RegisterCommand req, Errors errors) {
		new RegisterRequestValidator().validate(req, errors);
		if (errors.hasErrors()) {
			return "register/join";
		}
		try {
			memberRegisterService.regist(req);
			return "register/congrats";
		} catch (DuplicateMemberException ex) {
			errors.rejectValue("email", "duplicate");
			return "register/join";
		}
	}


}
