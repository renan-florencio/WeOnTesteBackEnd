package br.com.weon.testeconhecimentobackend.dao;

import java.util.List;

import br.com.weon.testeconhecimentobackend.model.Voice;
import br.com.weon.testeconhecimentobackend.service.EntityManagerSingleton;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

public class VoiceDAOImpl implements IVoiceDAO{
	
	private EntityManager em = EntityManagerSingleton.getInstance();
	
	@Override
	@Transactional
	public void save(Voice voice) {
		em.persist(voice);		
	}

	@Override
	@Transactional
	public void delete(Voice voice) {
		em.remove(voice);
	}

	@Override
	@Transactional
	public List<Voice> getAll() {
		return em.createQuery("from Voice v", Voice.class)
				.getResultList();
	}

}
