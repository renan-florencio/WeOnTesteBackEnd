package br.com.weon.testeconhecimentobackend.consumidor;

import br.com.weon.testeconhecimentobackend.canal.ICanal;
import br.com.weon.testeconhecimentobackend.configuracao.Configuracao;
import br.com.weon.testeconhecimentobackend.filadeobjetos.FilaDeObjetos;
import br.com.weon.testeconhecimentobackend.persistencia.Persistencia;

/**
 * {@summary Consumidor}
 * Classe responsável por consumir fila de objetos
 */
public class Consumidor implements IConsumidor {
	
	FilaDeObjetos fila = FilaDeObjetos.singleton();
	
	@Override
	public void run() {
		
		Long timeout = System.currentTimeMillis() + Long.parseLong(Configuracao.obter().getProdutoresTimeout()) *1000;
		
		do {
			consumir();
			
		} while (fila.totalDeObjetosConsumidos() > 0 && fila.tamanho() == 0 && System.currentTimeMillis() > timeout);
		
	}

	@Override
	public void consumir() {
		
		ICanal canal = fila.obter();
		
		if (canal != null) {
			canal.acessar();
			System.out.println("Removendo da base de dados: "+ canal);
			Persistencia.singleton().remover(canal);
		}
	}

}
