package br.com.portfolio.lottery.api.v1.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.portfolio.lottery.api.validator.Email;

public class UserRq {
	
	@NotNull
	@NotBlank
	@Email(message = "Este email é inválido")
//	@UniqueValue(domainClass = User.class, fieldName = "email", message = "Já existe usuário com esse email")
	private String email; 
	
	@Deprecated
	public UserRq() { }

	public UserRq(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	
	
}
