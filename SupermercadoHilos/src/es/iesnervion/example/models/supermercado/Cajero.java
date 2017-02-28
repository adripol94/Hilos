package es.iesnervion.example.models.supermercado;

import es.iesnervion.example.models.Cliente;

/**
 * Clase cajero protegida, esta clase se manejara en {@link Supermercado} aqui
 * el usuario se esperara a pagar y saldra del supermercado.
 * 
 * @author adripol94
 *
 */
class Cajero extends Thread {
	/**
	 * Cada cajero tiene una cola asignada
	 */
	private Cola cola;
	
	/**
	 * Identificador del cajero
	 */
	private int id;
	
	/**
	 * Constructor: Inicializacion y asignacion de los parametros
	 * @param cola Cola asignada al cajero
	 * @param id Indentificador del cajero
	 */
	protected Cajero(Cola cola, int id) {
		this.cola = cola;
		this.id = id;
	}

	/**
	 * Permite añadir un cliente a la cola del cajero
	 * @param c
	 */
	protected void addToTail(Cliente c) {
		cola.addClientToTail(c);
	}
	
	/**
	 * Llama a la cola para efectue su accion
	 */
	@Override
	public void run() {
		cola.atenderClient();
	}
	
}
