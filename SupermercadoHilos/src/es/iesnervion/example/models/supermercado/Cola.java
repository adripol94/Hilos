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
	private Cajero cajero;
	private int id;

	protected Cola(int id) {
		this.id = id;
		tail = new LinkedList<Cliente>();
	}
	
	protected void asignarCajero(Cajero cajero) {
		this.cajero = cajero;
	}

	protected void addClientToTail(Cliente c) throws Exception {
		if (cajero == null)
			throw new Exception("No se le ha asigando la cola a un CAJERO");
		
		System.out.println("Cliente " + c.getId() + " se va ha añadir a la cola " + id);
		addToTail(c);
		cajero.notifyAll();
	}

	protected Cliente atenderClient() {
		Cliente c;
//		if (tail.isEmpty()) {
//			try {
//				System.out.println("----------------------------------------------------> Cola " + id + " vacia!!!!!!");
//				wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} else {
			c = tail.getLast();
			System.out.println(
					"Cliente " + c.getId() + " va a cobrar en la caja " + id + " GENTE EN COLA = " + tail.size());
			remove();
			return c;
//		}
	}

	private void remove() {
		tail.removeLast();
	}

	private void addToTail(Cliente c) {
		tail.addFirst(c);
		System.out.println("Cliente " + c.getId() + " se ha añadido a la cola " + id);
	}
	
	protected boolean vacia() {
		return tail.isEmpty();
	}

}
