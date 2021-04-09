package br.com.portfolio.lottery.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.portfolio.lottery.domain.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{
	
	@Query("SELECT t FROM Ticket t where t.user.email = :email ORDER BY t.creationDate ASC")
	List<Ticket> findOrderBy(@Param("email") String email);
	
//	List<Ticket> findByUserEmailOrderByCreationDateAsc(String email);
	
	@Query("SELECT t FROM Ticket t where"
			+ " (t.numbers.first = :numberFirst"
			+ " OR t.numbers.second = :numberFirst"
			+ " OR t.numbers.third = :numberFirst"
			+ " OR t.numbers.fourth = :numberFirst"
			+ " OR t.numbers.fifth = :numberFirst"
			+ " OR t.numbers.sixth = :numberFirst"
			+ ") AND ("
			+ " t.numbers.first = :numberSecond"
			+ " OR t.numbers.second = :numberSecond"
			+ " OR t.numbers.third = :numberSecond"
			+ " OR t.numbers.fourth = :numberSecond"
			+ " OR t.numbers.fifth = :numberSecond"
			+ " OR t.numbers.sixth = :numberSecond"
			+ ") AND ("
			+ " t.numbers.first = :numberThird"
			+ " OR t.numbers.second = :numberThird"
			+ " OR t.numbers.third = :numberThird"
			+ " OR t.numbers.fourth = :numberThird"
			+ " OR t.numbers.fifth = :numberThird"
			+ " OR t.numbers.sixth = :numberThird"
			+ ") AND ("
			+ " t.numbers.first = :numberFourth"
			+ " OR t.numbers.second = :numberFourth"
			+ " OR t.numbers.third = :numberFourth"
			+ " OR t.numbers.fourth = :numberFourth"
			+ " OR t.numbers.fifth = :numberFourth"
			+ " OR t.numbers.sixth = :numberFourth"
			+ ") AND ("
			+ " t.numbers.first = :numberFifth"
			+ " OR t.numbers.second = :numberFifth"
			+ " OR t.numbers.third = :numberFifth"
			+ " OR t.numbers.fourth = :numberFifth"
			+ " OR t.numbers.fifth = :numberFifth"
			+ " OR t.numbers.sixth = :numberFifth"
			+ ") AND ("
			+ " t.numbers.first = :numberSixth"
			+ " OR t.numbers.second = :numberSixth"
			+ " OR t.numbers.third = :numberSixth"
			+ " OR t.numbers.fourth = :numberSixth"
			+ " OR t.numbers.fifth = :numberSixth"
			+ " OR t.numbers.sixth = :numberSixth"
			+ ")"
			)
	List<Ticket> findByNumbersFirst(
			Integer numberFirst, 
			Integer numberSecond, 
			Integer numberThird, 
			Integer numberFourth, 
			Integer numberFifth, 
			Integer numberSixth
			);
	
	
	
}
