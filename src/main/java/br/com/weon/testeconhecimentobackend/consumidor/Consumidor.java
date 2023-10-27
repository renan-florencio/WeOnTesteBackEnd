package br.com.weon.testeconhecimentobackend.consumidor;

import br.com.weon.testeconhecimentobackend.canal.ICanal;
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
		while (true) {
			
			if (fila.totalDeObjetosConsumidos() > 0 && fila.tamanho() == 0) {
				break;
			}
			
			consumir();
		}
		
	}

	@Override
	public void consumir() {
		
		ICanal canal = fila.obter();
		
		if (canal != null) {
			canal.acessar();
			Persistencia.remover(canal);
		}
	}

}
