package br.com.weon.testeconhecimentobackend.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerSingleton {

	private static EntityManager entityManager;

	private EntityManagerSingleton(){

	}

	public static synchronized EntityManager getInstance(){
		if(entityManager == null){
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ConexaoDB");
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}
	
	public static synchronized void save(Object obj) {
		entityManager.getTransaction().begin();
		entityManager.persist(obj);
		entityManager.getTransaction().commit();
	}
	
	public static synchronized void remove(Object obj) {
		entityManager.getTransaction().begin();
		entityManager.remove(obj);
		entityManager.getTransaction().commit();
	}
}
