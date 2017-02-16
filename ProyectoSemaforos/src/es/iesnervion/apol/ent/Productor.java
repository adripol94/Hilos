package es.iesnervion.apol.ent;

public class Productor extends Thread {
	private Character[] pizarra;
	private ClaseThread conexionExcritura;
	
	public Productor(Character[] caracteres, ClaseThread c){
		pizarra = caracteres;
		conexionExcritura = c;
	}

	@Override
	public void run() {
		for (int i=0; i < pizarra.length; i++) {
			conexionExcritura.put(pizarra[i]);
			
			System.out.println("EL PRODUCTOR HA INSERTADO UN CARACTER " + pizarra[i]
					+ " Y DORMIR");
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
