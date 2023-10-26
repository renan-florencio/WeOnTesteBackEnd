package br.com.weon.testeconhecimentobackend.factory;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Test;

import br.com.weon.testeconhecimentobackend.producer.ChatProducer;
import br.com.weon.testeconhecimentobackend.producer.EmailProducer;
import br.com.weon.testeconhecimentobackend.producer.IProducer;
import br.com.weon.testeconhecimentobackend.producer.VoiceProducer;

class ProducerFactoryTest {


	@Test
	void returnIsInstanceOfIProducerTest() {
		assertTrue(ProducerFactory.getInstances(VoiceProducer::new, 1).get(0) instanceof IProducer,"A ProducerFactory não retornou uma instancia de IProducer - VoiceProducer!");
		assertTrue(ProducerFactory.getInstances(ChatProducer::new, 1).get(0) instanceof IProducer,"A ProducerFactory não retornou uma instancia de IProducer - ChatProducer!");
		assertTrue(ProducerFactory.getInstances(EmailProducer::new, 1).get(0) instanceof IProducer,"A ProducerFactory não retornou uma instancia de IProducer - EmailProducer!");
	}
	
	@Test
	void createOneVoiceProducerTest() {
		assertEquals(1,ProducerFactory.getInstances(VoiceProducer::new, 1).size(),"A ProducerFactory não criou uma instancia de IProducer - VoiceProducer!");
		assertEquals(1,ProducerFactory.getInstances(ChatProducer::new, 1).size(),"A ProducerFactory não criou uma instancia de IProducer - ChatProducer!");
		assertEquals(1,ProducerFactory.getInstances(EmailProducer::new, 1).size(),"A ProducerFactory não criou uma instancia de IProducer - EmailProducer!");
	}
	
	@Test
	void createThreeVoiceProducersTest() {
		assertEquals(3,ProducerFactory.getInstances(VoiceProducer::new, 3).size(),"A ProducerFactory não criou três instancias de IProducer - VoiceProducer!");
		assertEquals(3,ProducerFactory.getInstances(ChatProducer::new, 3).size(),"A ProducerFactory não criou três instancias de IProducer - ChatProducer!");
		assertEquals(3,ProducerFactory.getInstances(EmailProducer::new, 3).size(),"A ProducerFactory não criou três instancias de IProducer - EmailProducer!");
	}

	@Test
	void throwInvalidParameterExceptionTest(){
		Exception exception = assertThrows(InvalidParameterException.class, () -> ProducerFactory.getInstances(ChatProducer::new, 0), "Não foi lançada uma InvalidParameterException ao tentar criar 0 instancias da Producer!");

		String actualMessage = exception.getMessage();
		String expectedMessage = "Não é possível instanciar 0 Producer!";
		
		assertTrue(expectedMessage.contains(actualMessage), "A mensagem de exceção não é a esperada!");
	}

}
