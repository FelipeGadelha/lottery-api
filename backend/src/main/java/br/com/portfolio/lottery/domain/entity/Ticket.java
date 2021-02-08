package br.com.portfolio.lottery.domain.entity;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "TICKETS")
public class Ticket {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="generator")
	@SequenceGenerator(name="generator", sequenceName="TICKETS_ID_SEQ", allocationSize=1)
	@Column(name="id")	
	private Long id;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "user_email")
	private User user;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "tickets_numbers",
			joinColumns = @JoinColumn(table = "ticket_id" ))
	private Set<Integer> numbers = new HashSet<>();
	@Column(name="creation_date")	
	private OffsetDateTime creationDate;

	@Deprecated
	public Ticket() {	}
	
	private Ticket(Long id, User user, Set<Integer> numbers, OffsetDateTime creationDate) {
		this.id = id;
		this.user = user;
		this.numbers = numbers;
		this.creationDate = creationDate;
	}

	public static Ticket generate(User user) {
		Set<Integer> numbers = new HashSet<>(6);
		Random random = new Random();
		while (numbers.size() < 6) {
			numbers.add(random.nextInt(60) + 1);
		}
		return new Ticket(null, user, numbers, OffsetDateTime.now());
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

	public Set<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(Set<Integer> numbers) {
		this.numbers = numbers;
	}

	public OffsetDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(OffsetDateTime creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", user=" + user + ", numbers=" + numbers + ", creationDate=" + creationDate + "]";
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
