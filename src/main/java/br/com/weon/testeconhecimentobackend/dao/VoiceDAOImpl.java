package br.com.weon.testeconhecimentobackend.dao;

import java.util.List;

import br.com.weon.testeconhecimentobackend.model.Voice;
import br.com.weon.testeconhecimentobackend.service.EntityManagerSingleton;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

/*
 * Implementação de DAO para Email
 */
public class VoiceDAOImpl implements IVoiceDAO{
	
	private EntityManager em = EntityManagerSingleton.getInstance();
	
	/*
	 * Método save
	 * Recebe um objeto Voice e realiza a persistencia do mesmo no banco de dados
	 * 
	 * @Param Voice
	 */
	@Override
	@Transactional
	public void save(Voice voice) {
		em.persist(voice);		
	}

	/*
	 * Método delete
	 * Recebe um objeto Voice e realiza a remoção do mesmo no banco de dados
	 * 
	 * @Param Voice
	 */
	@Override
	@Transactional
	public void delete(Voice voice) {
		em.remove(voice);
	}

	/*
	 * Método getAll
	 * Realiza a busca de todos os objetos cadastrados na tabela Email
	 * 
	 * @Return List<Voice>
	 */
	@Override
	@Transactional
	public List<Voice> getAll() {
		return em.createQuery("from Voice v", Voice.class)
				.getResultList();
	}

}
