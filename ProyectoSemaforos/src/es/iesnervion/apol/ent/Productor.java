package es.iesnervion.apol.ent;

public class Productor extends Thread {
	private Character[] pizarra;
	private Monitor conexionExcritura;

	//Aleatorio
	
	public Productor(Character[] caracteres, Monitor c){
		pizarra = caracteres;
		conexionExcritura = c;
	}

	@Override
	public void run() {
		for (int i=0; i < pizarra.length; i++) {
			conexionExcritura.put(pizarra[i]);
			
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
