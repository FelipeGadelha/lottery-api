package br.com.portfolio.lottery.api.validator;

import static org.junit.jupiter.api.Assertions.*;

import javax.validation.ConstraintValidatorContext;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.portfolio.lottery.api.v1.dto.request.UserRq;

public class EmailValidatorTest {

	@Test
	@DisplayName("should return FALSE when the email name is simple")
	public void test1() {
		
		var validator = new EmailValidator();
		
		UserRq userRq = new UserRq("felipe");
		ConstraintValidatorContext context = null;
		boolean valid = validator.isValid(userRq.getEmail(), context);
		assertFalse(valid);
		
	}
	
	@Test
	@DisplayName("should return FALSE when the email name ends with @")
	public void test2() {
		
		var validator = new EmailValidator();
		
		UserRq userRq = new UserRq("felipe@");
		ConstraintValidatorContext context = null;
		boolean valid = validator.isValid(userRq.getEmail(), context);
		assertFalse(valid);
		
	}
	
	@Test
	@DisplayName("should return FALSE when the email name ends with dot")
	public void test3() {
		
		var validator = new EmailValidator();
		
		UserRq userRq = new UserRq("felipe@com.");
		ConstraintValidatorContext context = null;
		boolean valid = validator.isValid(userRq.getEmail(), context);
		assertFalse(valid);
		
	}
	
	@Test
	@DisplayName("should return FALSE when the email name ends with .com without @")
	public void test4() {
		
		var validator = new EmailValidator();
		
		UserRq userRq = new UserRq("felipe.com");
		ConstraintValidatorContext context = null;
		boolean valid = validator.isValid(userRq.getEmail(), context);
		assertFalse(valid);
		
	}
	
	@Test
	@DisplayName("should return FALSE when the email name ends with .com.br without @")
	public void test5() {
		
		var validator = new EmailValidator();
		
		UserRq userRq = new UserRq("felipe.com.br");
		ConstraintValidatorContext context = null;
		boolean valid = validator.isValid(userRq.getEmail(), context);
		assertFalse(valid);
		
	}
	
	@Test
	@DisplayName("should return FALSE when the email name ends with .com.br without name after @")
	public void test6() {
		
		var validator = new EmailValidator();
		
		UserRq userRq = new UserRq("felipe@.com.br");
		ConstraintValidatorContext context = null;
		boolean valid = validator.isValid(userRq.getEmail(), context);
		assertFalse(valid);
		
	}
	
	@Test
	@DisplayName("should return TRUE when the email name contains @ and ends with .com")
	public void test7() {
		
		var validator = new EmailValidator();
		
		UserRq userRq = new UserRq("felipe@email.com");
		ConstraintValidatorContext context = null;
		boolean valid = validator.isValid(userRq.getEmail(), context);
		assertTrue(valid);
		
	}
	
	@Test
	@DisplayName("should return TRUE when the email name contains @ and ends with .com.br")
	public void test8() {
		
		var validator = new EmailValidator();
		
		UserRq userRq = new UserRq("felipe@email.com.br");
		ConstraintValidatorContext context = null;
		boolean valid = validator.isValid(userRq.getEmail(), context);
		assertTrue(valid);
		
	}
	
}
