package br.com.weon.testeconhecimentobackend.producer;

import java.io.IOException;
import java.time.LocalDateTime;

import br.com.weon.testeconhecimentobackend.config.Config;
import br.com.weon.testeconhecimentobackend.dao.EmailDAOImpl;
import br.com.weon.testeconhecimentobackend.model.Email;
import br.com.weon.testeconhecimentobackend.queue.ObjectQueue;

/*
 * Produtor de mensagens do tipo Email
 */

public class EmailProducer implements IProducer{
	
	private int messageNumber = 1;
	
	/*
	 * Implementação de método produceMessage de IProducer
	 * Realiza a inserção de objetos na fila e sua persistencia no banco de dados
	 */
	
	@Override
	public void produceMessage() {
		
		Email email = new Email("Origem "+messageNumber+" "+this.getClass().getName(), "Destino"+messageNumber, LocalDateTime.now());
		ObjectQueue.getInstance().add(email);
		EmailDAOImpl dao = new EmailDAOImpl();
		dao.save(email);
		
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
