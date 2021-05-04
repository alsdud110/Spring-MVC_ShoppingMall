package delete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import member.Member;


@Controller
public class DeleteMemberController {
	@Autowired
    private DeleteMemberService deleteMemberService;

    public void setDeleteService(DeleteMemberService deleteMemberService) {
        this.deleteMemberService = deleteMemberService;
    }

    @RequestMapping("/delete")
    public String deleteform(Model model) {
    	return "delete/deleteForm";
    }

    
    @PostMapping("/deleteSuccess")
    public String deleteMember(DeleteMemberCommand delCommand, Errors errors, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
    	Member deleteMem = new Member();
    	
    	String pw = request.getParameter("m_pw");
    	
    	new DeleteMemberValidator().validate(deleteMem, errors);
		if (errors.hasErrors()) {
			return "redirect:/deleteForm";
		}
		
    	Member member = (Member)session.getAttribute("authInfo");
    	
    	if(!pw.equals(member.getM_pw())) {
    		return "delete/deleteForm";
    	}
    		try {
    			deleteMemberService.delete(member.getM_code());
    			session.invalidate();
    			
    			response.reset();
    			
    			return "redirect:/main";
    			
    		} catch(Exception e) {
    			//errors.reject("");
    			return "redirect:/deleteForm";
    		}
    		
    	}
}
