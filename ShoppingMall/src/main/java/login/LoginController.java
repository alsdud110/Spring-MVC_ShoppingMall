package login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import member.Member;
import register.IdCheckService;

@Controller
public class LoginController {
	@Autowired
    private LoginService loginService;

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @Autowired
    private IdCheckService idCheckService;
    
    public void setIdCheckService(IdCheckService idCheckService) {
    	this.idCheckService = idCheckService;
    }
    
    @Autowired
    private MemberService memberService;
    
    public void setMemberService(MemberService memberService) {
    	this.memberService = memberService;
    }

    
    @GetMapping("/login")
    public String form(LoginCommand loginCommand,
    		@CookieValue(value = "REMEMBER", required = false) Cookie rCookie) {
		if (rCookie != null) {
			loginCommand.setM_id(rCookie.getValue());
			loginCommand.setRememberId(true);
		}
    	return "login/loginForm";
    }

    @RequestMapping(value = "/IdPwCheck", method = RequestMethod.POST)
    @ResponseBody
    public String memberIdPwCheck(String m_id, String m_pw, HttpSession session) throws Exception{
    	int result = idCheckService.checkId(m_id);
    	
    	session.setAttribute("id check", null);
    	if(result == 0) {
    		session.setAttribute("id check", "true");
    		return "true";	//해당 아이디 있음
    	}else {
    		session.setAttribute("id check", "false");
    		return "false";	//해당 아이디 없음
    	}
    }
    
    @PostMapping("/login")
    public String login(LoginCommand loginCommand, Errors errors, HttpSession session, HttpServletResponse response) {
		new LoginCommandValidator().validate(loginCommand, errors);

    	if (errors.hasErrors()) {
            return "redirect:/login";
        }
        try {
        	Member authInfo = loginService.authenticate(
                    loginCommand.getM_id(),
                    loginCommand.getM_pw()
                    );
        	if( session.getAttribute("findId") != null) {
        		session.removeAttribute("findId");
        	}
        	if( session.getAttribute("findPW") != null) {
        		session.removeAttribute("findPw");
        	}
            session.setAttribute("authInfo", authInfo);
            
			Cookie rememberCookie = 
					new Cookie("REMEMBER", loginCommand.getM_id());
			rememberCookie.setPath("/");
			if (loginCommand.isRememberId()) {
				rememberCookie.setMaxAge(60 * 60 * 24 * 30);
			} else {
				rememberCookie.setMaxAge(0);
			}
			response.addCookie(rememberCookie);
			
			return "redirect:/";
        } catch (WrongIdPasswordException e) {
            errors.reject("idPasswordNotMatching");
            return "redirect:/login";
        }
    }
    

    @RequestMapping("/findIdPassword")
    public String findPw() {
    	return "edit/findIdPassword";

    }
    
    @RequestMapping("/findId")
    public String findId(FindId findId, Errors errors, HttpSession session, HttpServletRequest request) throws Exception{
    	
    	Member member = new Member();
    	
    	member.setM_email(findId.getM_email());
    	member.setM_name(findId.getM_name());
    	
    	new FindIdValidator().validate(member, errors);
    	
    	if(errors.hasErrors()) {
    		return "redirect:/findIdPassword";
    	}
    	
    	try {
    		String find_Id =  memberService.findId(member); //m_id

    		session.setAttribute("findId", find_Id);
        	
        	return "edit/findId";
    		
    	}
    	catch(Exception e){
    		//errors.reject("");
    		return "redirect:/findIdPassword";
    	}
    }

    @RequestMapping("/kakaoLogin")
    public String kakaoLogin() {
    	return "login/kakaoLogin";
    }

   
}
