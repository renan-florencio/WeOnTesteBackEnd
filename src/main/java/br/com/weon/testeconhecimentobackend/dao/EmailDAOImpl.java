package br.com.weon.testeconhecimentobackend.dao;

import java.util.List;

import br.com.weon.testeconhecimentobackend.model.Email;
import br.com.weon.testeconhecimentobackend.service.EntityManagerSingleton;
import jakarta.persistence.EntityManager;

/*
 * Implementação de DAO para Email
 */
public class EmailDAOImpl implements IEmailDAO {
	
	private EntityManager em = EntityManagerSingleton.getInstance();
	
	
	/*
	 * Método save
	 * Recebe um objeto Email e realiza a persistencia do mesmo no banco de dados
	 * 
	 * @Param Email
	 */
	@Override
	public void save(Email email) {
		em.persist(email);
	}

	/*
	 * Método delete
	 * Recebe um objeto Email e realiza a remoção do mesmo no banco de dados
	 * 
	 * @Param Email
	 */
	@Override
	public void delete(Email email) {
		em.remove(email);
	}

	/*
	 * Método getAll
	 * Realiza a busca de todos os objetos cadastrados na tabela Email
	 * 
	 * @Return List<Email>
	 */
	@Override
	public List<Email> getAll() {
		return em.createQuery("from Email e", Email.class)
				.getResultList();
	}

}
