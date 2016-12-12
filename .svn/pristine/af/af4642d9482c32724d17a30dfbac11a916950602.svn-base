package com.project.webapp.controllertest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.project.webapp.controller.BetController;
import com.project.webapp.controller.BetMatchController;
import com.project.webapp.controller.InfoController;
import com.project.webapp.controller.UserDao;
import com.project.webapp.domain.User;

public class BetMatchControllerTest {

	private BetMatchController betMatchController;

	@Mock
	HttpServletRequest mockRequest;
	@Mock
	HttpServletResponse mockResponse;
	@Mock
	HttpSession mockSession;
	@Mock
	UserDao mockUserDao;
	@Mock
	BetController mockBetController;
	@Mock
	User mockUser;

	@Before
	public void setUp() {
		System.out.println("The Test starts!!");
		MockitoAnnotations.initMocks(this);
		betMatchController = new BetMatchController(mockBetController,
				mockRequest, mockResponse, mockUserDao);

	}

	@Test
	public void do_Post_Bet1_method_Test() throws ServletException, IOException {
		// Arrange
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockRequest.getParameter("betTeam1")).thenReturn("1");
		when(mockRequest.getParameter("bet1")).thenReturn("100");
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockSession.getAttribute("emailValidate")).thenReturn(
				"jackson.zhang1@hotmail.com");
		when(mockUserDao.search("jackson.zhang1@hotmail.com")).thenReturn(
				mockUser);
		// Act
		betMatchController.doPost(mockRequest, mockResponse);
		// Assert
		verify(mockResponse).sendRedirect("HomePage.jsp");

	}

	@Test
	public void do_Post_Bet2_method_Test() throws ServletException, IOException {
		// Arrange
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockRequest.getParameter("betTeam2")).thenReturn("1");
		when(mockRequest.getParameter("bet2")).thenReturn("100");
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockSession.getAttribute("emailValidate")).thenReturn(
				"jackson.zhang1@hotmail.com");
		when(mockUserDao.search("jackson.zhang1@hotmail.com")).thenReturn(
				mockUser);
		// Act
		betMatchController.doPost(mockRequest, mockResponse);
		// Assert
		verify(mockResponse).sendRedirect("HomePage.jsp");

	}

	@Test
	public void do_Post_Bet3_method_Test() throws ServletException, IOException {
		// Arrange
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockRequest.getParameter("betTeam3")).thenReturn("1");
		when(mockRequest.getParameter("bet3")).thenReturn("100");
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockSession.getAttribute("emailValidate")).thenReturn(
				"jackson.zhang1@hotmail.com");
		when(mockUserDao.search("jackson.zhang1@hotmail.com")).thenReturn(
				mockUser);
		// Act
		betMatchController.doPost(mockRequest, mockResponse);
		// Assert
		verify(mockResponse).sendRedirect("HomePage.jsp");

	}

	@Test
	public void do_Post_Bet4_method_Test() throws ServletException, IOException {
		// Arrange
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockRequest.getParameter("betTeam4")).thenReturn("1");
		when(mockRequest.getParameter("bet4")).thenReturn("100");
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockSession.getAttribute("emailValidate")).thenReturn(
				"jackson.zhang1@hotmail.com");
		when(mockUserDao.search("jackson.zhang1@hotmail.com")).thenReturn(
				mockUser);
		// Act
		betMatchController.doPost(mockRequest, mockResponse);
		// Assert
		verify(mockResponse).sendRedirect("HomePage.jsp");

	}

	@Test
	public void do_Post_Bet5_method_Test() throws ServletException, IOException {
		// Arrange
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockRequest.getParameter("betTeam5")).thenReturn("1");
		when(mockRequest.getParameter("bet5")).thenReturn("100");
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockSession.getAttribute("emailValidate")).thenReturn(
				"jackson.zhang1@hotmail.com");
		when(mockUserDao.search("jackson.zhang1@hotmail.com")).thenReturn(
				mockUser);
		// Act
		betMatchController.doPost(mockRequest, mockResponse);
		// Assert
		verify(mockResponse).sendRedirect("HomePage.jsp");

	}

	@Test
	public void do_Post_Bet6_method_Test() throws ServletException, IOException {
		// Arrange
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockRequest.getParameter("betTeam6")).thenReturn("1");
		when(mockRequest.getParameter("bet6")).thenReturn("100");
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockSession.getAttribute("emailValidate")).thenReturn(
				"jackson.zhang1@hotmail.com");
		when(mockUserDao.search("jackson.zhang1@hotmail.com")).thenReturn(
				mockUser);
		// Act
		betMatchController.doPost(mockRequest, mockResponse);
		// Assert
		verify(mockResponse).sendRedirect("HomePage.jsp");

	}

	@Test
	public void do_Post_Bet7_method_Test() throws ServletException, IOException {
		// Arrange
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockRequest.getParameter("betTeam7")).thenReturn("1");
		when(mockRequest.getParameter("bet7")).thenReturn("100");
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockSession.getAttribute("emailValidate")).thenReturn(
				"jackson.zhang1@hotmail.com");
		when(mockUserDao.search("jackson.zhang1@hotmail.com")).thenReturn(
				mockUser);
		// Act
		betMatchController.doPost(mockRequest, mockResponse);
		// Assert
		verify(mockResponse).sendRedirect("HomePage.jsp");

	}

	@Test
	public void do_Post_Bet8_method_Test() throws ServletException, IOException {
		// Arrange
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockRequest.getParameter("betTeam8")).thenReturn("1");
		when(mockRequest.getParameter("bet8")).thenReturn("100");
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockSession.getAttribute("emailValidate")).thenReturn(
				"jackson.zhang1@hotmail.com");
		when(mockUserDao.search("jackson.zhang1@hotmail.com")).thenReturn(
				mockUser);
		// Act
		betMatchController.doPost(mockRequest, mockResponse);
		// Assert
		verify(mockResponse).sendRedirect("HomePage.jsp");

	}

	@Test
	public void do_Post_Bet9_method_Test() throws ServletException, IOException {
		// Arrange
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockRequest.getParameter("betTeam9")).thenReturn("1");
		when(mockRequest.getParameter("bet9")).thenReturn("100");
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockSession.getAttribute("emailValidate")).thenReturn(
				"jackson.zhang1@hotmail.com");
		when(mockUserDao.search("jackson.zhang1@hotmail.com")).thenReturn(
				mockUser);
		// Act
		betMatchController.doPost(mockRequest, mockResponse);
		// Assert
		verify(mockResponse).sendRedirect("HomePage.jsp");

	}

	@Test
	public void do_Post_Bet10_method_Test() throws ServletException, IOException {
		// Arrange
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockRequest.getParameter("betTeam10")).thenReturn("1");
		when(mockRequest.getParameter("bet10")).thenReturn("100");
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockSession.getAttribute("emailValidate")).thenReturn("jackson.zhang1@hotmail.com");
		when(mockUserDao.search("jackson.zhang1@hotmail.com")).thenReturn(mockUser);
		// Act
		betMatchController.doPost(mockRequest, mockResponse);
		// Assert
		verify(mockResponse).sendRedirect("HomePage.jsp");

	}

	@Test
	public void match_id_setterandgetter_Test() {
		// Arrange
		int match_id = 1;
		// Act
		betMatchController.setMatch_id(match_id);
		int match_idNew = betMatchController.getMatch_id();
		// Assert
		assertEquals(match_id, match_idNew);
	}

	@Test
	public void bet_setterandgetter_Test() {
		// Arrange
		int bet = 1;
		// Act
		betMatchController.setBet(bet);
		int betNew = betMatchController.getBet();
		// Assert
		assertEquals(bet, betNew);
	}

	@Test
	public void betAmount_setterandgetter_Test() {
		// Arrange
		String betAmount = "10000";
		// Act
		betMatchController.setBetAmount(betAmount);
		String betAmountNew = betMatchController.getBetAmount();
		// Assert
		assertEquals(betAmount, betAmountNew);
	}

	@After
	public void tearDown() {
		System.out.println("The Test has done!!");

	}

}
