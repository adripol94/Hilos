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
	private LinkedList<Cliente> tail;
	private int id;

	protected Cola(int id) {
		this.id = id;
		tail = new LinkedList<Cliente>();
	}

	protected synchronized void addClientToTail(Cliente c) {
		System.out.println("Cliente " + c.getId() + " se va ha añadir a la cola " + id);
		addToTail(c);
		notifyAll();
	}

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

	private void remove() {
		tail.removeLast();
	}

	private void addToTail(Cliente c) {
		tail.addFirst(c);
		System.out.println("Cliente " + c.getId() + " se ha añadido a la cola " + id);
	}

}
