package br.com.weon.testeconhecimentobackend.producer;

import java.io.IOException;
import java.time.LocalDateTime;

import br.com.weon.testeconhecimentobackend.config.Config;
import br.com.weon.testeconhecimentobackend.dao.ChatDAOImpl;
import br.com.weon.testeconhecimentobackend.model.Chat;
import br.com.weon.testeconhecimentobackend.queue.ObjectQueue;

/**
 * {@summary ChatProducer}
 * Produtor de mensagens do tipo Chat
 */
public class ChatProducer implements IProducer {
	
	private int messageNumber = 1;
	
	/**
	 * {@summary ChatProducer.produceMessage()}
	 * Implementação de método produceMessage de IProducer
	 * <br>Realiza a inserção de objetos na fila e sua persistencia no banco de dados
	 */
	@Override
	public void produceMessage() {
		
		Chat chat = new Chat("Origem "+messageNumber+" "+this.getClass().getName(), "Destino "+messageNumber, LocalDateTime.now());
		ObjectQueue.getInstance().add(chat);
		ChatDAOImpl dao = new ChatDAOImpl();
		dao.save(chat);
		
		messageNumber++;
	}

	
	/**
	 * {@summary ChatProducer.run()}
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
