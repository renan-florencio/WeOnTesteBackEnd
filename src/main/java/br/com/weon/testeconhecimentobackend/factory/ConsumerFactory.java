package br.com.weon.testeconhecimentobackend.factory;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import br.com.weon.testeconhecimentobackend.consumer.IConsumer;

public class ConsumerFactory {
	
	public static List<IConsumer> getInstances(Supplier<IConsumer> consumer,int quantity) throws InvalidParameterException{
		
		if (quantity <= 0) {
			throw new InvalidParameterException("Não é possível instanciar "+quantity+" Consumers!");
		}
		
		return Stream.generate(consumer).limit(quantity).toList();
	}
}
