package com.project.webapp.controllertest;

import static org.mockito.Mockito.times;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

import com.project.webapp.controller.UserDao;
import com.project.webapp.controller.UserService;
import com.project.webapp.dao.Datadao;
import com.project.webapp.domain.User;

public class UserDaoTest {

	@Mock
	EntityManagerFactory mockEmf;
	@Mock
	EntityManager mockEm;
	@Mock
	EntityTransaction mockTransaction;
	@Mock
	User mockUser;
	@Mock
	Query mockQuery;
	@Mock
	Datadao mockDao;

	UserService userDao;

	@Before
	public void setUp() {
		System.out.println("The Test starts!!");
		MockitoAnnotations.initMocks(this);
		userDao = new UserDao(mockEm);
	}

	@Test
	public void save_methodTest() {

		// Arrange
		Mockito.when(mockEm.getTransaction()).thenReturn(mockTransaction);
		// Act
		userDao.save(mockUser);
		// Assert
		verify(mockEm, times(2)).getTransaction();
		verify(mockEm).persist(mockUser);
		verify(mockTransaction).commit();
		verify(mockTransaction).begin();

	}

	@Test
	public void remove_methodTest() {
		// Arrange
		Mockito.when(mockEm.getTransaction()).thenReturn(mockTransaction);
		// Act
		userDao.remove(mockUser);
		// Assert
		verify(mockEm, times(2)).getTransaction();
		verify(mockEm).remove(mockUser);
		verify(mockTransaction).commit();
		verify(mockTransaction).begin();
	}

	@Test
	public void update_methodTest() {
		// Arrange
		Mockito.when(mockEm.getTransaction()).thenReturn(mockTransaction);
		// Act
		userDao.update(mockUser);
		// Assert
		verify(mockEm, times(2)).getTransaction();
		verify(mockEm).persist(mockUser);
		verify(mockTransaction).commit();
		verify(mockTransaction).begin();
	}

	@Test
	public void search_byEmail_methodTest() {
		// Arrange
		when(mockEm.createQuery("from User as user where user.emailaddress = ?")).thenReturn(mockQuery);
		// Act
		userDao.search("testEmail");
		// Assert
		verify(mockEm).createQuery("from User as user where user.emailaddress = ?");
		verify(mockQuery).setParameter(0, "testEmail");
	}

	@Test
	public void search_byUserId_methodTest() {
		// Arrange
		when(mockEm.createQuery("from User as user where user.user_id = ?")).thenReturn(mockQuery);
		// Act
		userDao.search(1);
		// Assert
		verify(mockEm).createQuery("from User as user where user.user_id = ?");
		verify(mockQuery).setParameter(0, 1);
	}

	@Test
	public void validate_methodTest() {
		// Arrange
		when(mockEm.createQuery("from User as user where user.username=? and user.emailaddress=? and user.password=?"))
				.thenReturn(mockQuery);
		// Act
		userDao.validate("testUsername", "testEmail", "testPassword");
		// Assert
		verify(mockEm)
				.createQuery("from User as user where user.username=? and user.emailaddress=? and user.password=?");
		verify(mockQuery).getSingleResult();
	}

	@Test
	public void getAllUsers_methodTest() {
		// Arrange
		when(mockEm.createQuery("from User")).thenReturn(mockQuery);
		// Act
		userDao.getAllUsers();
		// Assert
		verify(mockQuery).getResultList();

	}

	@After
	public void testDone() {
		System.out.println("The Test has done!!");
	}

}
