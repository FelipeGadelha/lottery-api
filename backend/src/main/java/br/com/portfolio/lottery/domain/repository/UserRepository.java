package br.com.portfolio.lottery.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.portfolio.lottery.domain.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
}
