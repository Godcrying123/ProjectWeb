package com.project.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.webapp.domain.User;
import com.project.webapp.domain.UserMatches;
import com.project.webapp.model.Matches;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	private static String userNameValidate = null;
	private static String emailValidate = null;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private boolean isPresent = false;
	private User user;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		userDao = new UserDao();

		// TODO Auto-generated constructor stub
	}

	public LoginController(HttpServletRequest request,
			HttpServletResponse response, UserDao userDao, boolean isPresent) {
		this.response = response;
		this.request = request;
		this.userDao = userDao;
		this.isPresent = isPresent;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Login Form Controller
		String username = request.getParameter("usernamelog");
		String emaillog = request.getParameter("emaillog");
		String passwordlog = request.getParameter("passwordlog");
		boolean isPresent = userDao.validate(username, emaillog, passwordlog);
		if (isPresent == true) {
			this.user = (User) userDao.search(emaillog);
			setUser(user);
			response.sendRedirect("HomePage.jsp");
			setUserNameValidate(username);
			emailValidate = emaillog;
			setEmailValidate(emaillog);
		} else {
			response.sendRedirect("errorinformation.jsp");
		}
	}

	public void setUserNameValidate(String userNameValidate) {
		this.userNameValidate = userNameValidate;
	}

	public void setEmailValidate(String emailValidate) {
		this.emailValidate = emailValidate;
	}

	public String getUserNameValidate() {
		return userNameValidate;
	}

	public String getEmailValidate() {
		return emailValidate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
