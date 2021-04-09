package br.com.portfolio.lottery.api.v1.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import br.com.portfolio.lottery.api.v1.dto.request.UserRq;
import br.com.portfolio.lottery.api.v1.dto.response.UserRs;
import br.com.portfolio.lottery.domain.entity.Ticket;

@ActiveProfiles(value = "test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
	
	@LocalServerPort
	private int port;
	final String BASE_PATH = "/v1/user/";
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	@DisplayName("should successfully save a user")
	public void test() {
		var userRq = new UserRq("test@email.com");
		ResponseEntity<UserRs> entity = restTemplate.postForEntity(BASE_PATH + "register", userRq, UserRs.class);
		System.err.println("--------------TESTE ---------------- " + entity.getBody());
		assertThat(entity.getStatusCodeValue()).isEqualTo(201);
		assertThat(entity.getBody().getEmail()).isEqualTo("test@email.com");
		assertThat(entity.getBody().getTicketsRs()).isNotNull();
	}
	
	@Test
	@DisplayName("should return a list of users successfully")
	public void test1() {
		ResponseEntity<String> entity = restTemplate.getForEntity(BASE_PATH, String.class);
		System.err.println("--------------TESTE 1 ---------------- " + entity);
		assertThat(entity.getStatusCodeValue()).isEqualTo(200);
	}
	
	private static class TicketList extends ArrayList<Ticket> { private static final long serialVersionUID = 1L; }
	
	@Test
	@DisplayName("should successfully return a list of tickets ordered by creation")
	public void test2() {
		String email = "felipe@email.com";
		ResponseEntity<TicketList> entity = restTemplate.getForEntity(BASE_PATH + "{email}" + "/tickets", TicketList.class, email);
		System.err.println("--------------TESTE 2 ----------------");
		entity.getBody().forEach(System.err::println);
		assertThat(entity.getStatusCodeValue()).isEqualTo(200);
		OffsetDateTime t = null;
		List<OffsetDateTime> collect = entity.getBody().stream().map(m -> m.getCreationDate()).collect(Collectors.toList());
		for (OffsetDateTime time : collect) {
			if (Objects.isNull(t)) t = time; 
			else if (t.isAfter(time)) Assertions.fail("Não esta ordenado por criação [" + t + " - " + time + "]");
		}
//		TicketList[] array = ArrayUtils.toArray(entity.getBody());
	}
}
