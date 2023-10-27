package br.com.weon.testeconhecimentobackend.persistencia;

import java.util.HashMap;
import java.util.Map;

import br.com.weon.testeconhecimentobackend.configuracao.Configuracao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

/**
 * {@summary Persistencia}
 * Classe responsável pela persistencia de dados
 */
public class Persistencia {

	private static EntityManager entityManager;
	private static Persistencia singleton;
	
	/**
	 * {@summary EntityManagerSingleton.getInstance()}
	 * Metódo estático para retornar instancia do {@link EntityManager}
	 */
	public static void criar(){
		if(entityManager == null && singleton == null){
			
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
			singleton = new Persistencia();
			
		}
	}
	
	/**
	 * Retorna singleton da classe
	 * @return Persistencia - Classe de persistencia
	 */
	public static Persistencia singleton() {
		return singleton;
	}
	
	/**
	 * Método para abrir transações
	 */
	private static synchronized void abrirTransacao() {
		entityManager.getTransaction().begin();;
	}
	
	/**
	 * Realiza o commit das transacoes
	 */
	private static synchronized void commitarTransacao() {
		entityManager.getTransaction().commit();;
	}
	
	/**
	 * Método de persistencia de objeto
	 * @param obj - Qualquer entidade que possa ser persistida na base
	 */
	public synchronized void salvar(Object obj) {
		abrirTransacao();
		entityManager.persist(entityManager.contains(obj) ? obj : entityManager.merge(obj));
		commitarTransacao();
	}
	
	/**
	 * Método de remoção de objeto da base
	 * @param obj - Qualquer entidade que possa ser persistida na base
	 */
	public synchronized void remover(Object obj) {
		abrirTransacao();
		entityManager.remove(entityManager.contains(obj) ? obj : entityManager.merge(obj));
		commitarTransacao();
	}
	
	/**
	 * 
	 * @param nome - Nome da consulta parametrizada na classe
	 * @param classe - Classe referencia para query nomeada
	 * @param <T>
	 * @return TypedQuery 
	 */
	public synchronized <T> TypedQuery<T> consultaNomeada(String nome, Class<T> classe) {
		return entityManager.createNamedQuery(nome,classe);
	}
	
	/**
	 * 
	 * @param query - Consulta a ser executada
	 * @param classe - Classe referencia para query nomeada
	 * @param <T>
	 * @return TypedQuery 
	 */
	public synchronized <T> TypedQuery<T> criarConsulta(String query, Class<T> classe) {
		return entityManager.createQuery(query,classe);
	}
	
	/**
	 * Realiza o encerramento da conexao com o BD
	 */
	public synchronized void fecharConexao() {
		entityManager.close();
	}

}
