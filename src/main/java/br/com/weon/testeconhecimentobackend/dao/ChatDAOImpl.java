package br.com.weon.testeconhecimentobackend.dao;

import br.com.weon.testeconhecimentobackend.model.Chat;
import br.com.weon.testeconhecimentobackend.service.EntityManagerSingleton;
import jakarta.transaction.Transactional;

/**
 * {@summary ChatDAOImpl}
 * Implementação de DAO para classe Chat
 */
public class ChatDAOImpl implements IChatDAO {
	
	/**
	 * {@summary ChatDAOImpl.save(Chat chat)}
	 * Método save
	 * <br>Recebe um objeto Chat e realiza a persistencia do mesmo no banco de dados
	 */
	@Override
	@Transactional
	public void save(Chat chat) {
		EntityManagerSingleton.save(chat);
	}

	/**
	 * {@summary ChatDAOImpl.delete(Chat chat)}
	 * Método delete
	 * <br>Recebe um objeto Chat e realiza a remoção do mesmo no banco de dados
	 * 
	 * @Param Chat 
	 */
	@Override
	@Transactional
	public void delete(Chat chat) {
		EntityManagerSingleton.remove(chat);
	}

}
