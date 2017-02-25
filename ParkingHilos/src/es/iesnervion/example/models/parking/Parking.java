package es.iesnervion.example.models.parking;

import java.util.concurrent.Semaphore;

public class Parking {
	private static Semaphore sEntrada;
	private static Semaphore sSalida;
	private static int aparcamientosOcupados = 0;
	private Entrada[] entradas;
	private Salida[] salidas;
	private int sizeParking;
	private int contador;
	
	public Parking(int sizeParking, int numEntradas, int numSalidas) {
		//El numero de permisos es el tamaño del parking
		sEntrada = new Semaphore(sizeParking);
		//Solo 1 porque la salida o se puede usar porque hay un coche o no hay nadie y se usa
		sSalida = new Semaphore(1);
		this.sizeParking = sizeParking;
		
		//Salidas y entradas
		salidas = new Salida[numSalidas];
		entradas = new Entrada[numEntradas];
		//Contador correspondiente para darles permisos y ordenar las colas de entrada
		contador = 0;
		
		for (int i=0; i < entradas.length; i++)
			entradas[i] = new Entrada(sEntrada);
		
		for (int i=0; i < salidas.length; i++)
			salidas[i] = new Salida(sSalida);
	}
	
	/**
	 * Metodo para entrar del parking
	 * @param barrera
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public synchronized String entrar(int barrera, int id) throws Exception {
		//For debug -> Para saber si podria llegar a ser mas de 21
		if (aparcamientosOcupados > sizeParking)
			throw new Exception("Ha superado el limite " + aparcamientosOcupados);
		
		System.out.println("El coche " + id + " va a intentar entrar en la barrera n=" + barrera);
		
		entradas[barrera].entrada();
		
		return aparcamientosOcupados + " numero de permisos " + sEntrada.availablePermits();
	}
	
	/**
	 * Metodo para salir del parking
	 * @param barrera
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String salir(int barrera, int id) throws Exception {
		//For debug -> Para saber si podria llegar a ser menos de 21
		if (aparcamientosOcupados < 0)
			throw new Exception("Error el aparcamiento es infrerior a 0 Valor=" + aparcamientosOcupados);
		
		System.out.println("El coche " + id + " va a salir por la barrera n=" + barrera);
		
		salidas[barrera].salida();
		entradas[contador].release();
		
		aumentarContador();
		
		return aparcamientosOcupados + " numero de permisos " + sEntrada.availablePermits();
	}
	
	/**
	 * Suma 1 el contador de coches
	 */
	protected static void addCar() {
		aparcamientosOcupados++;
	}
	
	/**
	 * Resta 1 el contador de coches
	 */
	protected static void outCar() {
		aparcamientosOcupados--;
	}
	
	/**
	 * Aumenta el contador encargador de dar los permisos a las barreras conrrespondiente.
	 * EJ: primero la n1, segundo la n2, tercero la n3, despues la 1 de nuevo y asi...
	 */
	private synchronized void aumentarContador() {
		contador++;
		if (contador >= 2)
			contador = 0;
	}
	 
}
