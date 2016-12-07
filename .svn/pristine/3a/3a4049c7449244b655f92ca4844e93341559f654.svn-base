package com.project.webapp.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Teams")
public class Team implements Comparator<Team> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int T_id;
	private int team_id;
	private String teamname;
	private String shortname;
	private int score;
	private int points;
	// private int matchWeek;

	@ManyToMany
	private List<Matches> matchesList;

	public Team() {

	}

	public Team(int team_id, String teamname, String shortname, int points,
			int score) {
		super();
		this.team_id = team_id;
		this.teamname = teamname;
		this.shortname = shortname;
		this.points = points;
		this.score = score;
		this.matchesList = new ArrayList<Matches>();
	}

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public List<Matches> getMatchesList() {
		return matchesList;
	}

	public void setMatchesList(List<Matches> matchesList) {
		this.matchesList = matchesList;
	}

	public void addMatch(Matches match) {
		this.matchesList.add(match);
	}

	@Override
	public String toString() {
		return "Team [team_id=" + team_id + ", teamname=" + teamname
				+ ", score=" + score + ", points=" + points + ", matchesList="
				+ matchesList + "]";
	}

	public int compare(Team o1, Team o2) {
		// TODO Auto-generated method stub
		return o1.points < o2.points ? 1 : (o1.points > o2.points ? -1 : 0);

	}

}
