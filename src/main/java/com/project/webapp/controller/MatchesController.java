package com.project.webapp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.project.webapp.dao.Datadao;
import com.project.webapp.domain.User;
import com.project.webapp.model.MatchSchedule;
import com.project.webapp.model.Matches;
import com.project.webapp.model.Team;

public class MatchesController implements MatchesService {

	private Datadao datadao;
	private EntityManager em;
	private MatchSchedule schedulematch;
	private UserDao userDao;
	private String[] startTimes = new String[7];

	public MatchesController() {
		this.em = datadao.getEm();
		this.userDao = userDao;
		this.schedulematch = schedulematch;
		this.startTimes = startTimes;

	}

	public MatchesController(Datadao datadao, EntityManager em,
			MatchSchedule matchSchedule, UserDao userDao) {
		this.datadao = datadao;
		this.em = em;
		this.schedulematch = schedulematch;
		this.userDao = userDao;
	}

	public String[] timeSchedule() {
		startTimes[0] = "12:30 Saturday";
		startTimes[1] = "15:00 Saturday";
		startTimes[2] = "17:30 Saturday";
		startTimes[3] = "19:45 Saturday";
		startTimes[4] = "13:00 Sunday";
		startTimes[5] = "16:00 Sunday";
		startTimes[6] = "20:00 Sunday";
		return startTimes;

	}

	public void save(Object object) {
		em.getTransaction().begin();
		em.persist(object);
		em.getTransaction().commit();
	}

	public void matchSchedule(int roundNum) {

		MatchSchedule schedulematch = new MatchSchedule();
		int[][] scheduleList = new int[roundNum][20];
		scheduleList = schedulematch.Schedule();
		String[] startTimes = timeSchedule();
		for (int i = 0; i < roundNum; i++) {
			for (int j = 0; j <= 19; j = j + 2) {

				Matches matches = new Matches(0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						startTimes[(int) (Math.random() * 7)]);
				matches.setMatchweek(i + 1);
				String a = String.valueOf(Math.random() * 9 + 1)
						.substring(0, 4);
				String b = String.valueOf(Math.random() * 9 + 1)
						.substring(0, 4);
				String c = String.valueOf(Math.random() * 9 + 1)
						.substring(0, 4);
				double homeWinRate = Double.valueOf(a);
				double awayWinRate = Double.valueOf(b);
				double drawRate = Double.valueOf(c);
				matches.setHomeWinRate(homeWinRate);
				matches.setAwayWinRate(awayWinRate);
				matches.setDrawRate(drawRate);
				int homeScore = (int) (Math.random() * 5);
				int awayScore = (int) (Math.random() * 5);
				matches.setHomescore(homeScore);
				matches.setAwayscore(awayScore);
				matches.setHometeam(scheduleList[i][j]);
				matches.setAwayteam(scheduleList[i][j + 1]);
				Team team_home = searchTeam(scheduleList[i][j]);
				Team team_away = searchTeam(scheduleList[i][j + 1]);
				team_home.setScore(homeScore);
				team_away.setScore(awayScore);

				if (homeScore > awayScore) {
					matches.setHomePoints(3);
				} else if (homeScore == awayScore) {
					matches.setHomePoints(1);
					matches.setAwayPoints(1);
				} else {
					matches.setAwayPoints(3);
				}

				matches.addTeam(team_home);
				matches.addTeam(team_away);
				save(matches);
				save(team_home);
				save(team_away);
			}
		}
	}

	public List<Matches> getList(int team_id) {

		Team team = searchTeam(team_id);
		List<Matches> matchesList = new ArrayList<Matches>();
		for (Matches matches : team.getMatchesList()) {
			matchesList.add(matches);
		}
		return matchesList;
	}

	public int pointsCalculator(int team_id) {

		int points = 0;
		Team team = searchTeam(team_id);
		List<Matches> matchesList = new ArrayList<Matches>();
		matchesList = getList(team_id);
		for (Matches matches : matchesList) {
			if (matches.getHometeam() == team.getTeam_id()) {
				points = points + matches.getHomePoints();
			} else if (matches.getAwayteam() == team.getTeam_id()) {
				points = points + matches.getAwayPoints();
			}
		}
		return points;
	}

	public List<Team> TeamRank() {

		List<Team> teamRankList = new ArrayList<Team>();
		for (int i = 1; i <= 20; i++) {
			Team team = searchTeam(i);
			team.setPoints(pointsCalculator(i));
			save(team);
			teamRankList.add(team);
		}
		Collections.sort(teamRankList, new Team());

		return teamRankList;
	}

	public Team searchTeam(int team_id) {
		Query query = this.em
				.createQuery("from Team as team where team.team_id = ?");
		query.setParameter(0, team_id);
		try {
			Team team = (Team) query.getSingleResult();
			return team;
		} catch (javax.persistence.NoResultException e) {
			return null;
		}
	}

	public void remove(Object object) {
		em.getTransaction().begin();
		em.remove(object);
		em.getTransaction().commit();

	}

	public Matches searchMatchesbyId(int match_id) {
		Query query = this.em
				.createQuery("from Matches as matches where matches.match_id=?");
		query.setParameter(0, match_id);
		try {
			Matches matches = (Matches) query.getSingleResult();
			return matches;
		} catch (javax.persistence.NoResultException e) {
			// TODO: handle exception
			return null;
		}

	}

	public List<Matches> searchMatchList(int match_week) {
		Query query = this.em
				.createQuery("from Matches as matches where matches.matchweek=?");
		query.setParameter(0, match_week);
		List<Matches> matchesList = new ArrayList<Matches>();
		try {
			matchesList = query.getResultList();
			return matchesList;
		} catch (javax.persistence.NoResultException e) {

			return null;
		}
	}

	public Matches searchMatches(int Team, int match_week) {

		Query query = this.em
				.createQuery("from Matches as matches where matches.matchweek=?");
		query.setParameter(0, match_week);
		List<Matches> matchLists = new ArrayList<Matches>();
		Matches matchSelect = new Matches();
		matchLists = query.getResultList();
		for (Matches matches : matchLists) {
			if (matches.getHometeam() == Team || matches.getAwayteam() == Team) {
				matchSelect = matches;
			}
		}
		return matchSelect;

	}

	public List<Team> teamList() {
		Query query = this.em.createQuery("from Team as team");
		List<Team> teamList = new ArrayList<Team>();
		try {
			teamList = query.getResultList();
			return teamList;
		} catch (javax.persistence.NoResultException e) {

			return null;
		}
	}

	public static void main(String[] args) {
		MatchesController matchesController = new MatchesController();
		matchesController.matchSchedule(20);
		// List<Matches> matchesList = matchesController.searchMatchList(20);
		// for (Matches matches : matchesList) {
		// System.out.println(matches);
		// }
		// List<Team> teamList = matchesController.TeamRank();
		// for (Team team : teamList) {
		// System.out.println(team.getTeamname()+" "+team.getPoints());
		// }
	}

}
