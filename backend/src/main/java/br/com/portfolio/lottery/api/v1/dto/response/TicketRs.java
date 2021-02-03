package br.com.portfolio.lottery.api.v1.dto.response;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TicketRs {
	
	private Long id;
	
	private Set<Integer> numbers = new HashSet<>();
	
	private OffsetDateTime creationDate;
	
	@Deprecated
	public TicketRs() {	}

	public TicketRs(Long id, Set<Integer> numbers, OffsetDateTime creationDate) {
		this.id = id;
		this.numbers = numbers;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Set<Integer> getNumbers() {
		return numbers;
	}
	public void setNumbers(Set<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public String getCreationDate() {
		if (Objects.isNull(creationDate)) return null;
		return creationDate.toString();
	}
	
	public void setCreationDate(OffsetDateTime creationDate) {
		this.creationDate = creationDate;
	}
	
}
