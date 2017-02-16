package es.iesnervion.apol.ent;

import java.util.Arrays;

public class Lector extends Thread {
	private ClaseThread cThread;
	//Añadido para ver resultado
	private Character[] pizarra;
	private int size;
	private int contador;
	
	public Lector(int size, ClaseThread c) {
		cThread = c;
		pizarra = new Character[size];
		this.size = size;
		contador = 0;
	}
	
	private void esperar(long n){
		try {
			sleep(n);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		boolean salir = false;
		Character c;
		
		while (!salir) {
			c = cThread.get();
			
			if (c != null) {
				System.out.println("Caracter recogido!-----> " + c);
				
				pizarra[contador] = c;
				contador++;
				
				if (contador >= size)
					salir = true;
				
			} else {
				esperar(0);
			}
		}
		
		System.out.println(Arrays.toString(pizarra));
	}
	
	
	

}
