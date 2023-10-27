package br.com.weon.testeconhecimentobackend.produtor;

/**
 * {@summary IProdutor}
 * Interface para implementação de classe produtora
 */
public interface IProdutor extends Runnable{

	/**
	 * Método responsável por realizar a produção de objetos para fila e persistir na base de dados
	 */
	void produzir();
}
