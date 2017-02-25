package es.iesnervion.example.models.parking;

import java.util.concurrent.Semaphore;

/**
 * Clase entrada, simboliza una entrada, utilizara el semaforo de entrada de la clase parking, y recogera un permiso, despues utilizara el metodo estatico para aumentar el contador
 * @author adripol94
 *
 */
class Entrada {
	private Semaphore s;
	
	protected Entrada(Semaphore s) {
		this.s = s;
	}
	
	/**
	 * Retura un permiso simbolizando que hay 1 espacio menos
	 * @throws InterruptedException
	 */
	protected void entrada() throws InterruptedException {
		s.acquire();
		Parking.addCar();
	}
	
	/**
	 * Libera un permiso, simbolizando que hay 1 espacio
	 */
	protected void release(){
		s.release();
	}
	
}
