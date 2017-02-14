package es.iesnervion.ui;

import java.util.concurrent.Semaphore;

import es.iesnervion.ent.Filos;
import es.iesnervion.ent.Filosofo;
import es.iesnervion.ent.Respuesta;

public class Principal {
	private static int maxFilosofos = 5;
	private static int[][] palilloFilosofos = {
			{0, 4},
			{0, 1},
			{1, 2},
			{2, 3},
			{3, 4}
	};
	
	private static Semaphore[] semaforo = new Semaphore[maxFilosofos];

	public static void main(String[] args) {
		
		for (int i = 0; i < maxFilosofos; i++)
			semaforo[i] = new Semaphore(1);
		
		for (int i=0; i < maxFilosofos; i++)
			new Filos(i, semaforo, palilloFilosofos).start();
	}
	
}
