package br.com.portfolio.lottery.api.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.portfolio.lottery.api.convert.Convert;
import br.com.portfolio.lottery.api.v1.dto.response.TicketRs;
import br.com.portfolio.lottery.domain.service.UserService;

@RestController
@RequestMapping(value = "/v1/tickets")
public class TicketController {

	private final UserService userService;
	private final Convert convert;
	
	@Autowired
	public TicketController(UserService userService, Convert convert) {
		this.userService = userService;
		this.convert = convert;
	}
	
	@GetMapping("/winner")
	public ResponseEntity<?> winner() {
		return ResponseEntity.ok(userService.winner().
				map(u -> convert.mapper(u, TicketRs.class)));
	}
		
	
}
