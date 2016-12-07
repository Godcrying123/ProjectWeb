package com.project.webapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.project.webapp.model.Matches;

@Entity
@Table(name = "User_Matches")
public class UserMatches {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bet_id;
	private double betAmount;
	private int bet;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "match_id")
	private Matches matches;

	public UserMatches() {
	}

	public UserMatches(double betAmount, int bet) {
		super();
		this.betAmount = betAmount;
		this.bet = bet;
	}

	public int getBet_id() {
		return bet_id;
	}

	public void setBet_id(int bet_id) {
		this.bet_id = bet_id;
	}

	public double getBetAmount() {
		return betAmount;
	}

	public void setBetAmount(double betAmount) {
		this.betAmount = betAmount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Matches getMatches() {
		return matches;
	}

	public void setMatches(Matches matches) {
		this.matches = matches;
	}

	public int getBet() {
		return bet;
	}

	public void setBet(int bet) {
		this.bet = bet;
	}

	@Override
	public String toString() {
		return "UserMatches [bet_id=" + bet_id + ", betAmount=" + betAmount
				+ ", bet=" + bet + ", user=" + user + ", matches=" + matches
				+ "]";
	}

}
