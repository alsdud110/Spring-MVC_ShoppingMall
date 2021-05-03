package cart;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class CartValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return CartVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "p_code", "required");
		ValidationUtils.rejectIfEmpty(errors, "p_size", "required");
		ValidationUtils.rejectIfEmpty(errors, "p_color", "required");
		ValidationUtils.rejectIfEmpty(errors, "qty", "required");
	}


}
