package delete;

import javax.servlet.http.HttpServletRequest;
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

    
    @PostMapping("/delete_do")
    public String deleteMember(Errors errors, HttpSession session, HttpServletRequest request) {
    	
    	Member member = new Member();

    	//new DeleteMemberCommandValidator().validate(deleteMemberCommand, errors);

        if (errors.hasErrors()) {
        	return "edit/editMemberForm";
        }
        
        try {
    		member = (Member)session.getAttribute("authInfo");
    		
    		return "main";
        	
        } catch(Exception e) {
            errors.reject("");
            return "edit/editMemberForm";
        }
    }
}
