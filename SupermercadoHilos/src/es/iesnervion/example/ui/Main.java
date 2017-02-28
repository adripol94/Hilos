package es.iesnervion.example.ui;

import java.util.Scanner;

import es.iesnervion.example.models.Cliente;
import es.iesnervion.example.models.supermercado.Supermercado;

public class Main {
	
	/**
	 * Escaner global.
	 */
	private static final Scanner in = new Scanner(System.in);
	
	/**
	 * Cada minuto sera 10 ms para acortar la partida
	 * 1m = 60000ms.
	 */
	private static final int MiN_TO_MS = 10;
	
	/**
	 * Tiempo en HORAS de la virtualizacion
	 */
	private static final int TIME_VIRTUALIZATION = 5;
	
	/**
	 * Metodo de consola principal
	 * @param args Argumentos
	 */
	public static void main(String[] args) {
		int nCajero, nClientes, tiempoDeVirtualizacion, vecesGeneraraClientes, numClientGenerados;
		Supermercado supermercado;
		Cliente c;
		
		System.out.println("Indique el numero de cajeros que tendra el supermercado...");
		nCajero = in.nextInt();
		System.out.println("indique el numero de clientes por minuto");
		nClientes = in.nextInt();
		
		vecesGeneraraClientes = 0;
		numClientGenerados = 0;
		
		supermercado = new Supermercado(nCajero);
		
		//Tiempo que correra el programa
		tiempoDeVirtualizacion = (TIME_VIRTUALIZATION * 60) * 100;
		
		System.out.println("------------------------------------>ATENCION: Inicio de virtualizacion empezando");
		
		for (int i=0; i < tiempoDeVirtualizacion; i++) {
			//Cuando i sea un minuto, EJ: 60 * 0 (La primera vez), 60 * 1 (Primer min), 60 * 2 (Segundo min).
			if (i == (60 * vecesGeneraraClientes)) {
				System.out.println("Genrando usuario " + i);
				vecesGeneraraClientes++;
				// Genera un numero n de clientes en ese minuto
				for (int j=0; j < nClientes; j++) {
					new Cliente(numClientGenerados, supermercado).start();
					numClientGenerados++;
				}
			}
		}
		System.out.println("ATENCION: Tiempo de virtualizacion terminado---------------------------------->");
	}
}
