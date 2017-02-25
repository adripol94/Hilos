package es.iesnervion.example.models;

import java.util.Random;

import es.iesnervion.example.models.parking.Parking;

/**
 * Hilo simbolico de coche.
 * @author adripol94
 *
 */
public class Coche extends Thread{
	/**
	 * El id del coche, normalente de referenciara al valor del contador del Main.
	 */
	private int id;
	
	/**
	 * Clase parking.
	 */
	
	private Parking p;
	
	/**
	 * Tiempo maximo para la espera dentro del parking.
	 */
	private static final int MINT = 800;
	
	/**
	 * Tiempo minimo para la espera dentro del parking
	 */
	private static final int MAXT = 1000;
	
	/**
	 * Numero de puertas de la entrada. Necesario para sacar el numero aleatorio.
	 */
	private static final int N_PUERTAS = 2;
	
	/**
	 * Numero de la barrera a usar para la entrada.
	 */
	private int barrera;
	
	//Constructor------------------------
	
	/**
	 * Constructor de coche, inicalizacion con un id y con la clase {@link Parking}.
	 * @param id Id del coche.
	 * @param p {@link Parking}
	 */
	public Coche(int id, Parking p) {
		this.id = id;
		this.p = p;
		barrera = elegirPuerta();
	}

	/**
	 * Metodo sobrescrito, encargado de entrar en el parking, esperar y salir de dicho parking.
	 * @see Parking
	 * @see Thread#sleep(long)
	 * @see Parking#entrar(int, int)
	 * @see Parking#salir(int, int)
	 */
	@Override
	public void run() {
		String n;
		try {
			//Refinar: Tengo que tener un objeto entrada y en el parking usar dicho arrays de objecto entrada.
			n = p.entrar(barrera, id);
			System.out.println("El coche " + id + " ha ocupado un aparcamiento, total=" + n + ", ha entrado por la barrera " + barrera);

			int t = tiempoEspera();
			System.out.println("El coche " + id + " va a esperar el el aparcamiento un total de " + t);
			sleep(t);
			n = p.salir(0, id);
			
			System.out.println("El coche " + id + " ha salido del aparcamiento, total=" + n);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Devuelve un aleatorio del tiempo de espera dentro del parking
	 * @return Int
	 */
	private int tiempoEspera() {
		Random r = new Random();
		return r.nextInt((MAXT - MINT) +1) + MINT;
	}
	
	/**
	 * Devuelve un aleatorio del numero de puerta a usar.
	 * @return
	 */
	private int elegirPuerta() {
		Random r = new Random();
		return r.nextInt(((N_PUERTAS-1) - 0) + 1) + 0;
	}
	
}
