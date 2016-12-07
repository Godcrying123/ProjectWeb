package com.project.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.project.webapp.dao.Datadao;
import com.project.webapp.domain.User;
import com.project.webapp.domain.UserMatches;
import com.project.webapp.model.Matches;

public class BetController implements BetService {

	private Datadao datadao;
	private EntityManager em;
	private UserDao userDao;
	private MatchesController matchesController;
	private User user;
	private UserMatches userMatches;

	public BetController() {
		this.em = datadao.getEm();
		this.datadao = datadao;
		this.userDao = new UserDao();
		this.matchesController = new MatchesController();
		this.user = new User();
		this.userMatches = new UserMatches();
	}

	public BetController(EntityManager em, Datadao datadao, UserDao userDao, MatchesController matchesController) {
		this.em = em;
		this.datadao = datadao;
		this.userDao = userDao;
		this.matchesController = matchesController;

	}

	public void save(Object object) {
		em.getTransaction().begin();
		em.persist(object);
		em.getTransaction().commit();
	}

	public void betMatch(String emailaddress, int match_id, double betamount, int bet) {

		user = (User) userDao.search(emailaddress);
		Matches matches = matchesController.searchMatchesbyId(match_id);
		userMatches = new UserMatches(betamount, bet);
		userMatches.setUser(user);
		userMatches.setMatches(matches);
		matches.addOrder(userMatches);
		user.addBettingOrder(userMatches);
		save(user);
		save(matches);
		save(userMatches);
	}

	public UserMatches getUserMatches() {
		return userMatches;
	}

	// public void betCancel(String emailaddress, int match_id) {
	//
	// user = (User) userDao.search(emailaddress);
	// Matches matches = matchesController.searchMatches(match_id);
	//
	// try {
	// List<UserMatches> betList = new ArrayList<UserMatches>();
	// betList = user.getBettingList();
	// } catch (javax.persistence.NoResultException e) {
	// System.out.println("Fail to find the User Matches table");
	// }
	//
	// }
	//
	// public double rewardGet(String emailaddress) {
	// Double rewards = 0.0d;
	//
	// user = (User) userDao.search(emailaddress);
	//
	// List<UserMatches> betList = new ArrayList<UserMatches>();
	// betList = userMatchSearch(emailaddress);
	// for (UserMatches userMatches : betList) {
	// Matches matches =
	// matchesController.searchMatches(userMatches.getMatches().getMatch_id());
	// switch (userMatches.getBet()) {
	// case 1:
	// if (matches.getHomescore() > matches.getAwayscore()) {
	// rewards = rewards + userMatches.getBetAmount() *
	// matches.getHomeWinRate();
	// }
	// break;
	// case 2:
	// if (matches.getHomescore() == matches.getAwayscore()) {
	// rewards = rewards + userMatches.getBetAmount() * matches.getDrawRate();
	//
	// }
	// break;
	// default:
	// if (matches.getHomescore() < matches.getAwayscore()) {
	// rewards = rewards + userMatches.getBetAmount() *
	// matches.getAwayWinRate();
	// }
	// break;
	// }
	// }
	// return rewards;
	// }
	//
	// public List<UserMatches> userMatchSearch(String emailaddress) {
	//
	// user = (User) userDao.search(emailaddress);
	// try {
	// List<UserMatches> betList = new ArrayList<UserMatches>();
	// betList = user.getBettingList();
	// return betList;
	// } catch (javax.persistence.NoResultException e) {
	// System.out.println("Fail to find the User Matches table");
	// return null;
	// }
	// }

	// public static void main(String[] args) {

	// BetController betController = new BetController();
	// betController.betMatch("jackson.zhang1@hotmail.com", 218, 100, 1);
	// List<UserMatches> betMatchList =
	// betController.userMatchSearch("jackson.zhang1@hotmail.com");
	//
	// for (UserMatches userMatches : betMatchList) {
	// System.out.println(userMatches);
	// }

	// }


}
