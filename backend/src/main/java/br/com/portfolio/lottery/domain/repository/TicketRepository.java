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
	
	
}
