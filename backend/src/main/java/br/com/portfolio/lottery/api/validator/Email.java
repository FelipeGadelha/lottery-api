package br.com.portfolio.lottery.api.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {EmailValidator.class})
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {
	
	String message() default "br.com.portfolio.lottery.api.validator.Email";
	
	Class<?> [] groups() default { };
	
	Class<? extends Payload>[] payload() default { };
}
