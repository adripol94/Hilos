package es.iesnervion.example.models.parking;

import java.util.concurrent.Semaphore;

/**
 * Clase salida, simboliza una salida, cuando un coche va a salir debera usar este metodo, tiene un semaforo propio que va desde 0 a 1 si la salida esta o no ocupada
 * @author adripol94
 *
 */
class Salida {
	private Semaphore s;
	
	/**
	 * Constructor por el cual se introducira el semaforo Salida generico de parking.
	 * @param s
	 */
	Salida(Semaphore s) {
		this.s = s;
	}
	
	/**
	 * El coche usa una salida y tras salir deja libre dicha salida, tambien llama a {@link Parking#outCar()} para decrementar el contador.
	 * @throws InterruptedException
	 */
	protected void salida() throws InterruptedException {
		s.acquire();
		//Decrementacion del contador
		Parking.outCar();
		s.release();
	}
}
