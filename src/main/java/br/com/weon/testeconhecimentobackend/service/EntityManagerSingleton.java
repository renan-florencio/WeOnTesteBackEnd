package br.com.weon.testeconhecimentobackend.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * {@summary EntityManagerSingleton}
 * Classe de persistência de dados - Singleton
 */
public class EntityManagerSingleton {

	private static EntityManager entityManager;

	private EntityManagerSingleton(){

	}

	/**
	 * {@summary EntityManagerSingleton.getInstance()}
	 * Metódo estático para retornar instancia do {@link EntityManager}
	 * @return {@link EntityManager}
	 */
	public static synchronized EntityManager getInstance(){
		if(entityManager == null){
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ConexaoDB");
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}
	
	/**
	 * {@summary EntityManagerSingleton.save(Object obj)}
	 * @param obj
	 */
	public static synchronized void save(Object obj) {
		entityManager.getTransaction().begin();
		entityManager.persist(obj);
		entityManager.getTransaction().commit();
	}
	
	/**
	 * {@summary EntityManagerSingleton.remove(Object obj)}
	 * @param obj
	 */
	public static synchronized void remove(Object obj) {
		entityManager.getTransaction().begin();
		entityManager.remove(obj);
		entityManager.getTransaction().commit();
	}
}
