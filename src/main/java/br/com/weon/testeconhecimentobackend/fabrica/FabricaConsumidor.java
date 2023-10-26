package br.com.weon.testeconhecimentobackend.fabrica;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import br.com.weon.testeconhecimentobackend.consumidor.Consumidor;
import br.com.weon.testeconhecimentobackend.consumidor.IConsumidor;

/**
 * {@summary FabricaConsumidor}
 * Classe de fábrica responsável por retornar instancias de Consumidor
 */
public class FabricaConsumidor {

	/**
	 * {@summary FabricaConsumidor.fabricarConsumidor()}
	 * @param quantidade - Quantidade de instancias a serem criadas
	 * @return List<{@link IConsumidor} - Lista de consumidores
	 */
	public static List<? extends IConsumidor> fabricarConsumidor(int quantidade){
		if (quantidade <= 0) {
			throw new InvalidParameterException("Não é possível criar "
					+ quantidade+" instancias de IConsumidor");
		}
		
		Supplier<Consumidor> consumidor = Consumidor::new;
		
		return Stream.generate(consumidor).limit(quantidade).toList();
	}
}
