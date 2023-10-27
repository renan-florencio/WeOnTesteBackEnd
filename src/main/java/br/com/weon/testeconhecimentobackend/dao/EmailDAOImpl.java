package br.com.weon.testeconhecimentobackend.dao;

import java.util.List;
import java.util.UUID;

import br.com.weon.testeconhecimentobackend.canal.Email;
import br.com.weon.testeconhecimentobackend.persistencia.Persistencia;
/**
 * {@summary EmailDAOImpl}
 * Implementação de interface DAO de email
 */
public class EmailDAOImpl implements IEmailDAO {
	
	@Override
	public synchronized void salvar(Email email) {
		Persistencia.salvar(email);
	}

	@Override
	public synchronized Email obter(UUID id) {
		return Persistencia.consultaNomeada("obterEmail", Email.class)
				.setParameter("id", id).getSingleResult();
	}

	@Override
	public synchronized List<Email> obterTodos() {
		return Persistencia.criarConsulta("from Email", Email.class)
				.getResultList();
	}

	@Override
	public synchronized void remover(Email email) {
		Persistencia.remover(email);
	}

}
