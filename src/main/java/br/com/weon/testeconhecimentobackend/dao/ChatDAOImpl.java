package br.com.weon.testeconhecimentobackend.dao;

import java.util.List;

import br.com.weon.testeconhecimentobackend.model.Chat;
import br.com.weon.testeconhecimentobackend.service.EntityManagerSingleton;
import jakarta.persistence.EntityManager;

public class ChatDAOImpl implements IChatDAO {
	
	private EntityManager em = EntityManagerSingleton.getInstance();
	
	@Override
	public void save(Chat chat) {
		em.persist(chat);
	}

	@Override
	public void delete(Chat chat) {
		em.remove(chat);
	}

	@Override
	public List<Chat> getAll() {
		return em.createQuery("from Chat c", Chat.class)
				.getResultList();
	}

}
