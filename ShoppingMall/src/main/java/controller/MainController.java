package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/main")
	public String handler(HttpSession session) {
		if(session.getAttribute("authInfo") == null) {
			return "index";
		}
		return "main";
	}
	
	@RequestMapping("/")
	public String main() {
		return "index";
	}
}
