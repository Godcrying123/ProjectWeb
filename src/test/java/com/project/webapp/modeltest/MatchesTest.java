package com.project.webapp.modeltest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.project.webapp.domain.UserMatches;
import com.project.webapp.model.Matches;
import com.project.webapp.model.Team;

public class MatchesTest {

	@Before
	public void setUp() {
		System.out.println("The Test starts!!");
	}

	@Test
	public void getterAndsetterTest() {
		// Arrange
		Matches matches = new Matches();
		// Act
		matches.setMatch_id(222);
		matches.setHometeam(1);
		matches.setAwayteam(2);
		matches.setHomescore(3);
		matches.setAwayscore(2);
		matches.setHomePoints(59);
		matches.setAwayPoints(78);
		matches.setHomeWinRate(1.5);
		matches.setDrawRate(2.5);
		matches.setAwayWinRate(4.5);
		matches.setMatchweek(1);
		matches.setStartTime("17:00 Sunday");
		int id = matches.getMatch_id();
		int homeTeam = matches.getHometeam();
		int awayTeam = matches.getAwayteam();
		int homeScore = matches.getHomescore();
		int awayScore = matches.getAwayscore();
		int homePoints = matches.getHomePoints();
		int awayPoints = matches.getAwayPoints();
		double homeRate = matches.getHomeWinRate();
		double drawRate = matches.getDrawRate();
		double awayRate = matches.getAwayWinRate();
		int matchweek = matches.getMatchweek();
		String time = matches.getStartTime();
		// Assert
		assertEquals(id, 222);
		assertEquals(homeTeam, 1);
		assertEquals(awayTeam, 2);
		assertEquals(homeScore, 3);
		assertEquals(awayScore, 2);
		assertEquals(homePoints, 59);
		assertEquals(awayPoints, 78);
		assertEquals(homeRate, 1.5d, 0.1);
		assertEquals(drawRate, 2.5, 0.1);
		assertEquals(awayRate, 4.5, 0.1);
		assertEquals(matchweek, 1);
		assertEquals(time, "17:00 Sunday");

	}

	@Test
	public void toStringTest() {
		// Arrange
		Matches matches = new Matches(1, 2, 5, 3, 0, 3, 1, 1.5, 2.5, 2.8, "17:00");
		// Act
		String out = "Matches [hometeam=1, awayteam=2, homescore=5, awayscore=3, homePoints=0, awayPoints=3, matchweek=1, homeWinRate=1.5, drawRate=2.5, awayWinRate=2.8]";
		// Assert
		assertEquals(matches.toString(), out);
	}

	@Test
	public void TeamListTest() {
		// Arrange
		Matches matches = new Matches(1, 2, 5, 3, 0, 3, 1, 1.5, 2.5, 2.8, "17:00");
		Team team1 = new Team(2, "Chelsea", "CH", 3, 58);
		Team team2 = new Team(3, "Arsenal", "AR", 5, 49);
		boolean index1 = false;
		boolean index2 = false;
		List<Team> teamList1 = new ArrayList<Team>();
		List<Team> teamList2 = new ArrayList<Team>();
		List<Team> teamList3 = new ArrayList<Team>();
		// Act
		matches.addTeam(team1);
		matches.addTeam(team2);
		teamList1 = matches.getTeamList();
		teamList2.add(team1);
		teamList2.add(team2);
		matches.setTeamList(teamList2);
		teamList3 = matches.getTeamList();
		// Assert
		if (teamList1.equals(teamList2)) {
			index1 = true;
		}
		if (teamList3.equals(teamList2)) {
			index2 = true;
		}
		assertEquals(index1, true);
		assertEquals(index2, true);
	}

	@Test
	public void orderListTest() {
		// Arrange
		Matches matches = new Matches(1, 2, 5, 3, 0, 3, 1, 1.5, 2.5, 2.8, "17:00");
		UserMatches bet1 = new UserMatches(100.0, 1);
		UserMatches bet2 = new UserMatches(200.0, 2);
		boolean index1 = false;
		boolean index2 = false;
		List<UserMatches> betList1 = new ArrayList<UserMatches>();
		List<UserMatches> betList2 = new ArrayList<UserMatches>();
		List<UserMatches> betList3 = new ArrayList<UserMatches>();
		// Act
		matches.addOrder(bet1);
		matches.addOrder(bet2);
		betList1 = matches.getOrderList();
		betList2.add(bet1);
		betList2.add(bet2);
		matches.setOrderList(betList2);
		betList3 = matches.getOrderList();
		// Assert
		if (betList1.equals(betList2)) {
			index1 = true;
		}
		if (betList3.equals(betList2)) {
			index2 = true;
		}
		assertEquals(index1, true);
		assertEquals(index2, true);
	}

	@After
	public void done() {
		System.out.println("The Test has done!!");
	}

}
