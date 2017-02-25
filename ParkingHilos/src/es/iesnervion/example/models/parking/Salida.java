package es.iesnervion.example.models.parking;

import java.util.concurrent.Semaphore;

/**
 * Clase salida, simboliza una salida, cuando un coche va a salir debera usar este metodo, tiene un semaforo propio que va desde 0 a 1 si la salida esta o no ocupada
 * @author adripol94
 *
 */
class Salida {
	/**
	 * Semaforo para llevar la cola.
	 */
	@Deprecated
	private Semaphore s;
	
	/**
	 * Constructor por el cual se introducira el semaforo Salida generico de parking. Usar {@link Salida#salida()}.
	 * @param s
	 */
	@Deprecated
	Salida(Semaphore s) {
		this.s = s;
	}
	
	/**
	 * Constructor vacio.
	 */
	protected Salida(){
		
	}
	
	/**
	 * El coche usa una salida y tras salir deja libre dicha salida, tambien llama a {@link Parking#outCar()} para decrementar el contador.
	 * @throws InterruptedException
	 */
	protected void salidaSemaforo() throws InterruptedException {
		s.acquire();
		//Decrementacion del contador
		Parking.outCar();
		s.release();
	}
	
	/**
	 * El coche usa una salida, tras salir dejara la salida libre de nuevo, tambien a {@link Parking#outCar()} para decrementar el contador.
	 */
	protected void salida() throws InterruptedException {
		//Decrementacion del contador
		Parking.outCar();
	}
}
