package br.com.portfolio.lottery.domain.entity;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "TICKETS")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")	
	private Long id;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "user_email")
	private User user;
	
	@Embedded
	private Numbers numbers;
	
//	@ElementCollection(fetch = FetchType.EAGER)
//	@CollectionTable(name = "tickets_numbers",
//			joinColumns = @JoinColumn(table = "ticket_id" ))
//	private Set<Integer> numbers = new HashSet<>();
	
	@CreationTimestamp
	@Column(name="creation_date", nullable = false)	
	private OffsetDateTime creationDate;

	@Deprecated
	public Ticket() {	}
	
	private Ticket(Long id, User user, Numbers numbers) {
		this.id = id;
		this.user = user;
		this.numbers = numbers;
	}
	

	public static Ticket generate(User user) {
		List<Integer> list = random();
		return new Ticket(
				null, 
				user,
				new Numbers(
//						2,3,1,5,6,4
						list.get(0), 
						list.get(1), 
						list.get(2), 
						list.get(3), 
						list.get(4), 
						list.get(5)
						)
				);
	}
	
	public static Ticket winner() {
		List<Integer> list = random();
		return new Ticket(
				null, 
				null,
				new Numbers(
//						1,2,3,4,5,6
						list.get(0), 
						list.get(1), 
						list.get(2), 
						list.get(3), 
						list.get(4), 
						list.get(5)
						)
				);
	}
	
	private static List<Integer> random() {
		Set<Integer> numbers = new HashSet<>(6);
		Random random = new Random();
		while (numbers.size() < 6) {
			numbers.add(random.nextInt(60) + 1);
		}
		return new ArrayList<>(numbers);
	}
	
	public <R> R map(Function<Ticket, R> func) {
        return func.apply(this);
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public Numbers getNumbers() {
		return numbers;
	}

	public void setNumbers(Numbers numbers) {
		this.numbers = numbers;
	}
	
	public OffsetDateTime getCreationDate() {
		return creationDate;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", numbers=" + numbers + ", creationDate=" + creationDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return 
					true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
