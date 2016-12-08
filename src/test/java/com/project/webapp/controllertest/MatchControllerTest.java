package com.project.webapp.controllertest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.project.webapp.controller.MatchesController;
import com.project.webapp.controller.MatchesService;
import com.project.webapp.controller.UserDao;
import com.project.webapp.dao.Datadao;
import com.project.webapp.domain.User;
import com.project.webapp.model.MatchSchedule;
import com.project.webapp.model.Team;
import com.project.webapp.model.Matches;

public class MatchControllerTest {

	private MatchesService matchesController;
	@Mock
	private EntityManagerFactory mockEmf;
	@Mock
	private EntityManager mockEm;
	@Mock
	private EntityTransaction mockTransaction;
	@Mock
	private User mockUser;
	@Mock
	private Query mockQuery;
	@Mock
	private Datadao mockDao;
	@Mock
	private UserDao mockUserDao;
	@Mock
	private MatchSchedule mockSchedule;
	@Mock
	private Team mockTeam;

	

	@Before
	public void setUp() throws Exception {
		System.out.println("The Test starts!!");
		MockitoAnnotations.initMocks(this);
		matchesController = new MatchesController(mockDao, mockEm, mockSchedule, mockUserDao);

	}

	@Test
	public void save_method_Test() {
		// Arrange
		Mockito.when(mockEm.getTransaction()).thenReturn(mockTransaction);
		// Act
		matchesController.save(mockUser);
		// Assert
		verify(mockEm, times(2)).getTransaction();
		verify(mockEm).persist(mockUser);
		verify(mockTransaction).commit();
		verify(mockTransaction).begin();
	}

	@Test
	public void timeSchedule_method_Test() {
		// Arrange
		String out1 = "12:30 Saturday";
		String out2 = "15:00 Saturday";
		String out3 = "17:30 Saturday";
		String out4 = "19:45 Saturday";
		String out5 = "13:00 Sunday";
		String out6 = "16:00 Sunday";
		String out7 = "20:00 Sunday";
		// Act
		String[] timeList = new String[7];
		timeList = matchesController.timeSchedule();
		// Assert
		assertEquals(timeList[0], out1);
		assertEquals(timeList[1], out2);
		assertEquals(timeList[2], out3);
		assertEquals(timeList[3], out4);
		assertEquals(timeList[4], out5);
		assertEquals(timeList[5], out6);
		assertEquals(timeList[6], out7);
	}

	@Test
	public void remove_method_Test() {
		// Arrange
		Mockito.when(mockEm.getTransaction()).thenReturn(mockTransaction);
		// Act
		matchesController.remove(mockUser);
		// Assert
		verify(mockEm, times(2)).getTransaction();
		verify(mockEm).remove(mockUser);
		verify(mockTransaction).commit();
		verify(mockTransaction).begin();
	}

	@Test
	public void searchMatchesList_bydMatchWeek_Test() {
		// Arrange
		when(mockEm.createQuery("from Matches as matches where matches.matchweek=?")).thenReturn(mockQuery);
		// Act
		matchesController.searchMatchList(1);
		// Assert
		verify(mockEm).createQuery("from Matches as matches where matches.matchweek=?");
		verify(mockQuery).setParameter(0, 1);
		verify(mockQuery).getResultList();
	}

	@Test
	public void searchMatch_byid_Test() {
		// Arrange
		when(mockEm.createQuery("from Matches as matches where matches.match_id=?")).thenReturn(mockQuery);
		// Act
		matchesController.searchMatchesbyId(1);
		// Arrange
		verify(mockEm).createQuery("from Matches as matches where matches.match_id=?");
		verify(mockQuery).setParameter(0, 1);
		verify(mockQuery).getSingleResult();
	}

	@Test
	public void Team_search_byTeamID_Test() {
		// Arrange
		when(mockEm.createQuery("from Team as team where team.team_id = ?")).thenReturn(mockQuery);
		// Act
		matchesController.searchTeam(1);
		// Assert
		verify(mockEm).createQuery("from Team as team where team.team_id = ?");
		verify(mockQuery).setParameter(0, 1);
		verify(mockQuery).getSingleResult();
	}

	@Test
	public void teamList_get_Test() {
		// Arrange
		when(mockEm.createQuery("from Team as team")).thenReturn(mockQuery);
		// Act
		matchesController.teamList();
		// Assert
		verify(mockEm).createQuery("from Team as team");
		verify(mockQuery).getResultList();
	}

	@Test
	public void TeamRank_method_Test() {
		// Arrange
		List<Matches> matchesList = new ArrayList<Matches>();
		Matches matches = new Matches(1, 2, 3, 4, 58, 34, 1, 1.5, 2.5, 5.7, "17:00");
		// Act
		matchesList.add(matches);
		// Assert
		assertEquals(matchesList.contains(matches), true);

	}

	@Test
	public void pointsCalculator_Method_Test() {
		// Arrange

		// Act
		matchesController.pointsCalculator(1);
		// Assert
	}

	@Test
	public void matchSchedule_method_Test() {
		// Arrange

		// Act
		matchesController.pointsCalculator(2);
		// Assert
	}

	@After
	public void testDone() {
		System.out.println("The Test has done!!");
	}

}
