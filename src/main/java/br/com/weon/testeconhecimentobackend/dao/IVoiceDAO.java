package br.com.weon.testeconhecimentobackend.dao;

import br.com.weon.testeconhecimentobackend.model.Voice;

/**
 * {@summary IVoiceDAO}
 * Classe DAO com métodos a serem implementados por DAO de Voice
 */
public interface IVoiceDAO {

	/**
	 * {@summary IVoiceDAO.save(Voice voice)}
	 * Método a ser implementado por DAO para persistir dados no banco de dados
	 * @param voice
	 */
	void save(Voice voice);
	
	/**
	 * {@summary IVoiceDAO.save(Voice voice)}
	 * Método a ser implementado por DAO para remover dados no banco de dados
	 * @param voice
	 */
	void delete(Voice voice);
}
