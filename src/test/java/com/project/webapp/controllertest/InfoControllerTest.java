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
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.project.webapp.controller.InfoController;
import com.project.webapp.controller.UserDao;
import com.project.webapp.domain.User;

public class InfoControllerTest {
	private InfoController infoController;
	private User user;

	@Mock
	HttpServletRequest mockRequest;
	@Mock
	HttpServletResponse mockReponse;
	@Mock
	HttpSession mockSession;
	@Mock
	UserDao mockUserDao;

	@Before
	public void setUp() throws Exception {
		System.out.println("THe Test starts!!");
		MockitoAnnotations.initMocks(this);
		infoController = new InfoController(mockRequest, mockReponse,
				mockUserDao);
	}

	@Test
	public void doPost_method_test() throws ServletException, IOException {
		// Arrange
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockRequest.getParameter("betamount")).thenReturn("1000.0");
		when(mockRequest.getSession().getAttribute("emailValidate"))
				.thenReturn("jackson.zhang1@hotmail.com");
		// Act
		infoController.doPost(mockRequest, mockReponse);
		// Assert
		verify(mockReponse).sendRedirect("HomePage.jsp");
	}

	@After
	public void teadDown() {
		System.out.println("The Test has done!!");
	}
}
