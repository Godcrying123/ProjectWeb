package com.project.webapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.project.webapp.controller.MatchesController;
import com.project.webapp.domain.User;
import com.project.webapp.domain.UserMatches;

@Entity
@Table(name = "Matches")
public class Matches {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int match_id;
	private int hometeam;
	private int awayteam;
	private int homescore;
	private int awayscore;
	private int homePoints;
	private int awayPoints;
	private int matchweek;
	private String startTime;
	private double homeWinRate;
	private double drawRate;
	private double awayWinRate;

	@ManyToMany(mappedBy = "matchesList")
	private List<Team> teamList;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "match_id")
	private List<UserMatches> orderList;

	public Matches() {
	}

	public Matches(int hometeam, int awayteam, int homescore, int awayscore, int homePoints, int awayPoints,
			int matchweek, double homeWinRate, double drawRate, double awayWinRate, String startTime) {
		super();
		this.hometeam = hometeam;
		this.awayteam = awayteam;
		this.homescore = homescore;
		this.awayscore = awayscore;
		this.homePoints = homePoints;
		this.awayPoints = awayPoints;
		this.matchweek = matchweek;
		this.homeWinRate = homeWinRate;
		this.drawRate = drawRate;
		this.awayWinRate = awayWinRate;
		this.startTime = startTime;
		this.teamList = teamList;
		this.orderList = orderList;
		this.teamList = new ArrayList<Team>();
		this.orderList = new ArrayList<UserMatches>();
	}

	public int getHometeam() {
		return hometeam;
	}

	public void setHometeam(int hometeam) {
		this.hometeam = hometeam;
	}

	public int getAwayteam() {
		return awayteam;
	}

	public void setAwayteam(int awayteam) {
		this.awayteam = awayteam;
	}

	public int getHomescore() {
		return homescore;
	}

	public void setHomescore(int homescore) {
		this.homescore = homescore;
	}

	public int getAwayscore() {
		return awayscore;
	}

	public void setAwayscore(int awayscore) {
		this.awayscore = awayscore;
	}

	public int getMatchweek() {
		return matchweek;
	}

	public void setMatchweek(int matchweek) {
		this.matchweek = matchweek;
	}

	public int getHomePoints() {
		return homePoints;
	}

	public void setHomePoints(int homePoints) {
		this.homePoints = homePoints;
	}

	public int getAwayPoints() {
		return awayPoints;
	}

	public void setAwayPoints(int awayPoints) {
		this.awayPoints = awayPoints;
	}

	public List<Team> getTeamList() {
		return teamList;
	}

	public void setTeamList(List<Team> teamList) {
		this.teamList = teamList;
	}

	public void addTeam(Team team) {
		this.teamList.add(team);
		team.addMatch(this);
	}

	public List<UserMatches> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<UserMatches> orderList) {
		this.orderList = orderList;
	}

	public void addOrder(UserMatches userMatches) {
		this.orderList.add(userMatches);
	}

	public double getHomeWinRate() {
		return homeWinRate;
	}

	public void setHomeWinRate(double homeWinRate) {
		this.homeWinRate = homeWinRate;
	}

	public double getDrawRate() {
		return drawRate;
	}

	public void setDrawRate(double drawRate) {
		this.drawRate = drawRate;
	}

	public double getAwayWinRate() {
		return awayWinRate;
	}

	public void setAwayWinRate(double awayWinRate) {
		this.awayWinRate = awayWinRate;
	}

	public int getMatch_id() {
		return match_id;
	}

	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	@Override
	public String toString() {
		return "Matches [hometeam=" + hometeam + ", awayteam=" + awayteam + ", homescore=" + homescore + ", awayscore="
				+ awayscore + ", homePoints=" + homePoints + ", awayPoints=" + awayPoints + ", matchweek=" + matchweek
				+ ", homeWinRate=" + homeWinRate + ", drawRate=" + drawRate + ", awayWinRate=" + awayWinRate + "]";
	}

}
