package com.project.webapp.domaintest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.project.webapp.domain.User;
import com.project.webapp.domain.UserMatches;
import com.project.webapp.model.Matches;

public class UserMatchTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("The Test starts!!");
	}

	@Test
	public void UserMatchGetterandSetterTest() {
		// Arrange
		UserMatches bet = new UserMatches();
		// Act
		bet.setBet(1);
		bet.setBet_id(25);
		bet.setBetAmount(1000.0d);
		int id = bet.getBet_id();
		int betchoice = bet.getBet();
		double amount = bet.getBetAmount();
		// Assert
		assertEquals(id, 25);
		assertEquals(betchoice, 1);
		assertEquals(amount, 1000.0, 0.1);
	}

	@Test
	public void toStringTest() {
		// Arrange
		UserMatches bet = new UserMatches(1000, 1);
		// Act
		String out = "UserMatches [bet_id=0, betAmount=1000.0, bet=1, user=null, matches=null]";
		// Assert
		assertEquals(bet.toString(), out);
	}

	@Test
	public void addMatchTest() {
		// Arrange
		UserMatches bet = new UserMatches(1000, 1);
		Matches matches1 = new Matches(1, 2, 5, 3, 0, 3, 1, 1.5, 2.5, 2.8, "17:00");
		Matches matches2 = new Matches();
		Matches matches3 = new Matches();
		boolean index1 = false;
		boolean index2 = false;
		// Act
		bet.setMatches(matches1);
		matches2 = bet.getMatches();
		matches3 = matches1;
		// Assert
		if (matches1 == matches2) {
			index1 = true;
		}
		if (matches3 == matches1) {
			index2 = true;
		}
		assertEquals(index1, true);
		assertEquals(index2, true);
	}

	@Test
	public void addUserTest() {
		// Arrange
		UserMatches bet = new UserMatches(1000, 1);
		User user1 = new User("Godcrying", "Kai", "Zhang", "jackson.zhang1@hotmail.com", 1000.0d, "211032@ZKztx",
				"211032@ZKztx", 24, "Arsenal");
		User user2 = new User();
		User user3 = new User();
		boolean index1 = false;
		boolean index2 = false;
		// Act
		bet.setUser(user1);
		user2 = bet.getUser();
		user3 = user1;
		// Assert
		if (user1 == user2) {
			index1 = true;
		}
		if (user1 == user3) {
			index2 = true;
		}
		assertEquals(index1, true);
		assertEquals(index2, true);
	}

	@After
	public void testDone() {
		System.out.println("The Test has done!!");
	}

}
