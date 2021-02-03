package br.com.portfolio.lottery.api.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class EmailValidator implements ConstraintValidator<Email, Object>{

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		String email = (String) value;
		String regex = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		Pattern compile = Pattern.compile(regex, java.util.regex.Pattern.CASE_INSENSITIVE);
		boolean matches = compile.matcher(email).matches();
		return matches;
		
	}

}
