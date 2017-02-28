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
		cola.asignarCajero(this);
		this.id = id;
	}

	protected synchronized void addToTail(Cliente c) {
		try {
			cola.addClientToTail(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		synchronized (this) {
			Cliente c;
			
			while (true) {
				if (cola.vacia()) {
					try {
						System.out.println("----------------------------------------------------> Cola " + id + " vacia!!!!!!");
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					c = cola.atenderClient();
					notify();
					try {
						Thread.sleep(c.getTiempoPago());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Cliente " + c.getId() + " ha pagado en cola " + id + "!");
				}
			}
		}
		
	}

}
