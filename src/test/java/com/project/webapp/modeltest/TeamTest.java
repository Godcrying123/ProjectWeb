package com.project.webapp.modeltest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.project.webapp.model.Matches;
import com.project.webapp.model.Team;

public class TeamTest {

	@Before
	public void setUp() {
		System.out.println("This test starts!!");
	}

	@Test
	public void setterTest() {
		// Arrange
		Team team = new Team();
		// Act
		team.setTeam_id(1);
		team.setTeamname("Arsenal");
		team.setShortname("AR");
		team.setScore(3);
		team.setPoints(58);
		int id = team.getTeam_id();
		String name = team.getTeamname();
		String shortname = team.getShortname();
		int score = team.getScore();
		int points = team.getPoints();
		// Assert
		assertEquals(1, id);
		assertEquals("Arsenal", name);
		assertEquals("AR", shortname);
		assertEquals(3, score);
		assertEquals(58, points);
	}

	@Test
	public void compareTest() {
		// Arrange
		Team team1 = new Team();
		Team team2 = new Team(4, "Chelsea", "CH", 3, 58);
		Team team3 = new Team(5, "Arsenal", "AR", 5, 49);
		// Act
		int compare = team1.compare(team2, team3);
		// Assert
		assertEquals(compare, 1);
	}

	@Test
	public void addMatchListTest() {
		// Arrange
		List<Matches> matchList1 = new ArrayList<Matches>();
		List<Matches> matchList2 = new ArrayList<Matches>();
		List<Matches> matchList3 = new ArrayList<Matches>();
		boolean index1 = false;
		boolean index2 = false;
		Team team = new Team(4, "Chelsea", "CH", 3, 58);
		Matches matches1 = new Matches(1, 2, 5, 3, 0, 3, 1, 1.5, 2.5, 2.8,
				"17:00");
		Matches matches2 = new Matches(1, 2, 5, 3, 0, 3, 1, 1.5, 2.5, 2.8,
				"17:00");
		int index = 0;
		// Act
		team.addMatch(matches1);
		team.addMatch(matches2);
		matchList1 = team.getMatchesList();
		matchList2.add(matches1);
		matchList2.add(matches2);
		team.setMatchesList(matchList2);
		matchList3 = team.getMatchesList();
		// Assert
		if (matchList1.equals(matchList2)) {
			index1 = true;
		}
		if (matchList3.equals(matchList2)) {
			index2 = true;
		}
		assertEquals(index1, true);
		assertEquals(index2, true);

	}

	@Test
	public void toStringTest() {
		// Arrange
		Team team = new Team(4, "Chelsea", "CH", 3, 58);
		;
		// Act
		String out = "Team [team_id=2, teamname=Chelsea, score=58, points=3, matchesList=[]]";
		// Assert
		assertEquals(team.toString(), out);
	}

	@After
	public void done() {
		System.out.println("The Test is Done!!");
	}

}
