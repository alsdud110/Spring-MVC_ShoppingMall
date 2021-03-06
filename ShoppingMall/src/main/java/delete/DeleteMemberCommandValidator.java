package delete;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class DeleteMemberCommandValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return DeleteMemberCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		System.out.println("DeleteMemberCommandValidator#validate(): " + this);
		
		ValidationUtils.rejectIfEmpty(errors, "m_birth", "required");
		ValidationUtils.rejectIfEmpty(errors, "m_pw", "required");
		ValidationUtils.rejectIfEmpty(errors, "m_contact", "required");
	}

}
