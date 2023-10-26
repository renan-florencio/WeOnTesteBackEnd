package br.com.weon.testeconhecimentobackend.factory;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import br.com.weon.testeconhecimentobackend.consumer.IConsumer;
/**
 * {@summary ConsumerFactory}
 * Fábrica de objetos Consumer
 */
public class ConsumerFactory {
	
	/**
	 * {@summary ConsumerFactory.getInstances(Supplier<IConsumer> consumer,int quantity)}
	 * Método fábrica que realiza a criação de objetos Consumer
	 * 
	 * @param consumer : Supplier<IConsumer> (Consumer::new) -> Recebe supplier para instanciação de consumer
	 * @param quantity : int -> Recebe quantidade de instâncias a serem criadas
	 * 
	 * @return List<{@link IConsumer}>
	 * @throws InvalidParameterException 
	 */
	public static List<IConsumer> getInstances(Supplier<IConsumer> consumer,int quantity) throws InvalidParameterException{
		
		if (quantity <= 0) {
			throw new InvalidParameterException("Não é possível instanciar "+quantity+" Consumers!");
		}
		
		return Stream.generate(consumer).limit(quantity).toList();
	}
}
