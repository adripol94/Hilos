package es.iesnervion.example.models;

import java.util.Random;

import es.iesnervion.example.models.parking.Parking;

public class Coche extends Thread{
	private int id;
	private Parking p;
	private static final int MINT = 800;
	private static final int MAXT = 1000;
	private static final int N_PUERTAS = 2;
	private int barrera;
	
	public Coche(int id, Parking p) {
		this.id = id;
		this.p = p;
		barrera = elegirPuerta();
	}

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
	
	
	private int tiempoEspera() {
		Random r = new Random();
		return r.nextInt((MAXT - MINT) +1) + MINT;
	}
	
	private int elegirPuerta() {
		Random r = new Random();
		return r.nextInt(((N_PUERTAS-1) - 0) + 1) + 0;
	}
	
}
