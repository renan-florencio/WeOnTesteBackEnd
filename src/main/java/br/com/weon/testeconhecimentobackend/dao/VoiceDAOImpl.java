package br.com.weon.testeconhecimentobackend.dao;

import br.com.weon.testeconhecimentobackend.model.Voice;
import br.com.weon.testeconhecimentobackend.service.EntityManagerSingleton;
import jakarta.transaction.Transactional;

/*
 * Implementação de DAO para Email
 */
public class VoiceDAOImpl implements IVoiceDAO {

	/*
	 * Método save Recebe um objeto Voice e realiza a persistencia do mesmo no banco
	 * de dados
	 * 
	 * @Param Voice
	 */
	@Override
	@Transactional
	public void save(Voice voice) {
		EntityManagerSingleton.save(voice);
	}

	/*
	 * Método delete Recebe um objeto Voice e realiza a remoção do mesmo no banco de
	 * dados
	 * 
	 * @Param Voice
	 */
	@Override
	@Transactional
	public void delete(Voice voice) {
		EntityManagerSingleton.remove(voice);
	}

}
