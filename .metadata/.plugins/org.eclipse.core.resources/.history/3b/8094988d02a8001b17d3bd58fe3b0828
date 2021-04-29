package register;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class RegisterRequestValidator implements Validator {
//	private static final String emailRegExp = 
//			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
//			"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
//	private Pattern pattern;
//
//	public RegisterRequestValidator() {
//		pattern = Pattern.compile(emailRegExp);
//		System.out.println("RegisterRequestValidator#new(): " + this);
//	}
//
//	private static final String pwRegExp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}";
//	
//	private Pattern pattern;
//	
//	public RegisterRequestValidator() {
//		pattern = Pattern.compile(pwRegExp);
//	}

	@Override
	public boolean supports(Class<?> clazz) {
		return RegisterCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("RegisterRequestValidator#validate(): " + this);
		RegisterCommand regReq = (RegisterCommand) target;
		if (regReq.getM_id() == null || regReq.getM_id().trim().isEmpty()) {
			errors.rejectValue("m_id", "required");
		} else {
//			Matcher matcher = pattern.matcher(regReq.getM_pw());
//			if (!matcher.matches()) {
//				errors.rejectValue("m_pw", "bad");
//			}
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "m_id", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "m_name", "required");
		ValidationUtils.rejectIfEmpty(errors, "m_pw", "required");
		ValidationUtils.rejectIfEmpty(errors, "m_confirmpw", "required");
		if (!regReq.getM_pw().isEmpty()) {
			if (!regReq.isPasswordEqualToConfirmPassword()) {
				errors.rejectValue("m_confirmpw", "nomatch");
			}
		}
	}

}
