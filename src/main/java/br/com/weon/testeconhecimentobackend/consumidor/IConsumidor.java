package br.com.weon.testeconhecimentobackend.consumidor;
/**
 * {@summary IConsumidor}
 * Interface para implementação de classe consumidora
 */
public interface IConsumidor extends Runnable {
	
	/**
	 * Método responsável por realizar o consumo da fila
	 */
	void consumir();
}
