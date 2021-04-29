package login;

import java.util.List;

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

import member.Member;

@Controller
public class LoginController {
	@Autowired
    private LoginService loginService;

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
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

    
    @PostMapping("/login")
    public String login(
    		LoginCommand loginCommand, Errors errors, HttpSession session,
    		HttpServletResponse response) {
        new LoginCommandValidator().validate(loginCommand, errors);
        if (errors.hasErrors()) {
            return "login/loginForm";
        }
        try {
        	Member authInfo = loginService.authenticate(
                    loginCommand.getM_id(),
                    loginCommand.getM_pw()
                    );
        	if( session.getAttribute("findId") != null) {
        		session.removeAttribute("findId");
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

			return "main";
        } catch (WrongIdPasswordExcep
		tion e) {
            errors.reject("idPasswordNotMatching");
            return "login/loginForm";
        }
    }
    

    @GetMapping("/findIdPassword")
    public String findPw() {
    	return "edit/findIdPassword";

    }
    
    @PostMapping("/findId")
    public String findId(Errors errors, HttpSession session, HttpServletRequest request) throws Exception{
    	
    	Member member = new Member();
    	
    	member.setM_name(request.getParameter("m_name"));
    	member.setM_email(request.getParameter("m_email"));
    	member.setM_contact(request.getParameter("m_contact"));
    	member.setM_birth(request.getParameter("m_birth"));
    	
    	new FindIdValidator().validate(member, errors);
    	
    	if(errors.hasErrors()) {
    		return "login/findIdPw";
    	}
    	
    	try {
    		List<Member> list_id=  memberService.findId(member);
        	
        	session.setAttribute("findId", list_id);
        	return "login/findIdSuccess";
    		
    	}
    	catch(Exception e){
    		return "login/findIdPw";
    	}
    }

    @PostMapping("/findPw")
    public String findPw(Errors errors, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception{
    	
    	Member member = new Member();
    	
    	member.setM_id(request.getParameter("m_id"));
    	member.setM_name(request.getParameter("m_name"));
    	member.setM_email(request.getParameter("m_email"));
    	member.setM_contact(request.getParameter("m_contact"));
    	member.setM_birth(request.getParameter("m_birth"));
    	
    	new FindPwValidator().validate(member, errors);
    	
    	if(errors.hasErrors()) {
    		return "login/findIdPw";
    	}
    	
    	try {
        	String m_code = memberService.findPw(member);
        	
        	session.setAttribute("findpw", m_code);
        	
        	return "login/findChangePwd";
    		
    	}
    	catch(Exception e){
    		return "login/findIdPw";
    	}
    }

    @RequestMapping("/findId")
    public String findId() {
    	return "edit/findId";
    }
    
}
