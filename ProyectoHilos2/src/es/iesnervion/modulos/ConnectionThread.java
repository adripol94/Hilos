package es.iesnervion.modulos;

public class ConnectionThread {
	private char contens;
	private boolean avilable;
	
	
	public synchronized char get(){
		while (!avilable) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		avilable = false;
		notifyAll();
		return contens;
	}
	
	public synchronized void put(char c) {
		while (avilable) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		contens = c;
		avilable = true;
		notifyAll();
		
	}
}
