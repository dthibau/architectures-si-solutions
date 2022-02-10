package org.fomation;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import org.formation.dao.DBHelper;
import org.formation.domain.Departement;
import org.formation.domain.Employe;
import org.junit.Test;

public class TransactionConcurrente {

	@Test
	public void testOptimiste() throws Exception {

		EntityManager em1 = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx1 = em1.getTransaction();
		// Démarrage 1ère transaction
		tx1.begin();
		EntityManager em2 = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx2 = em2.getTransaction();
		// Démarrage 2nd transaction
		tx2.begin();
		// Chargement de la même donnée
		Employe e1 = (Employe) em1.find(Employe.class, 1l);
		Employe e2 = (Employe) em2.find(Employe.class, 1l);
		System.out.println("égalité en base ? :" + (e1.getId().equals(e2.getId())));
		e1.setTelephone(e1.getTelephone() + "1");
		e2.setTelephone(e2.getTelephone() + "2");
		tx2.commit();
		em2.close();
		try {
			tx1.commit();
			em1.close();
			assertTrue(false);
		} catch (RollbackException e) {
			System.out.println("Problème de concurrence à remonter à l'utilisateur " + e);
			e.printStackTrace();
		}
		// Vérification en base
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Employe e = (Employe) em.find(Employe.class, 1l);
		assertTrue(e.getTelephone().endsWith("2"));
		tx.commit();
		em.close();

	}

	@Test
	public void testUnmanagedConsurrency() throws Exception {

		EntityManager em1 = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx1 = em1.getTransaction();
		// Démarrage 1ère transaction
		tx1.begin();
		EntityManager em2 = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx2 = em2.getTransaction();
		// Démarrage 2nd transaction
		tx2.begin();
		// Chargement de la même donnée
		Departement d1 = (Departement) em1.find(Departement.class, 1l);
		Departement d2 = (Departement) em2.find(Departement.class, 1l);
		System.out.println("égalité en base ? :" + (d1.getId().equals(d2.getId())));
		d1.setNom(d1.getNom() + "1");
		d2.setNom(d2.getNom() + "2");
		tx2.commit();
		em2.close();
		try {
			tx1.commit();
			em1.close();

		} catch (RollbackException e) {
			System.out.println("Problème de concurrence à remonter à l'utilisateur " + e);
			e.printStackTrace();
		}
		// Vérification en base
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Departement d = (Departement) em.find(Departement.class, 1l);
		assertTrue(d.getNom().endsWith("1"));
		tx.commit();
		em.close();
	}

}
