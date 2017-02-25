package es.iesnervion.example.models.parking;

import java.util.concurrent.Semaphore;

/**
 * Clase entrada, simboliza una entrada, utilizara el semaforo de entrada de la clase parking, y recogera un permiso, despues utilizara el metodo estatico para aumentar el contador
 * @author adripol94
 *
 */
class Entrada {
	@Deprecated
	private static Semaphore s;
	
	/**
	 * Constructor por el cual se introducira el semaforo Entrada generico de parking. Usar {@link Entrada#Entrada()}.
	 * @param s
	 */
	@Deprecated
	protected Entrada(Semaphore s) {
		Entrada.s = s;
	}
	
	/**
	 * Constructor vacio.
	 */
	protected Entrada() {
		
	}
	
	/**
	 * Hace un acquire al semaforo de entrada y llama a {@link Parking#addCar()}. Usar {@link Entrada#entrar()}.
	 * @throws InterruptedException {@link InterruptedException}
	 */
	@Deprecated
	protected synchronized void entrarSemaforo() throws InterruptedException {
		//s.acquire();
		Parking.addCar();
	}
	
	/**
	 * Comprueba si los aparcamientos ocupados de Parking estan llenos {@code Parking#aparcamientosOcupados == Parking#sizeParking}, de ser así
	 * bloqueará el hilo hasta que sea llamado.
	 * @throws InterruptedException
	 */
	protected synchronized void entrar() throws InterruptedException {
		if (Parking.aparcamientosOcupados == Parking.sizeParking)
			wait();
		Parking.addCar();
	}
	
	/**
	 * Hace a {@link #s} un {@link Semaphore#release()}.
	 */
	@Deprecated
	protected void release(){
		s.release();
	}
	
	/**
	 * Notifica al hilo que este en la cola de puede continuar.
	 */
	protected synchronized void unlock() {
		notify();
	}
	
}
