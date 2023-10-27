package br.com.weon.testeconhecimentobackend.dao;

import java.util.List;
import java.util.UUID;

import br.com.weon.testeconhecimentobackend.canal.Chat;
import br.com.weon.testeconhecimentobackend.persistencia.Persistencia;

/**
 * {@summary ChatDAOImpl}
 * Implementação de interface DAO de chat
 */
public class ChatDAOImpl implements IChatDAO {
	
	private Persistencia persistencia = Persistencia.singleton();
	
	@Override
	public synchronized void salvar(Chat chat) {
		persistencia.salvar(chat);
	}

	@Override
	public synchronized Chat obter(UUID id) {
		return persistencia.consultaNomeada("obterChat", Chat.class)
				.setParameter("id", id).getSingleResult();
	}

	@Override
	public synchronized List<Chat> obterTodos() {
		return persistencia.criarConsulta("from Chat", Chat.class)
				.getResultList();
	}

	@Override
	public synchronized void remover(Chat chat) {
		persistencia.remover(chat);
	}

}
