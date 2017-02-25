package es.iesnervion.example.models.parking;

import java.util.concurrent.Semaphore;

/**
 * Clase salida, simboliza una salida, cuando un coche va a salir debera usar este metodo, tiene un semaforo propio que va desde 0 a 1 si la salida esta o no ocupada
 * @author adripol94
 *
 */
class Salida {
	private Semaphore s;
	
	
	Salida(Semaphore s) {
		this.s = s;
	}
	
	/**
	 * El coche usa una salida y tras salir del todo la deja libre, tambien llama a Parking para reducir el contador.
	 * @throws InterruptedException
	 */
	protected void salida() throws InterruptedException {
		s.acquire();
		Parking.outCar();
		s.release();
	}
}
