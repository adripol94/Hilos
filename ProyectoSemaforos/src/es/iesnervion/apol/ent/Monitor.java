package es.iesnervion.apol.ent;

import java.util.concurrent.Semaphore;

public class ClaseThread {
	private Character c;
	private Semaphore semaforo;
	
	public ClaseThread() {
		semaforo = new Semaphore(0);
	}
	
	public void put(char c){
		this.c = c;
		semaforo.release();
	}
	
	public Character get() {
		Character res = null;
		if (semaforo.tryAcquire()) {
			System.out.println("El lector ha podido hacer GET------------------> " + c);
			res = c;
		} else {
			System.out.println("El lector ha intentado hacer GET ha sido IMPOSIBLE---------->");
		}
		
		return res;
	}
}
