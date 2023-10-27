package br.com.weon.testeconhecimentobackend.persistencia;

import java.util.HashMap;
import java.util.Map;

import br.com.weon.testeconhecimentobackend.configuracao.Configuracao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * {@summary Persistencia}
 * Classe responsável pela persistencia de dados
 */
public class Persistencia {

	private static EntityManager entityManager;
	
	/**
	 * {@summary EntityManagerSingleton.getInstance()}
	 * Metódo estático para retornar instancia do {@link EntityManager}
	 */
	public static void criar(){
		if(entityManager == null){
			
			Map<String, Object> propriedades = new HashMap<String, Object>();
			propriedades.put("jakarta.persistence.jdbc.driver",
					Configuracao.obter().getDbConfig().get(0).getDriver());
			propriedades.put("jakarta.persistence.jdbc.url",
					Configuracao.obter().getDbConfig().get(0).getUrl());
			propriedades.put("jakarta.persistence.jdbc.user",
					Configuracao.obter().getDbConfig().get(0).getUsuario());
			propriedades.put("jakarta.persistence.jdbc.password",
					Configuracao.obter().getDbConfig().get(0).getSenha());
			propriedades.put("hibernate.dialect",
					Configuracao.obter().getDbConfig().get(0).getHibernateDialect());
			propriedades.put("hibernate.hbm2ddl.auto",
					Configuracao.obter().getDbConfig().get(0).getHibernateHbmToDDL());
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ConexaoDB",propriedades);
			entityManager = entityManagerFactory.createEntityManager();
		}
	}
	
	/**
	 * Retornar a instancia do EntityManager para persistir os dados
	 * @return EntityManager - entidade de persistência
	 */
	public static synchronized EntityManager obter() {
		return entityManager;
	}
}
