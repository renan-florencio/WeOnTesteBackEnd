package br.com.weon.testeconhecimentobackend.fabrica;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import br.com.weon.testeconhecimentobackend.canal.Canal;
import br.com.weon.testeconhecimentobackend.produtor.*;

/**
 * {@summary FabricaProdutor}
 * Classe de fábrica responsável por retornar instancias de IProdutor
 */
public class FabricaProdutor {
	
	/**
	 * {@summary FabricaProdutor.fabricarProdutor()}
	 * @param canal - Tipo de produtor para qual será gerada as intancias
	 * @param quantidade - Quantidade de instancias a serem criadas
	 * @return List<{@link IProdutor}>
	 * @throws InvalidParameterException - Lançada caso o parâmetro quantidade seja <= 0;
	 */
	public static List<IProdutor> fabricarProdutor(Canal canal, int quantidade) throws InvalidParameterException{
		if (quantidade <= 0) {
			throw new InvalidParameterException("Não é possível criar "
					+ quantidade+" instancias de IProdutor");
		}
		
		Supplier<IProdutor> produtor = null;
		
		switch (canal) {
		case VOZ:
			produtor = ProdutorVoz::new;
			break;
			
		case EMAIL:
			produtor = ProdutorEmail::new;
			break;
			
		case CHAT:
			produtor = ProdutorChat::new;
			break;
			
		default:
			break;
		}
		
		return Stream.generate(produtor).limit(quantidade).toList();
	}
}
