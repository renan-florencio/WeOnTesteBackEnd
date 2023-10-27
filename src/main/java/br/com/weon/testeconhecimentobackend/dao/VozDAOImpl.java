package br.com.weon.testeconhecimentobackend.dao;

import java.util.List;
import java.util.UUID;

import br.com.weon.testeconhecimentobackend.canal.Voz;
import br.com.weon.testeconhecimentobackend.persistencia.Persistencia;
import jakarta.persistence.EntityManager;

/**
 * {@summary VozDAOImpl}
 * Implementação de interface DAO de voz
 */
public class VozDAOImpl implements IVozDAO {
	EntityManager em = Persistencia.obter();
	
	@Override
	public void salvar(Voz voz) {
		em.getTransaction().begin();
		em.persist(em.contains(voz) ? voz : em.merge(voz));
		em.getTransaction().commit();
	}

	@Override
	public Voz obter(UUID id) {
		return em.createNamedQuery("obterVoz", Voz.class)
				.setParameter("id", id).getSingleResult();
	}

	@Override
	public List<Voz> obterTodos() {
		return em.createQuery("from Voz", Voz.class)
				.getResultList();
	}

	@Override
	public void remover(Voz voz) {
		em.getTransaction().begin();
		em.remove(em.contains(voz) ? voz : em.merge(voz));
		em.getTransaction().commit();
	}

}
