package br.com.weon.testeconhecimentobackend.factory;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import br.com.weon.testeconhecimentobackend.producer.IProducer;

/*
 * Fábrica de objetos Producer
 */
public class ProducerFactory {

	
	/*
	 * Realiza a criação de objetos Consumer
	 * 
	 * @Param Supplier<IProducer> producer -> Supplier para criação do objeto "Objeto::new"
	 * @Param int quantity -> Quantidade de objetos a serem criados
	 * 
	 * @Return List<IProducer>
	 */
	public static List<IProducer> getInstances(Supplier<IProducer> producer,int quantity) throws InvalidParameterException{
		
		if (quantity <=0) {
			throw new InvalidParameterException("Não é possível instanciar "+quantity+" Producer!");
		}
		
		return Stream.generate(producer).limit(quantity).toList();
	}
}
