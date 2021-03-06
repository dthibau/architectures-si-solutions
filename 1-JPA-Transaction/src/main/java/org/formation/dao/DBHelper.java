package org.formation.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;

public class DBHelper {

	private static EntityManagerFactory factory = null;

	static {
		try {
			factory = Persistence.createEntityManagerFactory("ssii");
		} catch (HibernateException e) {
			System.err
					.println("problème d'obtention d'une entityManager factory Hibernate/JPA");
			throw e;
		}
	}

	public static EntityManagerFactory getFactory() {
		return factory;
	}
}
