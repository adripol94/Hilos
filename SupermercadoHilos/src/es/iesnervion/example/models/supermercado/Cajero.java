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
	 * Cola de un cajero.
	 */
	private Cola cola;

	/**
	 * Indetificador del cajero.
	 */
	private int id;

	/**
	 * Cajero que inicializa su cola con el identificador correspondiente.
	 * 
	 * @param id
	 *            Identificador del cajero
	 */
	protected Cajero(int id) {
		cola = new Cola(id);
		this.id = id;
	}

	protected void add(Cliente c) {
		cola.add(c);
		System.out.println(
				"El cliente " + c.getId() + " ha entrado en la cola " + id + ". Tamaño de la cola " + cola.size());
	}

	@Override
	public void run() {
		Cliente c = null;
		boolean isEmpty;
		
		while (true) {
			
			synchronized (this) {
				isEmpty = !cola.isEmpty();
			}
			
			if (isEmpty) {
				c = cola.get();
				System.out.println(
						"El usuario " + id + " va a PAGAR en la caja " + id + ". Tamaño de la cola " + cola.size());
				try {
					sleep(c.getTiempoPago());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
