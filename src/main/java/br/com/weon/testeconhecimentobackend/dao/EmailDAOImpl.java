package br.com.weon.testeconhecimentobackend.dao;

import br.com.weon.testeconhecimentobackend.model.Email;
import br.com.weon.testeconhecimentobackend.service.EntityManagerSingleton;
import jakarta.transaction.Transactional;

/*
 * Implementação de DAO para Email
 */
public class EmailDAOImpl implements IEmailDAO {
	
	/*
	 * Método save
	 * Recebe um objeto Email e realiza a persistencia do mesmo no banco de dados
	 * 
	 * @Param Email
	 */
	@Override
	@Transactional
	public void save(Email email) {
		EntityManagerSingleton.save(email);
	}

	/*
	 * Método delete
	 * Recebe um objeto Email e realiza a remoção do mesmo no banco de dados
	 * 
	 * @Param Email
	 */
	@Override
	@Transactional
	public void delete(Email email) {
		EntityManagerSingleton.remove(email);
	}

}
