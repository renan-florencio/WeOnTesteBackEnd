package br.com.weon.testeconhecimentobackend.producer;

/**
 * {@summary IProducer}
 * Interface criada para injeção de dependência e definição de producers como Runnable
 */
public interface IProducer extends Runnable {

	/**
	 * {@summary IProducer.produceMessage()}
	 * Método a ser implementado por qualquer classe produtora para produção de mensagens
	 */
	void produceMessage();
	
}
