package br.com.portfolio.lottery.api.v1.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.portfolio.lottery.api.convert.Convert;
import br.com.portfolio.lottery.api.v1.dto.request.UserRq;
import br.com.portfolio.lottery.api.v1.dto.response.TicketRs;
import br.com.portfolio.lottery.api.v1.dto.response.UserRs;
import br.com.portfolio.lottery.domain.entity.User;
import br.com.portfolio.lottery.domain.service.UserService;

@RestController
@RequestMapping(value = "/v1/user")
public class UserController {
	
	private final UserService userService;
	private final Convert convert;
	
	@Autowired
	public UserController(UserService userService, Convert convert) {
		this.userService = userService;
		this.convert = convert;
	}
	
	@GetMapping("/tickets/{email}")
	public List<TicketRs> findTicketsByEmail(@PathVariable String email) {
		return userService.findByEmail(email).stream()
				.map(t -> convert.mapper(t, TicketRs.class))
				.collect(Collectors.toList());
	}
	
	@GetMapping
	public List<UserRs> findAll() {
		return userService.findAll()
				.stream()
				.map(this::merge)
				.collect(Collectors.toList());
	}
	
	
	@PostMapping("/register")
	public UserRs register(@RequestBody @Valid UserRq userRq) {
		User user = convert.mapper(userRq, User.class);
		User saved = userService.register(user);
		return this.merge(saved);
	}
	
	private UserRs merge(User user) {
		List<TicketRs> ticketList = user.getTickets()
				.stream()
				.map(t -> convert.mapper(t, TicketRs.class))
				.collect(Collectors.toList());
		UserRs userRs = convert.mapper(user, UserRs.class);
		userRs.setTicketsRs(ticketList);
		return userRs;
	}
}
