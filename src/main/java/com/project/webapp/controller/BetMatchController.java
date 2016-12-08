package com.project.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.webapp.domain.User;
import com.project.webapp.domain.UserMatches;
import com.project.webapp.model.Matches;

/**
 * Servlet implementation class BetMatchController
 */
public class BetMatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private BetController betController;
	private int match_id = 0;
	private String betAmount = null;
	private UserDao userDao;
	private User user;
	private int bet;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BetMatchController() {

		super();
		this.match_id = match_id;
		this.betAmount = betAmount;
		this.userDao = new UserDao();
		this.user = new User();
		this.betController = new BetController();
		// TODO Auto-generated constructor stub
	}

	public BetMatchController(BetController betController, HttpServletRequest request,
			HttpServletResponse response, UserDao userDao) {
		this.request = request;
		this.response = response;
		this.userDao = userDao;
		this.user = user;
		this.betController = betController;
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
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute(
				"emailValidate");
		user = (User) userDao.search(email);

		if (request.getParameter("betTeam1") != null) {
			bet = Integer.valueOf(request.getParameter("betTeam1"));
			betAmount = request.getParameter("bet1");
			match_id = 211;
			betController.betMatch(email, match_id, Double.valueOf(betAmount),
					Integer.valueOf(request.getParameter("betTeam1")));
			Double TotalAmount = user.getAccount_Amount()
					- Double.valueOf(betAmount);
			user.setAccount_Amount(TotalAmount);
			userDao.save(user);
			response.sendRedirect("HomePage.jsp");
		}
		if (request.getParameter("betTeam2") != null) {
			bet = Integer.valueOf(request.getParameter("betTeam2"));
			betAmount = request.getParameter("bet2");
			match_id = 212;
			betController.betMatch(email, match_id, Double.valueOf(betAmount),
					Integer.valueOf(request.getParameter("betTeam2")));
			Double TotalAmount = user.getAccount_Amount()
					- Double.valueOf(betAmount);
			user.setAccount_Amount(TotalAmount);
			userDao.save(user);
			response.sendRedirect("HomePage.jsp");
		}
		if (request.getParameter("betTeam3") != null) {
			bet = Integer.valueOf(request.getParameter("betTeam3"));
			betAmount = request.getParameter("bet3");
			match_id = 213;
			betController.betMatch(email, match_id, Double.valueOf(betAmount),
					Integer.valueOf(request.getParameter("betTeam3")));
			Double TotalAmount = user.getAccount_Amount()
					- Double.valueOf(betAmount);
			user.setAccount_Amount(TotalAmount);
			userDao.save(user);
			response.sendRedirect("HomePage.jsp");
		}
		if (request.getParameter("betTeam4") != null) {
			bet = Integer.valueOf(request.getParameter("betTeam4"));
			betAmount = request.getParameter("bet4");
			match_id = 214;
			betController.betMatch(email, match_id, Double.valueOf(betAmount),
					Integer.valueOf(request.getParameter("betTeam4")));
			Double TotalAmount = user.getAccount_Amount()
					- Double.valueOf(betAmount);
			user.setAccount_Amount(TotalAmount);
			userDao.save(user);
			response.sendRedirect("HomePage.jsp");
		}
		if (request.getParameter("betTeam5") != null) {
			bet = Integer.valueOf(request.getParameter("betTeam5"));
			betAmount = request.getParameter("bet5");
			match_id = 215;
			betController.betMatch(email, match_id, Double.valueOf(betAmount),
					Integer.valueOf(request.getParameter("betTeam5")));
			Double TotalAmount = user.getAccount_Amount()
					- Double.valueOf(betAmount);
			user.setAccount_Amount(TotalAmount);
			userDao.save(user);
			response.sendRedirect("HomePage.jsp");
		}
		if (request.getParameter("betTeam6") != null) {
			bet = Integer.valueOf(request.getParameter("betTeam6"));
			betAmount = request.getParameter("bet6");
			match_id = 216;
			betController.betMatch(email, match_id, Double.valueOf(betAmount),
					Integer.valueOf(request.getParameter("betTeam6")));
			Double TotalAmount = user.getAccount_Amount()
					- Double.valueOf(betAmount);
			user.setAccount_Amount(TotalAmount);
			userDao.save(user);
			response.sendRedirect("HomePage.jsp");
		}
		if (request.getParameter("betTeam7") != null) {
			bet = Integer.valueOf(request.getParameter("betTeam7"));
			betAmount = request.getParameter("bet7");
			match_id = 217;
			betController.betMatch(email, match_id, Double.valueOf(betAmount),
					Integer.valueOf(request.getParameter("betTeam7")));
			Double TotalAmount = user.getAccount_Amount()
					- Double.valueOf(betAmount);
			user.setAccount_Amount(TotalAmount);
			userDao.save(user);
			response.sendRedirect("HomePage.jsp");
		}
		if (request.getParameter("betTeam8") != null) {
			bet = Integer.valueOf(request.getParameter("betTeam8"));
			betAmount = request.getParameter("bet8");
			match_id = 218;
			betController.betMatch(email, match_id, Double.valueOf(betAmount),
					Integer.valueOf(request.getParameter("betTeam8")));
			Double TotalAmount = user.getAccount_Amount()
					- Double.valueOf(betAmount);
			user.setAccount_Amount(TotalAmount);
			userDao.save(user);
			response.sendRedirect("HomePage.jsp");
		}
		if (request.getParameter("betTeam9") != null) {
			bet = Integer.valueOf(request.getParameter("betTeam9"));
			betAmount = request.getParameter("bet9");
			match_id = 219;
			betController.betMatch(email, match_id, Double.valueOf(betAmount),
					Integer.valueOf(request.getParameter("betTeam9")));
			Double TotalAmount = user.getAccount_Amount()
					- Double.valueOf(betAmount);
			user.setAccount_Amount(TotalAmount);
			userDao.save(user);
			response.sendRedirect("HomePage.jsp");
		}
		if (request.getParameter("betTeam10") != null) {
			bet = Integer.valueOf(request.getParameter("betTeam10"));
			betAmount = request.getParameter("bet10");
			match_id = 220;
			betController.betMatch(email, match_id, Double.valueOf(betAmount),
					Integer.valueOf(request.getParameter("betTeam10")));
			Double TotalAmount = user.getAccount_Amount()
					- Double.valueOf(betAmount);
			user.setAccount_Amount(TotalAmount);
			userDao.save(user);
			response.sendRedirect("HomePage.jsp");
		}

	}

	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}

	public void setBetAmount(String betAmount) {
		this.betAmount = betAmount;
	}

	public void setBet(int bet) {
		this.bet = bet;
	}

	public int getBet() {
		return bet;
	}

	public int getMatch_id() {
		return match_id;
	}

	public String getBetAmount() {
		return betAmount;
	}

}
