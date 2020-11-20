package com.cg.healthassist.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * This JPAUtil class performs common task like getting entityManager instance, releasing entityManger.
 * @author Aman Soni
 *
 */
public class JPAUtil {
	private static EntityManagerFactory entityManagerFactory;
	
	/**
	 * Create the entity manager factor to produce the entity manager.
	 */
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
	}
	
	/**
	 * Make the entity manager.
	 * @return an instance of entity manager.
	 */
	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
	
	/**
	 * Start the transaction.
	 */
	public void beginTransaction() {
		getEntityManager().getTransaction().begin();
	}
	
	/**
	 * Save all the changes in database.
	 */
	public void commitTransaction() {
		getEntityManager().getTransaction().commit();
	}
	
	/**
	 * Close the transaction.
	 */
	public void closeEntityManager() {
		getEntityManager().close();
	}

}
