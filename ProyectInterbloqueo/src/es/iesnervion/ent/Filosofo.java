package es.iesnervion.ent;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Filosofo extends Thread {
	private int idFilosofo;
	private final Semaphore[] semaforo;
	private final int[][] palillosFilosofo;
	private final int palilloIzq;
	private final int palilloDer;
	private final Random tiempoAleatorio = new Random(); 
	
	
	public Filosofo(int idFilosofo, Semaphore[] semaforo ,int[][] palillosFilosofo) {
		super();
		this.idFilosofo = idFilosofo;
		this.semaforo = semaforo;
		this.palillosFilosofo = palillosFilosofo;
		this.palilloDer = palillosFilosofo[idFilosofo][1];
		this.palilloIzq = palillosFilosofo[idFilosofo][0];
	}
	
	protected void comer() {
		if (semaforo[palilloIzq].tryAcquire()) {
            if (semaforo[palilloDer].tryAcquire()) {
                System.out.println("FILÓSOFO " + idFilosofo + " ESTÁ COMIENDO.");
                try {
                    // Simular el tiempo que tarda el filósofo en comer,
                    // entre 0.5 y 1 segundos:
                    sleep(tiempoAleatorio.nextInt(1000) + 500);
                } catch (InterruptedException ex) {
                    System.out.println("Error : " + ex.toString());
                }
                System.out.println("Filósofo " + idFilosofo + " ha terminado de comer.Libera los palillos " + palilloIzq + " y " + palilloDer);
                // Ya que ha terminado de comer libera el semáforo-palillo de su derecha:
                semaforo[palilloDer].release();
            }
            // Y libera también el semáforo palillo de su izuierda.
            semaforo[palilloIzq].release();
        } else { // el filósofo no ha podido coger el pallillo, no puede comer.
            System.out.println("Filósofo " + idFilosofo + " está hambriento.");
        }
	}
	
	 protected void pensar() {
	        System.out.println("Filósofo " + idFilosofo + " está pensando.");
	        try {
	            // El tiempo que tarda el filósofo en pensar, entre 100 y 1000 milisegundos:
	            Filosofo.sleep(tiempoAleatorio.nextInt(1000) + 100);
	        } catch (InterruptedException ex) {
	            System.out.println("Error en el método pensar(): " + ex.toString());
	        }
	    }

	@Override
	public void run() {
		while(true){
			pensar();
			comer();
		}
		
	}
	
}
