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

            List<IProducer> voice = ProducerFactory.getInstances(VoiceProducer::new, 
            		Integer.parseInt(conf.getProperty("producers.voice.instances")));
            
            List<IProducer> chat = ProducerFactory.getInstances(EmailProducer::new, 
            		Integer.parseInt(conf.getProperty("producers.email.instances")));
            
            List<IProducer> email = ProducerFactory.getInstances(ChatProducer::new, 
            		Integer.parseInt(conf.getProperty("producers.chat.instances")));
            
            List<IConsumer> consumers = ConsumerFactory.getInstances(Consumer::new, 
            		Integer.parseInt(conf.getProperty("consumers.instances")));
            
            voice.forEach(x -> new Thread(x).start());
            chat.forEach(x -> new Thread(x).start());
            email.forEach(x -> new Thread(x).start());
            consumers.forEach(x -> new Thread(x).start());
            
            while (true){
            	
            	if (ObjectQueue.getInstance().size() == 0) {
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
