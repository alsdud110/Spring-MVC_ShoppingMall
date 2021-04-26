package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.EditMemberService;
import spring.Member;

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
	
//	@PostMapping("/edit")
//	public String edit(Model model) {
//		model.addAttribute("loginCommand", new LoginCommand());
//		return "edit/editMemberForm";
//	}
	
	
	@PostMapping("/editSuccess")
	public String editPro(EditMemberCommand editMemberCommand) {
		Member member = new Member();
		editMemberService.edit(editMemberCommand, member.getM_id());
		return "main";
	}


}