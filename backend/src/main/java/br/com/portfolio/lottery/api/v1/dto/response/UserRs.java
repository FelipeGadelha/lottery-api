package br.com.portfolio.lottery.api.v1.dto.response;

import java.util.ArrayList;
import java.util.List;

public class UserRs {

	private String email;
	private List<TicketRs> ticketsRs = new ArrayList<>();

	@Deprecated
	public UserRs() {}

	public UserRs(String email, List<TicketRs> ticketRs) {
		this.email = email;
		this.ticketsRs = ticketRs;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	
	public List<TicketRs> getTicketsRs() {
		return ticketsRs;
	}
	
	public void setTicketsRs(List<TicketRs> ticketsRs) {
		this.ticketsRs = ticketsRs;
	}

}
