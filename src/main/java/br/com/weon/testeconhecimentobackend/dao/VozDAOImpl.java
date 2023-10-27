package br.com.weon.testeconhecimentobackend.dao;

import java.util.List;
import java.util.UUID;

import br.com.weon.testeconhecimentobackend.canal.Voz;
import br.com.weon.testeconhecimentobackend.persistencia.Persistencia;

/**
 * {@summary VozDAOImpl}
 * Implementação de interface DAO de voz
 */
public class VozDAOImpl implements IVozDAO {
	
	private Persistencia persistencia = Persistencia.singleton();
	
	@Override
	public synchronized void salvar(Voz voz) {
		persistencia.salvar(voz);
	}

	@Override
	public synchronized Voz obter(UUID id) {
		return persistencia.consultaNomeada("obterVoz", Voz.class)
				.setParameter("id", id).getSingleResult();
	}

	@Override
	public synchronized List<Voz> obterTodos() {
		return persistencia.criarConsulta("from Voz", Voz.class)
				.getResultList();
	}

	@Override
	public synchronized void remover(Voz voz) {
		persistencia.remover(voz);
	}

}
