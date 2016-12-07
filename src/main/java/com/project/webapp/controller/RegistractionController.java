package com.project.webapp.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.project.webapp.domain.User;

/**
 * Servlet implementation class RegistractionController
 */
public class RegistractionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDao userDao;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Date validDate = null;
	private static String userNameRegister = null;
	private static String emailResgister = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistractionController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegistractionController(HttpServletRequest request,
			HttpServletResponse response, UserDao userDao) {
		this.request = request;
		this.response = response;
		this.userDao = userDao;
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
		PrintWriter out = response.getWriter();
		userDao = new UserDao();
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmpassword = request.getParameter("confirmpassword");
		String age = request.getParameter("age");
		// String favouriteteam = request.getParameter("chooseteam");
		String favouriteteam = "Arsenal";

		// Checking the age format
		boolean checkFormat;
		if (String.valueOf(age).matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")) {
			checkFormat = true;
		} else {
			checkFormat = false;
		}
		// Checking whether the age is over 18
		int Y = Integer.parseInt(age.substring(6, 10));
		int M = Integer.parseInt(age.substring(3, 5));
		int D = Integer.parseInt(age.substring(0, 2));
		LocalDate start = LocalDate.of(Y, M, D);
		LocalDate end = LocalDate.now();
		int years = (int) ChronoUnit.YEARS.between(start, end);

		try {
			if (PasswordValidator(password, confirmpassword) && (years >= 18)
					&& checkFormat) {
				User user = new User(username, name, surname, email, 0.0d,
						password, confirmpassword, years, favouriteteam);
				userDao.save(user);

				userNameRegister = username;
				emailResgister = email;

				response.sendRedirect("HomePage.jsp");
			}
		} catch (Exception e) {
			System.out.println("Wrong information inputing");
			response.sendRedirect("errorinformation.jsp");
			e.printStackTrace();
		}
	}

	public static String getUserNameRegister() {
		return userNameRegister;
	}

	public static String getEmailResgister() {
		return emailResgister;
	}

	public static void setUserNameRegister(String userNameRegister) {
		RegistractionController.userNameRegister = userNameRegister;
	}

	public static void setEmailResgister(String emailResgister) {
		RegistractionController.emailResgister = emailResgister;
	}

	public boolean PasswordValidator(String password, String confirmpassword) {

		/**
		 * Validate password with regular expression
		 * 
		 * @param password
		 *            password for validation
		 * @return true valid password, false invalid password
		 */
		Pattern pattern;
		Matcher matcher;

		final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

		pattern = Pattern.compile(PASSWORD_PATTERN);
		matcher = pattern.matcher(password);
		return matcher.matches() && (password.equals(confirmpassword));

	}
}
