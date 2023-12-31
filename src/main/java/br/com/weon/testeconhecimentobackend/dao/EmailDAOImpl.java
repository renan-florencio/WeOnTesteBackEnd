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
	
	private Persistencia persistencia = Persistencia.singleton();
	
	@Override
	public synchronized void salvar(Email email) {
		persistencia.salvar(email);
	}

	@Override
	public synchronized Email obter(UUID id) {
		return persistencia.consultaNomeada("obterEmail", Email.class)
				.setParameter("id", id).getSingleResult();
	}

	@Override
	public synchronized List<Email> obterTodos() {
		return persistencia.criarConsulta("from Email", Email.class)
				.getResultList();
	}

	@Override
	public synchronized void remover(Email email) {
		persistencia.remover(email);
	}

}
