package br.com.portfolio.lottery.domain.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Numbers {
	
	@Column(name = "numbers_first")
	private Integer first;
	@Column(name = "numbers_second")
	private Integer second;
	@Column(name = "numbers_third")
	private Integer third;
	@Column(name = "numbers_fourth")
	private Integer fourth;
	@Column(name = "numbers_fifth")
	private Integer fifth;
	@Column(name = "numbers_sixth")
	private Integer sixth;
	
	@Deprecated
	public Numbers() {	}
	
	public Numbers(Integer first, Integer second, Integer third, Integer fourth, Integer fifth, Integer sixth) {
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
		this.fifth = fifth;
		this.sixth = sixth;
	}

	public Integer getFirst() {
		return first;
	}

	public Integer getSecond() {
		return second;
	}

	public Integer getThird() {
		return third;
	}

	public Integer getFourth() {
		return fourth;
	}

	public Integer getFifth() {
		return fifth;
	}

	public Integer getSixth() {
		return sixth;
	}

	@Override
	public String toString() {
		return "Numbers [first=" + first + ", second=" + second + ", third=" + third + ", fourth=" + fourth + ", fifth="
				+ fifth + ", sixth=" + sixth + "]";
	}
	
	

}
