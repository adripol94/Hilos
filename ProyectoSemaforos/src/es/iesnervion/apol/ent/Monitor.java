package es.iesnervion.apol.ent;

import java.util.concurrent.Semaphore;
//Monitor o contenedor
public class Monitor {
	private Character[] c; //Array
	private Semaphore semaforo;
	private int indice;
	
	public Monitor(int size) {
		semaforo = new Semaphore(0);
		indice = 0;
		c = new Character[size];
	}
	
	public void put(char c){
		this.c[indice] = c;
		System.out.println("EL PRODUCTOR HA INSERTADO UN CARACTER " + this.c[indice]
				+ " Y DORMIR");
		indice++;	
		semaforo.release();
	}
	
	public Character get(int i) {
		Character res = null;
		
		try {
			semaforo.acquire();
			System.out.println("El lector ha podido hacer GET------------------> " + c[i]);
			 res = c[i];
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
}
