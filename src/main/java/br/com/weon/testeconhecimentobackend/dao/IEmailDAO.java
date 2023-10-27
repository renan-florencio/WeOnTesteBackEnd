package br.com.weon.testeconhecimentobackend.dao;

import java.util.List;
import java.util.UUID;

import br.com.weon.testeconhecimentobackend.canal.Email;

/**
 * {@summary IVozDAO}
 * DAO de entidade Chat
 */

@SuppressWarnings("javadoc")
public interface IEmailDAO {

	void salvar(Email email);
	Email obter(UUID id);
	List<Email> obterTodos();
	void remover(Email email);
	
}
