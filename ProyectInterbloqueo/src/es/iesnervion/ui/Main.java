package es.iesnervion.ui;

import java.util.concurrent.Semaphore;

import es.iesnervion.ent.Filosofo;

/**
 * Problema de la Cena de Filosofos.
 * El problema de la cena de los fil�sofos o problema de los fil�sofos cenando (dining philosophers problem)
 * es un problema cl�sico de las ciencias de la computaci�n propuesto por Edsger Dijkstra en 1965 para 
 * representar el problema de la sincronizaci�n de procesos en un sistema operativo. Cabe aclarar que la 
 * interpretaci�n est� basada en pensadores chinos, quienes com�an con dos palillos, donde es m�s l�gico que se
 *  necesite el del comensal que se siente al lado para poder comer.
 *  
 *  <a>https://es.wikipedia.org/wiki/Problema_de_la_cena_de_los_fil%C3%B3sofos</a>
 *  
 * @author apol
 *
 */
public class Main {
	private static final int numFilosofos = 5;
	private static final int[][] palillosFilosofo = {
			{0, 4},
			{1, 0},
			{2,1},
			{3, 2},
			{4,3}
	};
	
	private static final Semaphore[] palillos_Semaforo = new Semaphore[numFilosofos];
	
	
	public static void main(String[] args) {
		
		for (int i = 0; i < numFilosofos; i++) {
			palillos_Semaforo[i] = new Semaphore(1);
		}
		
		for (int idFilosofo = 0; idFilosofo < numFilosofos; idFilosofo++) {
			new Filosofo(idFilosofo, palillos_Semaforo, palillosFilosofo).start();
		}
	}
}
