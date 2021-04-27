package login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import member.Member;
import member.MemberServiceImpl;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
    private AuthService authService;

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }
    
    @Autowired
    private MemberServiceImpl memberServiceImpl;
    
    public void setMemberServiceImpl(MemberServiceImpl memberServiceImpl) {
    	this.memberServiceImpl = memberServiceImpl;
    }

    //아이디 기억하기 기능
    //일단 pass
    @GetMapping
    public String form(LoginCommand loginCommand,
    		@CookieValue(value = "REMEMBER", required = false) Cookie rCookie) {
		if (rCookie != null) {
			loginCommand.setM_id(rCookie.getValue());
			loginCommand.setRememberId(true);
		}
    	return "login/loginForm";
    }

    
    @PostMapping
    public String login(
    		LoginCommand loginCommand, Errors errors, HttpSession session,
    		HttpServletResponse response) {
        new LoginCommandValidator().validate(loginCommand, errors);
        if (errors.hasErrors()) {
            return "login/loginForm";
        }
        try {
        	Member authInfo = authService.authenticate(
                    loginCommand.getM_id(),
                    loginCommand.getM_pw()
                    );	
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
        } catch (WrongIdPasswordException e) {
            errors.reject("idPasswordNotMatching");
            return "login/loginForm";
        }
    }
    
    @RequestMapping("/findpw")
    public void findPw(@ModelAttribute Member member, HttpServletResponse response) throws Exception{
    	memberServiceImpl.findPw(response, member);
    }
    
}
