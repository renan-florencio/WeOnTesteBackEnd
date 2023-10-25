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
		System.out.println("Adicionado: "+channel);
		this.producedObjects ++;
	}
	
	public synchronized AbstractChannel get() {
		AbstractChannel channel  = queue.peek();
		remove(channel);
		return channel;
	}
	
	public synchronized void remove(AbstractChannel channel) {
		queue.remove(channel);
		this.consumedObjects ++;
	}
	
	public synchronized int size() {
		return this.queue.size();
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
