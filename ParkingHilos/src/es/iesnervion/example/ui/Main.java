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
	 * Numero de las barreras para entrar que hay en el parking.
	 */
	public static final int N_BARRERAS_ENTRADA = 4;
	
	/**
	 * Numero de las barreras para salir que hay en el parking.
	 */
	public static final int N_BARRERAS_SALIDA = 2;
	
	/**
	 * Numero de zonas de aparcamientos del parking.
	 */
	private static final int TAMAÑO_PARKING = 15;
	
	/**
	 * Main for Console.
	 * @param args
	 */
	public static void main(String[] args) {
		//Inicializacion del parking
		Parking p = new Parking(TAMAÑO_PARKING, N_BARRERAS_ENTRADA, N_BARRERAS_SALIDA);
		
		//Inicializacion de los hilos/coches.
		for (int i=0; i < N_COCHES; i++) {
			new Coche(i, p).start();
		}
	}
}
