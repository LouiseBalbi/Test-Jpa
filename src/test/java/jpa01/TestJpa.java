package jpa01;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import jpa01.model.Livre;

public class TestJpa {
	private EntityManagerFactory factory = null;
	
	@Before
	public void init() {
		factory = Persistence.createEntityManagerFactory("pu_essai");
	}
	
	@Test
	public void test() {
		//factory = Persistence.createEntityManagerFactory("pu_essai");
		
		EntityManager em = factory.createEntityManager();
		
		if(em != null) {
			Livre livre1 = em.find(Livre.class, 1);	
			System.out.println(livre1);		
		}
		em.close();
		factory.close();
	}
	
	
	
	@Test
	public void listeLivres() {
		
		EntityManager em = factory.createEntityManager();
		
		if(em != null) {
			String query = "SELECT l FROM Livre l";
			TypedQuery<Livre> q = em.createQuery(query, Livre.class);
			for(Livre l : q.getResultList()) {
				System.out.println(l);
			}
		}
		em.close();
		factory.close();
	}
	
	
	@Test
	public void listeLivresW() {
		
		EntityManager em = factory.createEntityManager();
		
		if(em != null) {
			String query = "SELECT l FROM Livre l where l.id >= 3";
			TypedQuery<Livre> q = em.createQuery(query, Livre.class);
			for(Livre l : q.getResultList()) {
				System.out.println(l);
			}
		}
		em.close();
		factory.close();
	}
	
	
	@Test
	public void listeLivresWhereTitre() {
		
		EntityManager em = factory.createEntityManager();
		
		if(em != null) {
			String query = "SELECT l FROM Livre l where l.titre = 'Germinal'";
			TypedQuery<Livre> q = em.createQuery(query, Livre.class);
			for(Livre l : q.getResultList()) {
				System.out.println(l);
			}
		}
		em.close();
		factory.close();
	}
	
	
	@Test
	public void listeLivresWhereAuteur() {
		
		EntityManager em = factory.createEntityManager();
		
		if(em != null) {
			String query = "SELECT l FROM Livre l where l.auteur = 'Jules Verne'";
			TypedQuery<Livre> q = em.createQuery(query, Livre.class);
			for(Livre l : q.getResultList()) {
				System.out.println(l);
			}
		}
		em.close();
		factory.close();
	}
	
	
	@Test
	public void insertLivre() {
		
		EntityManager em = factory.createEntityManager();
		Livre l = new Livre();
		l.setId(6);
		l.setAuteur("Victor Hugo");
		l.setTitre("Les Misérables");
		
		// ouverture d'une transaction
		em.getTransaction().begin();
		// ajout du nouveau livre dans la BDD
		em.persist(l);
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	@Test
	public void upadateLivre() {
		
		EntityManager em = factory.createEntityManager();
		
		// ouverture d'une transaction
		em.getTransaction().begin();
		// Find transcient : transactionnel
		Livre l = em.find(Livre.class, 5);
		l.setTitre("Du plaisir dans la cuisine");
		// ajout du nouveau livre dans la BDD
		em.merge(l);
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	
	@Test
	public void deleteLivre() {
		
		EntityManager em = factory.createEntityManager();
		
		// ouverture d'une transaction
		em.getTransaction().begin();
		// Find transcient : transactionnel
		Livre l = em.find(Livre.class, 6);
		// ajout du nouveau livre dans la BDD
		em.remove(l);
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

}
