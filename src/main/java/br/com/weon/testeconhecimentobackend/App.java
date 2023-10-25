package br.com.weon.testeconhecimentobackend;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.Properties;
import br.com.weon.testeconhecimentobackend.config.Config;
import br.com.weon.testeconhecimentobackend.consumer.Consumer;
import br.com.weon.testeconhecimentobackend.consumer.IConsumer;
import br.com.weon.testeconhecimentobackend.factory.ConsumerFactory;
import br.com.weon.testeconhecimentobackend.factory.ProducerFactory;
import br.com.weon.testeconhecimentobackend.producer.ChatProducer;
import br.com.weon.testeconhecimentobackend.producer.EmailProducer;
import br.com.weon.testeconhecimentobackend.producer.IProducer;
import br.com.weon.testeconhecimentobackend.producer.VoiceProducer;
import br.com.weon.testeconhecimentobackend.queue.ObjectQueue;
import br.com.weon.testeconhecimentobackend.service.EntityManagerSingleton;


public class App 
{
    public static void main( String[] args )
    {
    	try {
    		
    		EntityManagerSingleton.getInstance();
    		Properties conf = Config.loadProperties();
    		int voiceProducersInstances = Integer.parseInt(conf.getProperty("producers.voice.instances"));
    		int chatProducersInstances = Integer.parseInt(conf.getProperty("producers.chat.instances"));
    		int emailProducersInstances = Integer.parseInt(conf.getProperty("producers.email.instances"));
    		int consumerInstances = Integer.parseInt(conf.getProperty("consumers.instances"));

            List<IProducer> voiceProducer = ProducerFactory.getInstances(VoiceProducer::new, 
            		voiceProducersInstances);
            
            List<IProducer> chatProducer = ProducerFactory.getInstances(EmailProducer::new, 
            		chatProducersInstances);
            
            List<IProducer> emailProducer = ProducerFactory.getInstances(ChatProducer::new, 
            		emailProducersInstances);
            
            List<IConsumer> consumers = ConsumerFactory.getInstances(Consumer::new, 
            		consumerInstances);
            
            
            voiceProducer.forEach(x -> new Thread(x).start());
            chatProducer.forEach(x -> new Thread(x).start());
            emailProducer.forEach(x -> new Thread(x).start());
            consumers.forEach(x -> new Thread(x).start());
            
            while(true) {
            	
            	if(ObjectQueue.getInstance().queueIsEmpty()) {
            		System.out.println("\n------------------------\n");
                    System.out.println(ObjectQueue.getInstance());
                    break;
            	}
            }
            
    	}
    	catch (InvalidParameterException e) {
    		System.out.println(e.getMessage());
    	}
    	catch (IOException e) {
    		System.out.println(e.getMessage());
    	}
    }
}
