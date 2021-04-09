package br.com.portfolio.lottery.domain.entity;

import java.util.Set;

import org.junit.jupiter.api.Test;


public class TicketTest {
	
	@Test
	public void teste() {
		
		
		Ticket ticket = new Ticket();
		Ticket ticket2 = new Ticket();
		
//		ticket.setNumbers(Set.of(49, 37, 54, 22, 47, 31));
//		ticket2.setNumbers(Set.of(49, 37, 54, 22, 47, 31));

		User user = new User("felipe@email.com", null);
		
		boolean equals = ticket.equals(ticket2);
		System.out.println(equals);
	}
}
