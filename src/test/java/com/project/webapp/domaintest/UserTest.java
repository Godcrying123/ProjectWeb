package com.project.webapp.domaintest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.project.webapp.domain.User;
import com.project.webapp.domain.UserMatches;

public class UserTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("The Test Starts");
	}

	@Test
	public void userGetterandSetterTest() {
		// Arrange
		User user = new User();
		// Act
		user.setUser_id(1);
		user.setUsername("Godcrying");
		user.setName("Kai");
		user.setSurname("Zhang");
		user.setPassword("211032@ZKztx");
		user.setConfirmpassword("211032@ZKztx");
		user.setEmailaddress("jackson.zhang1@hotmail.com");
		user.setAge(24);
		user.setAccount_Amount(1000.0);
		user.setFavouriteteam("Arsenal");
		int id = user.getUser_id();
		String username = user.getUsername();
		String name = user.getName();
		String surname = user.getSurname();
		String password = user.getPassword();
		String confirmPassword = user.getConfirmpassword();
		String email = user.getEmailaddress();
		int age = user.getAge();
		double amout = user.getAccount_Amount();
		String team = user.getFavouriteteam();
		// Assert
		assertEquals(id, 1);
		assertEquals(username, "Godcrying");
		assertEquals(name, "Kai");
		assertEquals(surname, "Zhang");
		assertEquals(password, "211032@ZKztx");
		assertEquals(confirmPassword, "211032@ZKztx");
		assertEquals(email, "jackson.zhang1@hotmail.com");
		assertEquals(age, 24);
		assertEquals(amout, 1000.0, 0.1);
		assertEquals(team, "Arsenal");
	}

	@Test
	public void toStringTesr() {
		// Arrange
		User user = new User("Godcrying", "Kai", "Zhang", "jackson.zhang1@hotmail.com", 1000.0d, "211032@ZKztx",
				"211032@ZKztx", 24, "Arsenal");
		// Act
		String out = "User [username=Godcrying, name=Kai, surname=Zhang, emailaddress=jackson.zhang1@hotmail.com, Account_Amount=1000.0, password=211032@ZKztx, confirmpassword=211032@ZKztx, age=24, favouriteteam=Arsenal, orderList0]";
		// Assert
		assertEquals(user.toString(), out);
	}

	@Test
	public void bettingListTest() {
		// Arrange
		User user = new User("Godcrying", "Kai", "Zhang", "jackson.zhang1@hotmail.com", 1000.0d, "211032@ZKztx",
				"211032@ZKztx", 24, "Arsenal");
		UserMatches bet1 = new UserMatches(1000, 1);
		UserMatches bet2 = new UserMatches(200.0, 2);
		boolean index1 = false;
		boolean index2 = false;
		List<UserMatches> betList1 = new ArrayList<UserMatches>();
		List<UserMatches> betList2 = new ArrayList<UserMatches>();
		List<UserMatches> betList3 = new ArrayList<UserMatches>();
		// Act
		user.addBettingOrder(bet1);
		user.addBettingOrder(bet2);
		betList1 = user.getBettingList();
		betList2.add(bet1);
		betList2.add(bet2);
		user.setBettingList(betList2);
		betList3 = user.getBettingList();
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
	public void testDone() {
		System.out.println("The test is done");
	}

}
