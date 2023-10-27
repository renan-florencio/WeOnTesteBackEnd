package br.com.weon.testeconhecimentobackend.dao;

import java.util.List;
import java.util.UUID;

import br.com.weon.testeconhecimentobackend.canal.Chat;

/**
 * {@summary IVozDAO}
 * DAO de entidade Chat
 */

@SuppressWarnings("javadoc")
public interface IChatDAO {

	void salvar(Chat chat);
	Chat obter(UUID id);
	List<Chat> obterTodos();
	void remover(Chat chat);
	
}
