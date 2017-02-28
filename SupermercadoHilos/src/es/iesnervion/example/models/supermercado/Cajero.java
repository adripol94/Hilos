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
	private Cola cola;
	private int id;
	
	protected Cajero(Cola cola, int id) {
		this.cola = cola;
		this.id = id;
	}

	protected void addToTail(Cliente c) {
		cola.addClientToTail(c);
	}
	
	@Override
	public void run() {
		cola.atenderClient();
	}
	
}
