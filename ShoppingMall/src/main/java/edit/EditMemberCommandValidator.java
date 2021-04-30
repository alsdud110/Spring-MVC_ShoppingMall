package edit;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EditMemberCommandValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return EditMemberCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		System.out.println("EditMemberCommandValidator#validate(): " + this);
		
		ValidationUtils.rejectIfEmpty(errors, "m_name", "required");
		ValidationUtils.rejectIfEmpty(errors, "m_birth", "required");
		ValidationUtils.rejectIfEmpty(errors, "m_email", "required");
		ValidationUtils.rejectIfEmpty(errors, "m_contact", "required");

	}

}
