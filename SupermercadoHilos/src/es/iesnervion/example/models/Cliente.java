package es.iesnervion.example.models;

import java.util.Random;

import es.iesnervion.example.models.supermercado.Supermercado;

/**
 * Cliente que va a entrar en {@link Supermercado}. <br>
 * Obtiene el identificador del cliente para ser identificado por consola, se
 * crear aleatoriamente el tiempo que pasará comprando (ronda entra 5 y 60
 * minutos).
 * 
 * @author adripol94
 *
 */
public class Cliente extends Thread {

	/**
	 * Tiempo minimo que el cliente pasará comprando, 5 minutos. Estan divididos
	 * entra 10. 30000
	 */
	private final static int MINT = 30000;

	/**
	 * Tiempo maximo que el cliente pasará comprando, 60 minutos. Estan dividos
	 * entra 10. 360000
	 */
	private final static int MAXM = 360000;

	/**
	 * Clase que conectará el cliente con la cola
	 */
	private Supermercado conductor;

	/**
	 * Identidad del cliente.
	 */
	private int id;

	/**
	 * Tiempo que se pasará el cliente en el supermercado.
	 */
	private int tiempoSupermercado;

	/*
	 * Tiempo que pasará el cliente en el cajero
	 */
	private int tiempoCompra;

	/**
	 * Numero aleatorio del cajero que va a usar
	 */
	private int nCajero;

	/**
	 * Constructor del cliente.
	 * 
	 * @param id
	 *            Identificador del cliente.
	 */
	public Cliente(int id, Supermercado conductor) {
		this.id = id;
		this.conductor = conductor;
		Random tiempo = new Random();
        this.tiempoSupermercado = tiempo.nextInt(550) + 50;
        this.tiempoCompra = tiempoCompra / (tiempo.nextInt(50)+10);
		nCajero = aleatorio(0, conductor.numCajeros());
	}

	/**
	 * RUN: Ejecucion de la virtualizacion de un cliente en un supermercado.
	 */
	@Override
	public void run() {
		System.out.println("Cliente " + id + " esta dentro del super");
		try {
			sleep(tiempoSupermercado);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conductor.moverseCola(this);
	}

	/**
	 * Devuelve un numero aleatorio entra {@value #MINM} y {@value #MINM}.
	 * 
	 * @return int aleatorio.
	 */
	private int aleatorio() {
		return (int) (Math.random() * MAXM + MIN_PRIORITY);
	}

	/**
	 * Devuelve un numero aleatorio. Entra min y max por parametro
	 * 
	 * @param min
	 *            Numero minimo en la aleatoriedad.
	 * @param max
	 *            Numero maximo en la aleatoriedad.
	 * @return numero aleatorio.
	 */
	private int aleatorio(int min, int max) {
		return (int) (Math.random() * max + min);
	}

	// Metodo Get & Set

	/**
	 * Tiempo de espera en el supermercado comprando.
	 * 
	 * @return Int
	 */
	public int getTiempoSupermercado() {
		return tiempoSupermercado;
	}

	/**
	 * Tiempo de espera pagando sus productos en el cajero.
	 * 
	 * @return Int
	 */
	public int getTiempoPago() {
		return tiempoCompra;
	}

	public int getNCajero() {
		return nCajero;
	}

}
