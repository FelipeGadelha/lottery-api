package br.com.portfolio.lottery.api.v1.dto.response;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.portfolio.lottery.domain.entity.Numbers;

@JsonInclude(Include.NON_NULL)
public class TicketRs {
	
	private Long id;
	
	private Numbers numbers;
	
	private OffsetDateTime creationDate;
	
	@Deprecated
	public TicketRs() {	}

	public TicketRs(Long id, Numbers numbers, OffsetDateTime creationDate) {
		this.id = id;
		this.numbers = numbers;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Numbers getNumbers() {
		return numbers;
	}
	public void setNumbers(Numbers numbers) {
		this.numbers = numbers;
	}
	
	public String getCreationDate() {
		if (Objects.isNull(creationDate)) return null;
		return creationDate.toString();
	}
	
	public void setCreationDate(OffsetDateTime creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "TicketRs [id=" + id + ", numbers=" + numbers + ", creationDate=" + creationDate + "]";
	}
	
	
}
