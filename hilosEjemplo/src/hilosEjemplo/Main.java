package hilosEjemplo;

public class Main {

	public static void main(String[] args) {
		System.out.println("Iniciando la ejecucion \n");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < 5; i++) {
			MiHilo hilo = new MiHilo(i, System.currentTimeMillis());
			hilo.start();
		}
		
		System.out.println("Fin del hilo principal \n");
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
