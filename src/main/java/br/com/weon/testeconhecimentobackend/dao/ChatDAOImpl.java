package br.com.weon.testeconhecimentobackend.dao;

import br.com.weon.testeconhecimentobackend.model.Chat;
import br.com.weon.testeconhecimentobackend.service.EntityManagerSingleton;
import jakarta.transaction.Transactional;

/*
 * Implementação de DAO para Chat
 */
public class ChatDAOImpl implements IChatDAO {
	
	/*
	 * Método save
	 * Recebe um objeto Chat e realiza a persistencia do mesmo no banco de dados
	 * 
	 * @Param Chat 
	 */
	@Override
	@Transactional
	public void save(Chat chat) {
		EntityManagerSingleton.save(chat);
	}

	/*
	 * Método delete
	 * Recebe um objeto Chat e realiza a remoção do mesmo no banco de dados
	 * 
	 * @Param Chat 
	 */
	@Override
	@Transactional
	public void delete(Chat chat) {
		EntityManagerSingleton.remove(chat);
	}

}
