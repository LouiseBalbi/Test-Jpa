package jpa01;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import jpa01.model.Client;

import jpa01.model.Emprunt;
import jpa01.model.Livre;


public class TestJpaBiblio {

private EntityManagerFactory factory = null;
	
	@Before
	public void init() {
		factory = Persistence.createEntityManagerFactory("pu_essai");
	}
	
	
	@Test
	public void testExtract() {
		
		EntityManager em = factory.createEntityManager();
		
		if(em != null) {
			TypedQuery<Emprunt> q = em.createQuery("SELECT e from Emprunt e", Emprunt.class);
		List<Emprunt> listEmprunt = q.getResultList();
			for(Emprunt e : q.getResultList()) {
				System.out.println(e);
			}
		}
		
		em.close();
		factory.close();
	}
	
	@Test
	public void test() {
		
		EntityManager em = factory.createEntityManager();
		
			Client c = em.find(Client.class, 1);
			System.out.println(c);
			
			String query = "Select e from Emprunt where e.client.id =" + c.getId();
			TypedQuery<Emprunt> q = em.createQuery(query, Emprunt.class);
			for(Emprunt emp : q.getResultList()) {
					for(Livre l : emp.getLivres()) {
					System.out.println(l);
				}
			}
	
		em.close();
		factory.close();
	}
	

	
}
