package br.com.portfolio.lottery.api.v1.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import br.com.portfolio.lottery.api.v1.dto.response.TicketRs;

@ActiveProfiles(value = "test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TicketControllerTest {

	@LocalServerPort
	private int port;
	final String BASE_PATH = "/v1/tickets/";
	
	@Autowired
	private TestRestTemplate restTemplate;
	
//	 and identify if you hear winners
	@Test
	@DisplayName("should generate the numbers of the draw")
	public void test1() {
		ResponseEntity<TicketRs> entity = restTemplate.getForEntity(BASE_PATH + "winner", TicketRs.class);
		System.err.println(entity.getBody());
		assertThat(entity.getBody().getNumbers()).isNotNull();
	}
	
	
}
