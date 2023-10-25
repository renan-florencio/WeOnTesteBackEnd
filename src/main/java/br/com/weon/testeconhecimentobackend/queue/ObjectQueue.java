package br.com.weon.testeconhecimentobackend.queue;

import java.util.LinkedList;
import java.util.Queue;

import br.com.weon.testeconhecimentobackend.model.AbstractChannel;

/*
 * Implementação de fila de objetos
 */

public class ObjectQueue {
	
	private static ObjectQueue INSTANCE;
	private int producedObjects = 0;
	private int consumedObjects = 0;
	
	private Queue<AbstractChannel> queue = new LinkedList<AbstractChannel>();
	
	/*
	 * Método para adicionar objeto na fila
	 */
	public synchronized void add(AbstractChannel channel) {
		queue.add(channel);
		this.producedObjects ++;
	}
	
	/*
	 * Método para obter objeto da fila
	 */
	public synchronized AbstractChannel get() {
		AbstractChannel channel  = queue.poll();
		
		if (channel != null) {
			this.consumedObjects ++;
		}
		return channel;
	}
	
	/*
	 * Método para obter tamanho da fila
	 */
	public synchronized int size() {
		return this.queue.size();
	}
	
	/*
	 * Método para verificar se fila está vazia
	 */
	public synchronized boolean queueIsEmpty() {
		
		if (this.consumedObjects != 0 && size() == 0
				&& this.consumedObjects == this.producedObjects) {
			return true;
		}
		return false;
	}
	
	/*
	 * Método para obter instancia da fila
	 */
	public static ObjectQueue getInstance() {
		
		if (INSTANCE == null) {
			INSTANCE = new ObjectQueue();
		}
		
		return INSTANCE;
	}

	@Override
	public String toString() {
		return "Objetos produzidos: "+ this.producedObjects + 
				"\nObjetos consumidos: "+ this.consumedObjects;
	}
	
	
}
