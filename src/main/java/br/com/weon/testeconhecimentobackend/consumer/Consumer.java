package br.com.weon.testeconhecimentobackend.consumer;

import br.com.weon.testeconhecimentobackend.model.AbstractChannel;
import br.com.weon.testeconhecimentobackend.queue.ObjectQueue;

public class Consumer implements IConsumer {

	@Override
	public void consumeMessage() {
		
		AbstractChannel channel = ObjectQueue.getInstance().get();
		
		if (channel != null) {
			System.out.println("Consumido: " + channel);
		}
	}

	@Override
	public void run() {
		
		while (ObjectQueue.getInstance().queueIsEmpty() == false) {
			this.consumeMessage();
		}
	}

}
