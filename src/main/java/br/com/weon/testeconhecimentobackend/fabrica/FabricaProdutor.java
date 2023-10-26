package br.com.weon.testeconhecimentobackend.fabrica;

import java.util.List;

import br.com.weon.testeconhecimentobackend.canal.Canal;
import br.com.weon.testeconhecimentobackend.produtor.IProdutor;

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
	 */
	public static List<? extends IProdutor> fabricarProdutor(Canal canal, int quantidade){
		
	}
}
