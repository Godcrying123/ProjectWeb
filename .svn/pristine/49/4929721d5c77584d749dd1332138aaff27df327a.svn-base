package com.project.webapp.controllertest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

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
	@Mock
	UserMatches mockUserMatches;

	@Before
	public void setUp() throws Exception {
		System.out.println("The Test Starts!!");
		MockitoAnnotations.initMocks(this);
		betController = new BetController(mockEm, mockDao, mockUserDao,
				mockMatchController);
		Mockito.when(mockEm.getTransaction()).thenReturn(mockTransaction);

	}

	@Test
	public void save_method_test() {
		// Arrange

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
		when(mockUserDao.search("jackson.zhang1@hotmail.com")).thenReturn(
				mockUser);
		when(mockMatchController.searchMatchesbyId(anyInt())).thenReturn(
				mockMatches);
		// Act
		betController.betMatch("jackson.zhang1@hotmail.com", 211, 100.0d, 1);
		// Assert

	}

	@After
	public void testDone() {
		System.out.println("The Test has done!!");
	}

}
