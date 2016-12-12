package com.project.webapp.model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.mockito.cglib.core.CollectionUtils;

import java.io.IOException;

import com.project.webapp.controller.UserDao;
import com.project.webapp.controller.MatchesController;
import com.project.webapp.domain.User;
import com.project.webapp.domain.UserMatches;

public class Main {

	public static void main(String[] args) {

		UserDao userDao = new UserDao();
		MatchesController matchController = new MatchesController();

		Team team1 = new Team(1, "AFC Bournemouth", "AB", 0, 0);
		Team team2 = new Team(2, "Arsenal", "AR", 0, 0);
		Team team3 = new Team(3, "Burnley", "BU", 0, 0);
		Team team4 = new Team(4, "Chelsea", "CH", 0, 0);
		Team team5 = new Team(5, "Crystal Palace", "CP", 0, 0);
		Team team6 = new Team(6, "Everton", "ET", 0, 0);
		Team team7 = new Team(7, "Hull City", "HC", 0, 0);
		Team team8 = new Team(8, "Leicester", "LC", 0, 0);
		Team team9 = new Team(9, "Liverpool", "LV", 0, 0);
		Team team10 = new Team(10, "Manchester City", "MC", 0, 0);
		Team team11 = new Team(11, "Manchester United", "MU", 0, 0);
		Team team12 = new Team(12, "Middlesbrough", "ML", 0, 0);
		Team team13 = new Team(13, "Southampton", "SH", 0, 0);
		Team team14 = new Team(14, "Stoke City", "SC", 0, 0);
		Team team15 = new Team(15, "Sunderland", "SL", 0, 0);
		Team team16 = new Team(16, "Swansea City", "SW", 0, 0);
		Team team17 = new Team(17, "Tottenham Hotspur", "TH", 0, 0);
		Team team18 = new Team(18, "Watford", "WF", 0, 0);
		Team team19 = new Team(19, "West Bromwich Albion", "WB", 0, 0);
		Team team20 = new Team(20, "West Ham United", "WH", 0, 0);

		matchController.save(team1);
		matchController.save(team2);
		matchController.save(team3);
		matchController.save(team4);
		matchController.save(team5);
		matchController.save(team6);
		matchController.save(team7);
		matchController.save(team8);
		matchController.save(team9);
		matchController.save(team10);
		matchController.save(team11);
		matchController.save(team12);
		matchController.save(team13);
		matchController.save(team14);
		matchController.save(team15);
		matchController.save(team16);
		matchController.save(team17);
		matchController.save(team18);
		matchController.save(team19);
		matchController.save(team20);

		// User user = new User(null, null, null, null, null, null, null, 0,
		// null);
		// user = (User) service.search("jackson.zhang1@hotmail.com");
		// System.out.println(user);
		// UserMatches userMatches1 = new UserMatches(10.9, 3);
		// UserMatches userMatches2 = new UserMatches(20.9, 1);
		// Matches matches1 = matchController.searchMatches(42);
		// Matches matches2 = matchController.searchMatches(56);
		// user.addBettingOrder(userMatches1);
		// user.addBettingOrder(userMatches2);
		// matches1.addOrder(userMatches1);
		// matches2.addOrder(userMatches2);
		// service.save(user);
		// service.save(userMatches1);
		// service.save(userMatches2);
		// service.save(matches1);
		// service.save(matches2);

		// User user1 = new User(null, null, null, null, null, null, null, 0,
		// null);
		// user1 = (User) service.search("Alan@gmail.com");
		// UserMatches userMatches1 = new UserMatches(10.9, 1);
		// UserMatches userMatches2 = new UserMatches(20.9, 2);
		// Matches matches1 = matchController.searchMatches(57);
		// Matches matches2 = matchController.searchMatches(76);
		// user1.addBettingOrder(userMatches1);
		// user1.addBettingOrder(userMatches2);
		// matches1.addOrder(userMatches1);
		// matches2.addOrder(userMatches2);
		// service.save(user1);
		// service.save(userMatches1);
		// service.save(userMatches2);
		// service.save(matches1);
		// service.save(matches2);
		// User user = (User) userDao.search("jackson.zhang1@hotmail.com");
		// List<UserMatches>betList = user.getBettingList();
		// for (UserMatches userMatches : betList) {
		// System.out.println(userMatches);
		// }

	}
}