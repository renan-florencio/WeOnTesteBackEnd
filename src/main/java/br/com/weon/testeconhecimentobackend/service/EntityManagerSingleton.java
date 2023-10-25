package br.com.weon.testeconhecimentobackend.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerSingleton {

	private static EntityManager entityManager;

	private EntityManagerSingleton(){

	}

	public static EntityManager getInstance(){
		if(entityManager == null){
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ConexaoDB");
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}
}
