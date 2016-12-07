package com.project.webapp.controller;

import java.util.List;

import com.project.webapp.domain.User;
import com.project.webapp.domain.UserMatches;
import com.project.webapp.model.Matches;

public interface BetService {

	public void save(Object object);

	public void betMatch(String emailaddress, int match_id, double betamount,
			int bet);

	public UserMatches getUserMatches();

}
