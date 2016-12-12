package com.project.webapp.controllertest;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import com.project.webapp.controller.RegistractionController;
import com.project.webapp.controller.UserDao;
import com.project.webapp.domain.User;

public class RegistrationControllerTest {
	private RegistractionController rc ;

	@Mock
	private HttpServletRequest mockRequest;
	@Mock
	private HttpServletResponse mockResponse;
	@Mock
	private HttpSession mockSession;
	@Mock
	private UserDao mockUserDao;
	
	
	private User user;

	@Before
	public void setUp() {
		System.out.println("The Test starts!!");
		MockitoAnnotations.initMocks(this);
		rc = new RegistractionController(mockRequest,mockResponse,mockUserDao);
		
	}

	
	@Test
	public void doPost_method_Success_Test() throws ServletException, IOException{
		// Arrange
		Mockito.when(mockRequest.getParameter("username")).thenReturn("Godcrying");
		Mockito.when(mockRequest.getParameter("name")).thenReturn("Kai");
		Mockito.when(mockRequest.getParameter("surname")).thenReturn("Zhang");
		Mockito.when(mockRequest.getParameter("email")).thenReturn("kai.zhang9202@gmail.com");
		Mockito.when(mockRequest.getParameter("password")).thenReturn("211032@ZKztx");
		Mockito.when(mockRequest.getParameter("confirmpassword")).thenReturn("211032@ZKztx");
		Mockito.when(mockRequest.getParameter("age")).thenReturn("16/02/1992");
		// Act
		rc.doPost(mockRequest, mockResponse);
		// Assert
		verify(mockResponse).sendRedirect("HomePage.jsp");
	}
	
	
	@Test
	public void doPost_method_Fail_Test() throws ServletException, IOException{
		// Arrange
		Mockito.when(mockRequest.getParameter("username")).thenReturn("SomeUsername");
		Mockito.when(mockRequest.getParameter("name")).thenReturn("SomeName");
		Mockito.when(mockRequest.getParameter("surname")).thenReturn("SomeSurname");
		Mockito.when(mockRequest.getParameter("email")).thenReturn("Some@example.com");
		Mockito.when(mockRequest.getParameter("password")).thenReturn("211032@ZKztx");
		Mockito.when(mockRequest.getParameter("confirmpassword")).thenReturn("5873214");
		Mockito.when(mockRequest.getParameter("age")).thenReturn("16/02/2010");
		// Act
		rc.doPost(mockRequest, mockResponse);
		// Assert
		verify(mockResponse).sendRedirect("errorinformation.jsp");
	}

	@Test
	public void setterandgetter_UserName_Test(){
		//Arrange
		String user = "Godcrying";
		//Act
		rc.setUserNameRegister(user);
		String userNew = rc.getUserNameRegister();
		//Assert
		assertEquals(user,userNew);
	}
	
	@Test
	public void setterandgetter_UserEmail_Test(){
		// Arrange
		String email = "jackson.zhang1@hotmail.com";
		// Act
		rc.setEmailResgister(email);
		String emailNew = rc.getEmailResgister();
		// Assert
		assertEquals(email, emailNew);
	}
	
	@After
	public void tearDown() {
		System.out.println("The Test has done!!");
		rc= null;
	}

}
