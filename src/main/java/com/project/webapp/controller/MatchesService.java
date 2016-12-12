package com.project.webapp.controller;

import java.util.List;

import com.project.webapp.model.Matches;
import com.project.webapp.model.Team;

public interface MatchesService {

	public void matchSchedule(int roundNum);

	public void save(Object object);

	public void remove(Object object);

	public List<Matches> getList(int team_id);

	public int pointsCalculator(int team_id);

	public Team searchTeam(int team_id);

	public List<Team> TeamRank();

	public Matches searchMatchesbyId(int match_id);

	public List<Matches> searchMatchList(int match_week);

	public String[] timeSchedule();

	public List<Team> teamList();

	public Matches searchMatchesByTeamIdAndMatchWeek(int Team, int match_week);

}
