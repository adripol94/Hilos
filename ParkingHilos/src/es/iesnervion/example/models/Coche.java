package es.iesnervion.example.models;

import java.util.Random;

public class Coche extends Thread{
	private int id;
	private Parking p;
	private static final int MINT = 8000;
	private static final int MAXT = 10000;
	@SuppressWarnings("unused")
	private static final int N_PUERTAS = 3;
	
	public Coche(int id, Parking p) {
		this.id = id;
		this.p = p;
	}

	@Override
	public void run() {
		String n;
		try {
			n = p.entrar(0, id);
			System.out.println("El coche " + id + " ha ocupado un aparcamiento, total=" + n);

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
	
	@SuppressWarnings("unused")
	private int elegirPuerta() {
		Random r = new Random();
		return 0;
	}
	
}
