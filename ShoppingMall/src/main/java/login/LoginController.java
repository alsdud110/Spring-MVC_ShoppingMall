package login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

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
    	int result = idCheckService.checkId(m_id);		//1이면 아이디 있음
    	
    	if(result == 0) {
    		return "falseId";	//해당 아이디 없음
    	}else {
    		Member authInfo = loginService.authenticate(m_id, m_pw);
    		if(authInfo == null) {
    			return "falsePw";	//해당 아이디 있음 비밀번호 틀림
    		}else {
    			return "true";
    		}
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
        	
        	if(authInfo == null) {
        		return "redirect:/login";
        	}
        	
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

    @GetMapping("/auth/kakao/callback")
   	//데이터를 리턴해주는 컨트롤러 함수
    @ResponseBody 
    public String kakaoCallback(String code) {
    	//POST 방식으로 Key=Value 데이터를 요청(카카오쪽으로)
    	HttpHeaders headers = new HttpHeaders();
    	headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
    	
    	MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    	params.add("grant-type", "authorization_code");
    	params.add("client_id", "d08c2eb5431946e51ee63f6281e3aa2c");
    	params.add("redirect_uri", "http://localhost:8080/ShoppingMall/auth/kakao/callback");
    	params.add("code", code);
    	
    	HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params,headers);
    	
    	RestTemplate rt = new RestTemplate();
    	ResponseEntity<String> response = rt.exchange("https://kauth.kakao.com/oauth/token", HttpMethod.POST, kakaoTokenRequest, String.class);
    	return "Kakao Token Response : " + response.getBody();
    	
    	
    }
}
