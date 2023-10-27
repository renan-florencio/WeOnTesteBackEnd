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
	
	@Override
	public synchronized void salvar(Voz voz) {
		Persistencia.salvar(voz);
	}

	@Override
	public synchronized Voz obter(UUID id) {
		return Persistencia.consultaNomeada("obterVoz", Voz.class)
				.setParameter("id", id).getSingleResult();
	}

	@Override
	public synchronized List<Voz> obterTodos() {
		return Persistencia.criarConsulta("from Voz", Voz.class)
				.getResultList();
	}

	@Override
	public synchronized void remover(Voz voz) {
		Persistencia.remover(voz);
	}

}
