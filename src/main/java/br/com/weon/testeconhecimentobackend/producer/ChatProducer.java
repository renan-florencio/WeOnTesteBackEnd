package br.com.weon.testeconhecimentobackend.producer;

import java.io.IOException;
import java.time.LocalDateTime;

import br.com.weon.testeconhecimentobackend.config.Config;
import br.com.weon.testeconhecimentobackend.dao.ChatDAOImpl;
import br.com.weon.testeconhecimentobackend.model.Chat;
import br.com.weon.testeconhecimentobackend.queue.ObjectQueue;

public class ChatProducer implements IProducer {
	
	private int messageNumber = 1;
	
	@Override
	public void produceMessage() {
		
		Chat chat = new Chat("Origem "+messageNumber+" "+this.getClass().getName(), "Destino "+messageNumber, LocalDateTime.now());
		ChatDAOImpl dao = new ChatDAOImpl();
		dao.save(chat);
		ObjectQueue.getInstance().add(chat);
		
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
