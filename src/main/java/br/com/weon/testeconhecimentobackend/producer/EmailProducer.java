package br.com.weon.testeconhecimentobackend.producer;

import java.io.IOException;
import java.time.LocalDateTime;

import br.com.weon.testeconhecimentobackend.config.Config;
import br.com.weon.testeconhecimentobackend.dao.EmailDAOImpl;
import br.com.weon.testeconhecimentobackend.model.Email;
import br.com.weon.testeconhecimentobackend.queue.ObjectQueue;

public class EmailProducer implements IProducer{
	
	private int messageNumber = 1;
	
	@Override
	public void produceMessage() {
		
		Email email = new Email("Origem "+messageNumber+" "+this.getClass().getName(), "Destino"+messageNumber, LocalDateTime.now());
		EmailDAOImpl dao = new EmailDAOImpl();
		dao.save(email);
		ObjectQueue.getInstance().add(email);
		
		messageNumber++;
	}

	@Override
	public void run() {
		try {
			Config.loadProperties().get("producers.timeout");
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
