package br.com.portfolio.lottery.domain.service;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.portfolio.lottery.domain.entity.Ticket;
import br.com.portfolio.lottery.domain.entity.User;
import br.com.portfolio.lottery.domain.repository.TicketRepository;
import br.com.portfolio.lottery.domain.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRespository;
	private final TicketRepository ticketRespository;

	@Autowired
	public UserService(UserRepository userRespository, TicketRepository ticketRespository) {
		this.userRespository = userRespository;
		this.ticketRespository = ticketRespository;
	}

//	@Transactional
	public List<User> findAll() {
		return userRespository.findAll();
	}

//	@Transactional
	public User register(User user) {
		Ticket ticket = Ticket.generate(user);
		user.setTickets(Arrays.asList(ticket));
		return userRespository.save(user);
	}

	public List<Ticket> findByEmail(String email) {
		return ticketRespository.findOrderBy(email);
	}

}
