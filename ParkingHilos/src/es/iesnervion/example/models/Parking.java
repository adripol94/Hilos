package es.iesnervion.example.models;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Parking {
	private Semaphore s = new Semaphore(10);
	private int aparcamientosOcupados;
	private final static int TOTAL_APARCAMIENTOS = 10;
	
	
	public Parking() {
		aparcamientosOcupados = 0;
	}
	
	public String entrar(int barrera, int id) throws Exception {
		//For debug -> Para saber si podria llegar a ser mas de 21
			if (aparcamientosOcupados > TOTAL_APARCAMIENTOS)
				throw new Exception("Ha superado el limite " + aparcamientosOcupados);
			
		System.out.println("El coche " + id + " ha quedado bloqueado en la barrera " + barrera);
			
		s.acquire();
		
		aparcamientosOcupados++;
		
		return aparcamientosOcupados + " numero de permisos " + s.availablePermits();
		
	}
	
	
	public String salir(int barrera, int id) throws Exception {
		//For debug -> Para saber si podria llegar a ser menos de 21
		if (aparcamientosOcupados < 0)
			throw new Exception("Error el aparcamiento es infrerior a 0 Valor=" + aparcamientosOcupados);
		
		aparcamientosOcupados--;
		
		s.release();
			
		return aparcamientosOcupados + " numero de permisos " + s.availablePermits();
	}
	 
}
