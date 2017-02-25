package es.iesnervion.example.models.parking;

import java.util.concurrent.Semaphore;

/**
 * Clase entrada, simboliza una entrada, utilizara el semaforo de entrada de la clase parking, y recogera un permiso, despues utilizara el metodo estatico para aumentar el contador
 * @author adripol94
 *
 */
class Entrada {
	private Semaphore s;
	
	/**
	 * Constructor por el cual se introducira el semaforo Entrada generico de parking.
	 * @param s
	 */
	protected Entrada(Semaphore s) {
		this.s = s;
	}
	
	/**
	 * Hace un acquire al semaforo de entrada y llama a {@link Parking#addCar()}
	 * @throws InterruptedException {@link InterruptedException}
	 */
	protected void entrar() throws InterruptedException {
		s.acquire();
		Parking.addCar();
	}
	
	/**
	 * Hace a {@link #s} un {@link Semaphore#release()}.
	 */
	protected void release(){
		s.release();
	}
	
}
