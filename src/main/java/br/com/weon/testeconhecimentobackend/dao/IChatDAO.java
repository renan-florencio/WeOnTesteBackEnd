package br.com.weon.testeconhecimentobackend.dao;

import br.com.weon.testeconhecimentobackend.model.Chat;

/**
 * {@summary IChatDAO}
 * Classe DAO com métodos a serem implementados por DAO de Chat
 */
public interface IChatDAO {
	
	/**
	 * {@summary IChatDAO.save(Chat chat)}
	 * Método a ser implementado por DAO para persistir dados no banco de dados
	 * @param chat
	 */
	void save(Chat chat);
	
	/**
	 * {@summary IChatDAO.delete(Chat chat)}
	 * Método a ser implementado por DAO para remover dados no banco de dados
	 * @param chat
	 */
	void delete(Chat chat);
	
}
