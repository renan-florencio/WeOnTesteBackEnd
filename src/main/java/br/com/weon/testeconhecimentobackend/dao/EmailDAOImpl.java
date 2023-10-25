package br.com.weon.testeconhecimentobackend.dao;

import java.util.List;

import br.com.weon.testeconhecimentobackend.model.Email;
import br.com.weon.testeconhecimentobackend.service.EntityManagerSingleton;
import jakarta.persistence.EntityManager;

public class EmailDAOImpl implements IEmailDAO {
	
	private EntityManager em = EntityManagerSingleton.getInstance();
	
	@Override
	public void save(Email email) {
		em.persist(email);
	}

	@Override
	public void delete(Email email) {
		em.remove(email);
	}

	@Override
	public List<Email> getAll() {
		return em.createQuery("from Email e", Email.class)
				.getResultList();
	}

}
