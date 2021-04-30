package delete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edit.EditMemberCommandValidator;
import member.Member;


@Controller
@RequestMapping
public class DeleteMemberController {
	@Autowired
    private DeleteMemberService deleteMemberService;

    public void setDeleteService(DeleteMemberService deleteMemberService) {
        this.deleteMemberService = deleteMemberService;
    }

    @GetMapping("/delete")
    public String deleteform(Model model) {
    	return "delete/deleteForm";
    }

    
    @PostMapping("/deleteSucess")
    public String deleteMember(Errors errors, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
    
    	Member deleteMem = new Member();
    	
    	String m_pw = request.getParameter("m_pw");
    	String m_birth = request.getParameter("m_birth");
    	String m_contact = request.getParameter("m_contact");
    	
    	deleteMem.setM_pw(m_pw);
    	deleteMem.setM_birth(m_birth);
    	deleteMem.setM_contact(m_contact);
        
    	new DeleteMemberValidator().validate(deleteMem, errors);
		if (errors.hasErrors()) {
			return "redirect:/deleteForm";
		}
		
    	Member member = (Member)session.getAttribute("authInfo");
    	
    	if(m_pw != member.getM_pw() || m_birth != member.getM_birth() || m_contact != member.getM_contact()) {
    		return "delete/deleteForm";
    	}
    	
        try {
    		
        	deleteMemberService.delete(member.getM_code());
    		
        	session.invalidate();
        	
        	response.reset();
        	
    		return "redirect:/";
        	
        } catch(Exception e) {
        	//errors.reject("");
            return "redirect:/deleteForm";
        }
    }
}
