package es.iesnervion.example.ui;

import es.iesnervion.example.models.Coche;
import es.iesnervion.example.models.parking.Parking;

/**
 * Clase Main (Test).
 * @author adripol94
 *
 */
public class Main {
	
	/**
	 * Numero de coches que se generaran.
	 */
	private static final int N_COCHES = 100;
	
	/**
	 * Main for Console.
	 * @param args
	 */
	public static void main(String[] args) {
		//Inicializacion del parking
		Parking p = new Parking(3, 2, 2);
		
		//Inicializacion de los hilos/coches.
		for (int i=0; i < N_COCHES; i++) {
			new Coche(i, p).start();
		}
	}
}
