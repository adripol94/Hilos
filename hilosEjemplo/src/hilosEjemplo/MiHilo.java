package hilosEjemplo;

import java.util.Random;

public class MiHilo extends Thread {
	private int numHilo;
	private long timeNow;
	private static final int MAX = 5;
	private static final int MIN = 0;
	
	public MiHilo(int n, long timeNow) {
		this.numHilo = n;
		this.timeNow = timeNow;
	}
	
	
	@Override
	public void run() {
		long time = System.currentTimeMillis();
		Random r = new Random();
		int n = r.nextInt(((MiHilo.MAX - MiHilo.MIN) + 1) + MiHilo.MIN);
		
		for (int i = 0; i < n; i ++) {
			try {
				sleep(n);
				System.out.println("Hilo numero " + numHilo + " Ejecucion numero " + i + " ha esperado " + n
						+ " ha esperado un total de " +  (double)(time - timeNow) / 1000000000.0 + "\n");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	
}
