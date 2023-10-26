package br.com.weon.testeconhecimentobackend.queue;

import java.util.LinkedList;
import java.util.Queue;

import br.com.weon.testeconhecimentobackend.model.AbstractChannel;

/**
 * {@summary ObjectQueue}
 * Fila de objetos do tipo FIFO
 */
public class ObjectQueue {
	
	private static ObjectQueue INSTANCE;
	private int producedObjects = 0;
	private int consumedObjects = 0;
	
	private Queue<AbstractChannel> queue = new LinkedList<AbstractChannel>();
	
	/**
	 * {@summary ObjectQueue.add(AbstractChannel channel)}
	 * Método para adicionar objeto na fila
	 * 
	 * @param channel : {@link AbstractChannel}
	 */
	public synchronized void add(AbstractChannel channel) {
		queue.add(channel);
		this.producedObjects ++;
	}
	
	/**
	 * {@summary ObjectQueue.get()}
	 * Método para obter objeto da fila
	 * 
	 * @return {@link AbstractChannel}
	 */
	public synchronized AbstractChannel get() {
		
		AbstractChannel channel  = queue.poll();
			
		if (channel != null) {
			this.consumedObjects ++;
		}
		return channel;

	}
	
	/**
	 * {@summary ObjectQueue.size()}
	 * Método para obter tamanho da fila
	 * 
	 * @return int
	 */
	public synchronized int size() {
		return this.queue.size();
	}
	
	/**
	 * {@summary ObjectQueue.queueIsEmpty()}
	 * Método para verificar se fila está vazia
	 * 
	 * @return boolean
	 */
	public synchronized boolean queueIsEmpty() {
		
		if (this.consumedObjects != 0 && size() == 0
				&& this.consumedObjects == this.producedObjects) {
			return true;
		}
		return false;
	}
	
	/**
	 * {@summary ObjectQueue.getInstance()}
	 * Método estático para obter instancia da fila
	 * 
	 * @return {@link ObjectQueue}
	 */
	public static synchronized ObjectQueue getInstance() {
		
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
