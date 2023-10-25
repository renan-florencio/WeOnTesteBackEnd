package br.com.weon.testeconhecimentobackend.factory;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import br.com.weon.testeconhecimentobackend.consumer.IConsumer;
/*
 * Fábrica de objetos Consumer
 */
public class ConsumerFactory {
	
	/*
	 * Realiza a criação de objetos Consumer
	 * 
	 * @Param Supplier<IConsumer> consumer -> Supplier para criação do objeto "Objeto::new"
	 * @Param int quantity -> Quantidade de objetos a serem criados
	 * 
	 * @Return List<IConsumer>
	 */
	public static List<IConsumer> getInstances(Supplier<IConsumer> consumer,int quantity) throws InvalidParameterException{
		
		if (quantity <= 0) {
			throw new InvalidParameterException("Não é possível instanciar "+quantity+" Consumers!");
		}
		
		return Stream.generate(consumer).limit(quantity).toList();
	}
}
