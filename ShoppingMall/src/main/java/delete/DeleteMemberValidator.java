package delete;

import java.lang.reflect.Member;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class DeleteMemberValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Member.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		System.out.println("DeleteMemberValidator#validate(): " + this);
		
		ValidationUtils.rejectIfEmpty(errors, "m_pw", "required");
		ValidationUtils.rejectIfEmpty(errors, "m_birth", "required");
		ValidationUtils.rejectIfEmpty(errors, "m_contact", "required");
		
	}

}
