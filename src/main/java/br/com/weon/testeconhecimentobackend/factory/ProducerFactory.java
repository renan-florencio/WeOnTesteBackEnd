package br.com.weon.testeconhecimentobackend.factory;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import br.com.weon.testeconhecimentobackend.producer.IProducer;

public class ProducerFactory {

	public static List<IProducer> getInstances(Supplier<IProducer> producer,int quantity) throws InvalidParameterException{
		
		if (quantity <=0) {
			throw new InvalidParameterException("Não é possível instanciar "+quantity+" Producer!");
		}
		
		return Stream.generate(producer).limit(quantity).toList();
	}
}
