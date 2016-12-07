package com.project.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.webapp.domain.User;

/**
 * Servlet implementation class InfoController
 */
public class InfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private UserDao userDao;
	private User user;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InfoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InfoController(HttpServletRequest request, HttpServletResponse response, UserDao userDao) {
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
		try {
			String email = (String) request.getSession().getAttribute("emailValidate");
			userDao = new UserDao();
			Double amount = Double.valueOf(request.getParameter("betamount"));
			user = (User) userDao.search(email);
			Double TotalAmount = user.getAccount_Amount() + amount;
			user.setAccount_Amount(TotalAmount);
			userDao.save(user);
			response.sendRedirect("HomePage.jsp");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
