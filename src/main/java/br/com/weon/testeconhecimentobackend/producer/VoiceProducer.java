package br.com.weon.testeconhecimentobackend.producer;

import java.io.IOException;
import java.time.LocalDateTime;

import br.com.weon.testeconhecimentobackend.config.Config;
import br.com.weon.testeconhecimentobackend.dao.VoiceDAOImpl;
import br.com.weon.testeconhecimentobackend.model.Voice;
import br.com.weon.testeconhecimentobackend.queue.ObjectQueue;

/*
 * Produtor de mensagens do tipo Voice
 */

public class VoiceProducer implements IProducer{

	private int messageNumber = 1;
	
	/*
	 * Implementação de método produceMessage de IProducer
	 * Realiza a inserção de objetos na fila e sua persistencia no banco de dados
	 */
	
	@Override
	public void produceMessage() {
		
		Voice voice = new Voice("Origem "+messageNumber+" "+this.getClass().getName(), "Destino"+messageNumber, LocalDateTime.now());
		ObjectQueue.getInstance().add(voice);
		VoiceDAOImpl dao = new VoiceDAOImpl();
		dao.save(voice);
		
		messageNumber++;
	}
	
	/*
	 * Implementação de método run de Runnable
	 * Realiza a obtenção da configuração de timeout e execução de método de produção de mensagem
	 */

	@Override
	public void run() {
		try {
			long timeout = System.currentTimeMillis() + Long.parseLong(Config.loadProperties().getProperty("producers.timeout")) * 1000;
			
			while(System.currentTimeMillis() < timeout) {
				this.produceMessage();
			}
		}
		catch(IOException e) {
			System.out.println(e);
		}

	}

}
