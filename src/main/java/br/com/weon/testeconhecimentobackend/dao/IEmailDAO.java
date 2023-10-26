package br.com.weon.testeconhecimentobackend.dao;

import br.com.weon.testeconhecimentobackend.model.Email;

/**
 * {@summary IEmailDAO}
 * Classe DAO com métodos a serem implementados por DAO de Email
 */
public interface IEmailDAO {

	/**
	 * {@summary IEmailDAO.save(Email email)}
	 * Método a ser implementado por DAO para persistir dados no banco de dados
	 * @param email
	 */
	void save(Email email);
	
	/**
	 * {@summary IEmailDAO.delete(Email email)}
	 * Método a ser implementado por DAO para remover dados no banco de dados
	 * @param email
	 */
	void delete(Email email);
	
}
