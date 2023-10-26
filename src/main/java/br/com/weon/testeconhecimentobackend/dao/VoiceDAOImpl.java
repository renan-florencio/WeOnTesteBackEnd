package br.com.weon.testeconhecimentobackend.dao;

import br.com.weon.testeconhecimentobackend.model.Voice;
import br.com.weon.testeconhecimentobackend.service.EntityManagerSingleton;
import jakarta.transaction.Transactional;

/**
 * {@summary VoiceDAOImpl}
 * Implementação de DAO para Email
 */
public class VoiceDAOImpl implements IVoiceDAO {

	/**
	 * {@summary VoiceDAOImpl.save(Voice voice)}
	 * Método save
	 * <br>Recebe um objeto Voice e realiza a persistencia do mesmo no banco
	 * de dados
	 *
	 */
	@Override
	@Transactional
	public void save(Voice voice) {
		EntityManagerSingleton.save(voice);
	}

	/**
	 * {@summary VoiceDAOImpl.delete(Voice voice)}
	 * Método delete
	 * <br>Recebe um objeto Voice e realiza a remoção do mesmo no banco de
	 * dados
	 */
	@Override
	@Transactional
	public void delete(Voice voice) {
		EntityManagerSingleton.remove(voice);
	}

}
