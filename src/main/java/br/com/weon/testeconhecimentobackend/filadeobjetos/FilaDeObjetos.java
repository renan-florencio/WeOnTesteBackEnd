package br.com.weon.testeconhecimentobackend.filadeobjetos;

import java.util.LinkedList;
import java.util.Queue;

import br.com.weon.testeconhecimentobackend.canal.ICanal;

/**
 * {@summary FilaDeObjetos}
 * Fila para armazenamento de objetos produzidos por produtores
 */

public class FilaDeObjetos {
	
	private static FilaDeObjetos INSTANCE;
	private int objetosProduzidos = 0;
	private int objetosConsumidos = 0;
	private Queue<ICanal> fila = new LinkedList<ICanal>();
	
	
	/**
	 * Método para adicionar um novo canal a fila
	 * @param canal - canal que está sendo adicionada a fila
	 */
	public synchronized void adicionar(ICanal canal) {
		fila.add(canal);
		objetosProduzidos++;
	}
	
	/**
	 * Método para obter e remover um canal do topo da fila
	 * @return ICanal - retorna um objeto que implemente ICanal
	 */
	public synchronized ICanal obter() {
		
		ICanal canal = fila.poll();
		
		if (canal != null) {
			objetosConsumidos++;
		}
		
		return canal;
		
	}
	
	/**
	 * Método para obter tamaho da fila
	 * @return int - Tamanho da fila
	 */
	public synchronized int tamanho() {
		return fila.size();
	}
	
	/**
	 * Métdo para obter total de objetos consumidos
	 * @return int - Total de objetos consumidos
	 */
	public synchronized int totalDeObjetosConsumidos() {
		return objetosConsumidos;
	}
	
	/**
	 * Método para criar instancia de fila
	 */
	public static void criar() {
		if(INSTANCE == null) {
			INSTANCE = new FilaDeObjetos();
		}
	}
	
	/**
	 * Método para retornar instancia de fila
	 * @return FilaDeObjetos - Fila que contem os objetos para serem consumidos
	 */
	public static FilaDeObjetos singleton() {
		return INSTANCE;
	}
	
	
	@Override
	public String toString() {
		return "Objetos produzidos: "+ objetosProduzidos + 
				"\nObjetos consumidos: "+ objetosConsumidos;
	}
}
