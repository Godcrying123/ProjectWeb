package com.project.webapp.daotest;

import static org.mockito.Mockito.verify;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.project.webapp.dao.Datadao;

public class DatadaoTest {

	@Mock
	EntityManagerFactory mockEmf;
	@Mock
	EntityManager mockEm;
	
	Datadao Datadao;


	@Before
	public void setUp() throws Exception {
		System.out.println("The Test has started!!");
		MockitoAnnotations.initMocks(this);
		Datadao = new Datadao(mockEmf, mockEm);
	}

	@Test
	public void close_methodTest() {
		// Arrange

		// Act
		Datadao.disconnect();
		// Assert
		verify(mockEm).close();
		verify(mockEmf).close();
	}


	@After
	public void testDone() {
		System.out.println("The Test has done!!");
	}
}
