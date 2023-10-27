package br.com.weon.testeconhecimentobackend.dao;

import java.util.List;
import java.util.UUID;

import br.com.weon.testeconhecimentobackend.canal.Chat;
import br.com.weon.testeconhecimentobackend.persistencia.Persistencia;
import jakarta.persistence.EntityManager;

/**
 * {@summary ChatDAOImpl}
 * Implementação de interface DAO de chat
 */
public class ChatDAOImpl implements IChatDAO {
	EntityManager em = Persistencia.obter();
	
	@Override
	public void salvar(Chat chat) {
		em.getTransaction().begin();
		em.persist(em.contains(chat)? chat : em.merge(chat));
		em.getTransaction().commit();
	}

	@Override
	public Chat obter(UUID id) {
		return em.createNamedQuery("obterChat", Chat.class)
				.setParameter("id", id).getSingleResult();
	}

	@Override
	public List<Chat> obterTodos() {
		return em.createQuery("from Chat", Chat.class)
				.getResultList();
	}

	@Override
	public void remover(Chat chat) {
		em.getTransaction().begin();
		em.remove(em.contains(chat)? chat : em.merge(chat));
		em.getTransaction().commit();
	}

}
