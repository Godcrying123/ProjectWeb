package com.project.webapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Datadao {

	public static EntityManagerFactory emf;
	public static EntityManager em;

	public Datadao() {
		try {
			this.emf = Persistence.createEntityManagerFactory("Database");
			this.em = emf.createEntityManager();
		} catch (Exception e) {
			System.err.println("Fail to connect database!!");
		}
	}

	public Datadao(EntityManagerFactory emf, EntityManager em) {
			this.emf = emf;
			this.em = em;
	}

	public void disconnect() {
		if (em != null || emf != null) {
			em.close();
			emf.close();
		}
	}

	public static EntityManager getEm() {

		if (em == null) {
			System.out.println("Database Connection dose not exist!");
			System.out.println("Database Connection should be recreated!");
			emf = Persistence.createEntityManagerFactory("Database");
			em = emf.createEntityManager();
		}
		return em;
	}

}
