package br.com.portfolio.lottery.api.v1.dto.response;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class UserRs {

	private String email;
	private List<TicketRs> ticketsRs = new ArrayList<>();

	@Deprecated
	public UserRs() {}

	public UserRs(String email, List<TicketRs> ticketRs) {
		this.email = email;
		this.ticketsRs = ticketRs;
	}
	
    public <R> R map(Function<UserRs, R> func) {
        return func.apply(this);
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

	@Override
	public String toString() {
		return "UserRs [email=" + email + ", ticketsRs=" + ticketsRs + "]";
	}
	
	

}
