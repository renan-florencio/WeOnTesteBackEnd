package br.com.weon.testeconhecimentobackend.factory;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import br.com.weon.testeconhecimentobackend.producer.IProducer;

/**
 * {@summary ProducerFactory}
 * Fábrica de objetos Producer
 */
public class ProducerFactory {

	
	/**
	 * {@summary ProducerFactory.getInstances(Supplier<IProducer> producer,int quantity)}
	 * Realiza a criação de objetos Consumer
	 * 
	 * @param producer : Supplier<IProducer>  -> Supplier para criação do objeto "Objeto::new"
	 * @param quantity : int  -> Quantidade de objetos a serem criados
	 * 
	 * @return List<{@link IProducer}>
	 * @throws InvalidParameterException
	 */
	public static List<IProducer> getInstances(Supplier<IProducer> producer,int quantity) throws InvalidParameterException{
		
		if (quantity <=0) {
			throw new InvalidParameterException("Não é possível instanciar "+quantity+" Producer!");
		}
		
		return Stream.generate(producer).limit(quantity).toList();
	}
}
