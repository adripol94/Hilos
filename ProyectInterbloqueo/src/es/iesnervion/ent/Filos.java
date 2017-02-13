package es.iesnervion.ent;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Un filoso necesita usar los dos palillos apra comer en caso en el que no haya podido comer
 * este pasará hambre, pasará hambre un total de 5 veces al pasar hambre morirá. Una vez que haya comido
 * 5 veces el filoso se levantará de la mesa y se irá.
 * 
 * Por cada vez que pase hambre el se decrementará por 1 vecesComido y viceversa.
 * 
 * @author adripol94
 *
 */
public class Filos extends Thread {
	private int idFilosofo;
	private int vecesPasadoHambre;
	private int vecesComido;
	private boolean comido;
	private final Semaphore[] semaforo;
	private final int[][] palillosFiloso;
	private final int palilloDer;
	private final int palilloIzq;
	private static final int ESTA_LLENO = 5;
	private static final int ESTA_MUERTO = 8;
	private final Random ramdon = new Random();
	
	public Filos(int idFilosofo, Semaphore[] semaforo, int[][] palillosFilosofo) {
		super();
		this.idFilosofo = idFilosofo;
		vecesPasadoHambre = 0;
		comido = false;
		this.palillosFiloso = palillosFilosofo;
		this.semaforo = semaforo;
		this.palilloDer = palillosFilosofo[idFilosofo][1];
		this.palilloIzq = palillosFilosofo[idFilosofo][0];
	}
	
	@Override
	public void run() {
		while(vecesPasadoHambre < ESTA_MUERTO && vecesComido < ESTA_LLENO) {
			if (comido)
				pensarComido();
			else
				pensar();
			comer();
		}
	}

	public void pensarComido() {
		comido = false;
		
		System.out.println("El filosodo " + idFilosofo + " esta pensando TRAS COMER");
		
		try {
			//un filosofo tarda entre 100 y 1000 milusengundos
			sleep(ramdon.nextInt(800) + 500);
		} catch (InterruptedException e) {
			System.out.println("Ha ocurrido un erro " + e.getMessage());
		}
	}
	
	public void pensar() {
		System.out.println("El filosodo " + idFilosofo + " esta pensando");
		
		try {
			//un filosofo tarda entre 100 y 1000 milusengundos
			sleep(ramdon.nextInt(1000) + 100);
		} catch (InterruptedException e) {
			System.out.println("Ha ocurrido un erro " + e.getMessage());
		}
	}
	
	public void pasoHambre() {
		
		vecesPasadoHambre++;
		vecesComido--;
		if (vecesPasadoHambre == ESTA_MUERTO) {
			System.out.println("El filosofo " + idFilosofo + " HA MUERTO!!!!!!**********************************");
		}
	
	}
	
	public void comer() {
		if (semaforo[palilloIzq].tryAcquire()) {
			if (semaforo[palilloDer].tryAcquire()) {
				vecesComido++;
				vecesPasadoHambre--;
				
				System.out.println("**********************EL FILOSOFO " + idFilosofo + " ESTA COMIENDO");
				
				try {
					//Un filosofo tarda entre 1s y 0.5s
					sleep(ramdon.nextInt(100) + 500);
				} catch(InterruptedException e) {
					System.out.println("Ha ocurrido un error " + e.getMessage());
				}
				
				System.out.println("Filosofo " + idFilosofo + " ha terminado de comer, libera "
						+ "los palillos " + palilloDer + " y " + palilloIzq);
				
				if (vecesComido == ESTA_LLENO) {
					System.out.println("************************************************El filosofo " + idFilosofo + " Ya NO TIENE HAMBRE");
				}
				
				semaforo[palilloDer].release();
				
			} else {
				
				System.out.println("El filosofo " + idFilosofo + " a intentado coger el palillo DERECHO (TIENE HAMBRE)");
				pasoHambre();
			}
			semaforo[palilloIzq].release();
		} else {
			System.out.println("**********El filosofo " + idFilosofo + " a intentado coger el palillo DERECHO (TIENE HAMBRE)*******");
			pasoHambre();
		}
	}
	
}
