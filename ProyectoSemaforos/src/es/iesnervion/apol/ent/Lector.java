package es.iesnervion.apol.ent;

import java.util.Arrays;

public class Lector extends Thread {
	private Monitor cThread;
	//Añadido para ver resultado
	private int size;
	
	public Lector(int size, Monitor c) {
		cThread = c;
		this.size = size;
	}
//	
//	private void esperar(long n){
//		try {
//			sleep(n);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	@Override
	public void run() {
		Character c;
		
		for (int i =0; i < size; i++) {
			c = cThread.get(i);
			
			if (c != null) {
				System.out.println("Caracter recogido!-----> " + c);
				
			}
		}
		
		//System.out.println(Arrays.toString(pizarra));
	}
	
	
	

}
