package com.project.webapp.controllertest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.project.webapp.controller.BetController;
import com.project.webapp.controller.BetService;
import com.project.webapp.controller.MatchesController;
import com.project.webapp.controller.UserDao;
import com.project.webapp.dao.Datadao;
import com.project.webapp.domain.User;
import com.project.webapp.domain.UserMatches;
import com.project.webapp.model.Matches;

public class BetControllerTest {

	private BetService betController;
	private User user;
	private Matches matches;

	@Mock
	EntityManagerFactory mockEmf;
	@Mock
	EntityManager mockEm;
	@Mock
	EntityTransaction mockTransaction;
	@Mock
	UserDao mockUserDao;
	@Mock
	MatchesController mockMatchController;
	@Mock
	Matches mockMatches;
	@Mock
	UserMatches mockBet;
	@Mock
	Datadao mockDao;
	@Mock
	User mockUser;

	@Before
	public void setUp() throws Exception {
		System.out.println("The Test Starts!!");
		MockitoAnnotations.initMocks(this);
		betController = new BetController();
		betController = new BetController(mockEm, mockDao, mockUserDao,
				mockMatchController);
	}

	@Test
	public void save_method_test() {
		// Arrange
		Mockito.when(mockEm.getTransaction()).thenReturn(mockTransaction);
		// Act
		betController.save(mockUser);
		// Assert
		verify(mockEm, times(2)).getTransaction();
		verify(mockEm).persist(mockUser);
		verify(mockTransaction).commit();
		verify(mockTransaction).begin();
	}

	@Test
	public void betMatch_method_Test() {
		// Arrange
		UserDao userDao = new UserDao();
		MatchesController matchesController = new MatchesController();
		// Act

	}

	@After
	public void testDone() {
		System.out.println("The Test has done!!");
	}

}
