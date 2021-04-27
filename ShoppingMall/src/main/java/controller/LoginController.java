package controller;

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

import spring.AuthInfo;
import spring.AuthService;
import spring.Member;
import spring.MemberServiceImpl;
import spring.WrongIdPasswordException;

@Controller
public class LoginController {
	@Autowired
    private AuthService authService;

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @Autowired
    private MemberServiceImpl service;
    
    public void setMemberServiceImpl(MemberServiceImpl service) {
    	this.service = service;
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
    public String submit(
    		LoginCommand loginCommand, Errors errors, HttpSession session,
    		HttpServletResponse response) {
        new LoginCommandValidator().validate(loginCommand, errors);
        if (errors.hasErrors()) {
            return "login/loginForm";
        }
        try {
            AuthInfo authInfo = authService.authenticate(
                    loginCommand.getM_id(),
                    loginCommand.getM_pw());		//new AuthInfo(member.getM_id(), member.getM_name());
            
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
    
    /* 비밀번호 찾기 */
    @RequestMapping("/findPw")
    public void findPwPOST(@ModelAttribute Member member, HttpServletResponse response) throws Exception{
    	service.findPw(response, member);
    }
}
