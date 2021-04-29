package mypage;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import login.LoginCommand;
import login.LoginCommandValidator;
import login.WrongIdPasswordException;
import member.Member;

public class MyPageController {
	
	
	@Autowired
	private MyPageService mypageService;
    
    public void setMyPageService(MyPageService mypageservice) {
    	this.mypageService = mypageservice;
    }

    @GetMapping("/myPage")
    public String showMyPage() {
    	return "member/myPage";
    }

    
    @GetMapping("/member")
    public String showMemberInfo(
    		LoginCommand loginCommand, Errors errors, HttpSession session,
    		HttpServletResponse response) {
        new LoginCommandValidator().validate(loginCommand, errors);
        if (errors.hasErrors()) {
            return "login/loginForm";
        }
        try {
        		
			  return "myPage";
				
        } catch (WrongIdPasswordException e) {
            errors.reject("idPasswordNotMatching");
            return "login/loginForm";
        }
    }


    
}