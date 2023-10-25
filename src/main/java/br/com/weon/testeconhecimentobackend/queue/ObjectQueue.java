package br.com.weon.testeconhecimentobackend.queue;

import java.util.LinkedList;
import java.util.Queue;

import br.com.weon.testeconhecimentobackend.model.AbstractChannel;

public class ObjectQueue {
	
	private static ObjectQueue INSTANCE;
	private int producedObjects = 0;
	private int consumedObjects = 0;
	
	private Queue<AbstractChannel> queue = new LinkedList<AbstractChannel>();
	
	public synchronized void add(AbstractChannel channel) {
		queue.add(channel);
		this.producedObjects ++;
	}
	
	public synchronized AbstractChannel get() {
		AbstractChannel channel  = queue.poll();
		
		if (channel != null) {
			this.consumedObjects ++;
		}
		return channel;
	}
	
	public synchronized int size() {
		return this.queue.size();
	}
	
	public synchronized boolean queueIsEmpty() {
		
		if (this.consumedObjects != 0 && size() == 0
				&& this.consumedObjects == this.producedObjects) {
			return true;
		}
		return false;
	}
	
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
