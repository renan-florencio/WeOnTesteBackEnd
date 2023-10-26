package br.com.weon.testeconhecimentobackend.consumer;

/**
 * {@summary IConsumer}
 * Interface criada para injeção de dependência e definição de consumers como Runnable
 */
public interface IConsumer extends Runnable {
	
	/**
	 * {@summary IConsumer.consumeMessage()}
	 * Método a ser implementado por qualquer classe consumidora para o consumo de mensagens
	 */
	void consumeMessage();
}
