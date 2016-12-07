package com.project.webapp.controllertest;

import static org.junit.Assert.*;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.project.webapp.controller.LoginController;
import com.project.webapp.controller.UserDao;
import com.project.webapp.controller.UserService;
import com.project.webapp.dao.Datadao;
import com.project.webapp.domain.User;

public class LoginControllerTest {
	LoginController loginController;
	boolean isPresent;
	
	@Mock
	HttpServletResponse mockResponse;
	@Mock
	HttpServletRequest mockRequest;
	@Mock
	UserDao mockUserDao;
	@Mock
	User mockUser;
	

	@Before
	public void setUp() {
		System.out.println("The Test starts!!");
		MockitoAnnotations.initMocks(this);
		loginController = new LoginController(mockRequest, mockResponse,
				mockUserDao, isPresent);
	}


	@Test
	public void validate_method_Test() throws ServletException, IOException {
		//Arrange
		Mockito.when(mockRequest.getParameter("usernamelog")).thenReturn("someone");
		Mockito.when(mockRequest.getParameter("emaillog")).thenReturn("someone@example.com");
		Mockito.when(mockRequest.getParameter("passwordlog")).thenReturn("211032@ZKztx");
		//Act
		loginController.doPost(mockRequest, mockResponse);
		//Assert
		verify(mockResponse).sendRedirect("registraction.jsp");
		
	}
	
	@Test
	public void setterandgetter_UserEmail_Test(){
		// Arrange
		String email = "jackson.zhang1@hotmail.com";
		// Act
		loginController.setEmailValidate(email);;
		String emailNew = loginController.getEmailValidate();
		// Assert
		assertEquals(email, emailNew);
	}
	
	@Test
	public void setterandgetter_UserName_Test(){
		//Arrange
		String user = "Godcrying";
		//Act
		loginController.setUserNameValidate(user);
		String userNew = loginController.getUserNameValidate();
		//Assert
		assertEquals(user,userNew);
	}
	
	@Test
	public void setterandgetter_User_Test(){
		// Arrange
		
		// Act
		loginController.setUser(mockUser);
		User userNew = loginController.getUser();
		// Assert
		assertEquals(userNew, mockUser);
	}
	
	@After
	public void tearDown() {
		System.out.println("The Test has done!!");
	}

}
