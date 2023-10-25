package br.com.weon.testeconhecimentobackend.consumer;

public interface IConsumer extends Runnable {
	
	void consumeMessage();
}
