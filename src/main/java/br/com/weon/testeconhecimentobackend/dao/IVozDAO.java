package br.com.weon.testeconhecimentobackend.dao;

import java.util.List;
import java.util.UUID;

import br.com.weon.testeconhecimentobackend.canal.Voz;

/**
 * {@summary IVozDAO}
 * DAO de entidade Voz
 */

@SuppressWarnings("javadoc")
public interface IVozDAO {

	void salvar(Voz voz);
	Voz obter(UUID id);
	List<Voz> obterTodos();
	void remover(Voz voz);
	
}
