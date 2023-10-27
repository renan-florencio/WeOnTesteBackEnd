package br.com.weon.testeconhecimentobackend.dao;

import java.util.List;
import java.util.UUID;

import br.com.weon.testeconhecimentobackend.canal.Email;
import br.com.weon.testeconhecimentobackend.persistencia.Persistencia;
import jakarta.persistence.EntityManager;
/**
 * {@summary EmailDAOImpl}
 * Implementação de interface DAO de email
 */
public class EmailDAOImpl implements IEmailDAO {
	
	EntityManager em = Persistencia.obter();
	
	@Override
	public void salvar(Email email) {
		em.getTransaction().begin();
		em.persist(em.contains(email) ? email : em.merge(email));
		em.getTransaction().commit();
	}

	@Override
	public Email obter(UUID id) {
		return em.createNamedQuery("obterEmail", Email.class)
				.setParameter("id", id).getSingleResult();
	}

	@Override
	public List<Email> obterTodos() {
		return em.createQuery("from Email", Email.class)
				.getResultList();
	}

	@Override
	public void remover(Email email) {
		em.getTransaction().begin();
		em.remove(em.contains(email) ? email : em.merge(email));
		em.getTransaction().commit();
	}

}
