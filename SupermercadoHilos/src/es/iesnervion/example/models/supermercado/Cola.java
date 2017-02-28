package es.iesnervion.example.models.supermercado;

import java.util.LinkedList;
import java.util.List;

import es.iesnervion.example.models.Cliente;

/**
 * Cola protegida, es el metodo encargado de gestionar a cola de cada
 * {@link Cajero}.
 * 
 * @author adripol94
 *
 */
class Cola {
	
	/**
	 * Cola de clientes
	 */
	private LinkedList<Cliente> tail;
	
	/**
	 * Identificador de la cola, normalmente será el mismo que el del cajero
	 */
	private int id;

	/**
	 * Inicializa la cola de clientes y identifica a dicha cola
	 * @param id
	 */
	protected Cola(int id) {
		this.id = id;
		tail = new LinkedList<Cliente>();
	}

	/**
	 * Metodo sincrono, añade un cliente a la cola, una vez añadido notifica a toda la clase.
	 * @param c
	 */
	protected synchronized void addClientToTail(Cliente c) {
		System.out.println("Cliente " + c.getId() + " se va ha añadir a la cola " + id);
		addToTail(c);
		notifyAll();
	}

	/**
	 * Atiende a un cliente, este metodo es el mas importante, tiene un bucle infito nunca parará, si la cola esta vacia
	 * se para a la espera de que {@link #addClientToTail(Cliente)} notifique, de no ser asi recoge un cliente de la cola
	 * y lo eminila con {@link #remove()}. Aqui dentro simula el tiempo de pago.
	 */
	protected synchronized void atenderClient() {
		Cliente c;
		while (true) {
			if (tail.isEmpty()) {
				try {
					System.out.println("----------------------------------------------------> Cola " + id + " vacia!!!!!!");
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				c = tail.getLast();
				System.out.println("Cliente " + c.getId() + " va a cobrar en la caja " + id + " GENTE EN COLA = " + tail.size());
				remove();
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

	/**
	 * Elimina el ultimo cliente de la cola.
	 */
	private void remove() {
		tail.removeLast();
	}

	/**
	 * Añade a la lista en la primera prosicion
	 * @param c Cliente
	 */
	private void addToTail(Cliente c) {
		tail.addFirst(c);
		System.out.println("Cliente " + c.getId() + " se ha añadido a la cola " + id);
	}

}
