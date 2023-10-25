package br.com.weon.testeconhecimentobackend.producer;

import java.io.IOException;
import java.time.LocalDateTime;

import br.com.weon.testeconhecimentobackend.config.Config;
import br.com.weon.testeconhecimentobackend.dao.VoiceDAOImpl;
import br.com.weon.testeconhecimentobackend.model.Voice;
import br.com.weon.testeconhecimentobackend.queue.ObjectQueue;

public class VoiceProducer implements IProducer{

	private int messageNumber = 1;
	
	@Override
	public void produceMessage() {
		
		Voice voice = new Voice("Origem "+messageNumber+" "+this.getClass().getName(), "Destino"+messageNumber, LocalDateTime.now());
		VoiceDAOImpl dao = new VoiceDAOImpl();
		dao.save(voice);
		ObjectQueue.getInstance().add(voice);
		
		messageNumber++;
	}

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
