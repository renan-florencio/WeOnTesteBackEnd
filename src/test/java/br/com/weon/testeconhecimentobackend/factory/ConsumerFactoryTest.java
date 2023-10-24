package br.com.weon.testeconhecimentobackend.factory;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Test;

import br.com.weon.testeconhecimentobackend.consumer.Consumer;

class ConsumerFactoryTest {

	@Test
	void returnIsInstanceOfIConsumerTest() {
		assertTrue(ConsumerFactory.getInstances(Consumer::new, 1).get(0) instanceof ConsumerFactoryTest, "A ConsumerFactory não retornou uma instancia de IConsumer!");
	}
	
	@Test
	void createOneConsumerTest() {
		assertEquals(1,ConsumerFactory.getInstances(Consumer::new, 1).size(),"A ConsumerFactory não criou uma instancia de Consumer!");
	}
	
	@Test
	void createThreeConsumerTest() {
		assertEquals(3,ConsumerFactory.getInstances(Consumer::new, 3).size(),"A ConsumerFactory não criou três instancias de Consumer!");
	}
	
	@Test
	void throwInvalidParameterExceptionTest(){
		Exception exception = assertThrows(InvalidParameterException.class, () -> ConsumerFactory.getInstances(Consumer::new, 0), "Não foi lançada uma InvalidParameterException ao tentar criar 0 instancias da Consumer!");

		String actualMessage = exception.getMessage();
		String expectedMessage = "Não é possível instanciar 0 Consumers!";
		
		assertTrue(expectedMessage.contains(actualMessage), "A mensagem de exceção não é a esperada!");
	}

}
