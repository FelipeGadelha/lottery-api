package br.com.portfolio.lottery.domain.entity;

import java.util.Arrays;


public class TicketTest {
	
	public void teste() {
		Ticket ticket = null;
		User user = new User("felipe@email.com", Arrays.asList(ticket));
		Ticket.generate(user);
	}
}
