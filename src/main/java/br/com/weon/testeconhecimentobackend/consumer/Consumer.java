package br.com.weon.testeconhecimentobackend.consumer;

import br.com.weon.testeconhecimentobackend.model.AbstractChannel;
import br.com.weon.testeconhecimentobackend.queue.ObjectQueue;

public class Consumer implements IConsumer {
	
	/*
	 * Implementação de método consumeMessage de IConsumer
	 * Realiza a obtenção de objeto na fila
	 */
	@Override
	public void consumeMessage() {
		
		AbstractChannel channel = ObjectQueue.getInstance().get();
		
		if (channel != null) {
			System.out.println("Consumido: " + channel);
		}
	}

	/*
	 * Implementação de método run de Runnable
	 * Realiza verificação em fila e chama o método de consumo caso a fila possua objetos
	 */
	@Override
	public void run() {
		
		while (ObjectQueue.getInstance().queueIsEmpty() == false) {
			this.consumeMessage();
		}
	}

}
