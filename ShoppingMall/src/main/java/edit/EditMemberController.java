package edit;

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

import member.Member;

@Controller
public class EditMemberController {
	
	@Autowired
	private EditMemberService editMemberService;
	
	public EditMemberController(EditMemberService editMemberService) {
		this.editMemberService = editMemberService;
	}
	
	
	@RequestMapping("/edit")
	public String editForm(Model model) {
		model.addAttribute("editMemberCommand", new EditMemberCommand());
		return "edit/editMemberForm";
	}
	
	
	//register와는 다르게 get방식을 통해 데이터를 보냄, 어디서 문제가 발생한지 알 수 없음
	@PostMapping("/editMember")
	public String updateMemInfo(EditMemberCommand editMemberCommand, Errors errors, HttpSession session) {
		
        new EditMemberCommandValidator().validate(editMemberCommand, errors);
        if (errors.hasErrors()) {
        	return "redirect:/edit";
        }
        
        try {
    		Member member = (Member)session.getAttribute("authInfo");
    		
    		System.out.println("수정 시작");
    		
    		editMemberService.edit(editMemberCommand, member.getM_code());
    		
    		System.out.println("수정완료");
    		return "/main";
        	
        } catch(Exception e) {
        	errors.reject("");
            return "redirect:/edit";
        }
	}
	

}
