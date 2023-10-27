package br.com.weon.testeconhecimentobackend.consumidor;

import br.com.weon.testeconhecimentobackend.canal.ICanal;
import br.com.weon.testeconhecimentobackend.filadeobjetos.FilaDeObjetos;

/**
 * {@summary Consumidor}
 * Classe responsável por consumir fila de objetos
 */
public class Consumidor implements IConsumidor {
	
	FilaDeObjetos fila = FilaDeObjetos.singleton();
	
	@Override
	public void run() {
		while (fila.tamanho() > 0 && fila.totalDeObjetosConsumidos() == 0) {
			consumir();
		}
	}

	@Override
	public void consumir() {
		
		ICanal canal = fila.obter();
		canal.acessar();

	}

}
