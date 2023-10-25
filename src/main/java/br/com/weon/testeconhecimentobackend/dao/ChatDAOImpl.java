package br.com.weon.testeconhecimentobackend.dao;

import java.util.List;

import br.com.weon.testeconhecimentobackend.model.Chat;
import br.com.weon.testeconhecimentobackend.service.EntityManagerSingleton;
import jakarta.persistence.EntityManager;

/*
 * Implementação de DAO para Chat
 */
public class ChatDAOImpl implements IChatDAO {
	
	private EntityManager em = EntityManagerSingleton.getInstance();
	
	/*
	 * Método save
	 * Recebe um objeto Chat e realiza a persistencia do mesmo no banco de dados
	 * 
	 * @Param Chat 
	 */
	@Override
	public void save(Chat chat) {
		em.persist(chat);
	}

	/*
	 * Método delete
	 * Recebe um objeto Chat e realiza a remoção do mesmo no banco de dados
	 * 
	 * @Param Chat 
	 */
	@Override
	public void delete(Chat chat) {
		em.remove(chat);
	}

	/*
	 * Método getAll
	 * Realiza a busca de todos os objetos cadastrados na tabela Chat
	 * 
	 * @Return List<Chat>
	 */
	@Override
	public List<Chat> getAll() {
		return em.createQuery("from Chat c", Chat.class)
				.getResultList();
	}

}
