package br.com.weon.testeconhecimentobackend.fabrica;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import br.com.weon.testeconhecimentobackend.consumidor.Consumidor;
import br.com.weon.testeconhecimentobackend.consumidor.IConsumidor;

/**
 * {@summary FabricaConsumidor}
 * Classe de fábrica responsável por retornar instancias de IConsumidor
 */
public class FabricaConsumidor {

	/**
	 * {@summary FabricaConsumidor.fabricarConsumidor()}
	 * @param quantidade - Quantidade de instancias a serem criadas
	 * @return List<{@link IConsumidor} - Lista de consumidores
	 * @throws InvalidParameterException - Lançada caso o parâmetro quantidade seja <= 0
	 */
	public static List<IConsumidor> fabricarConsumidor(int quantidade) throws InvalidParameterException{
		if (quantidade <= 0) {
			throw new InvalidParameterException("Não é possível criar "
					+ quantidade+" instancias de IConsumidor");
		}
		
		Supplier<IConsumidor> consumidor = Consumidor::new;
		
		return Stream.generate(consumidor).limit(quantidade).toList();
	}
}
