package es.iesnervion.example.models.supermercado;

import java.util.Arrays;
import java.util.LinkedList;

import es.iesnervion.example.models.Cliente;

/**
 * Cola protegida, es el metodo encargado de gestionar a cola de cada {@link Cajero}.
 * @author adripol94
 *
 */
class Cola {
	
	/**
	 * Cola de los clientes que estan en caja
	 */
	private LinkedList<Cliente> registro;
	
	/**
	 * Indetificador de la cola, referente al cajero.
	 */
	private int id;
	
	/**
	 * Inicializacion del identificador de la Cola.
	 * @param id Indeficiador de {@link Cajero}.
	 */
	protected Cola(int id) {
		this.id = id;
		registro = new LinkedList<>();
	}
	
	/**
	 * Introducira el cliente en la ultima posicion.
	 * @param c
	 */
	protected void add(Cliente c) {
		registro.addFirst(c);
	}
	
	/**
	 * Devuelve el ultimo cliente de la lista y lo elimina.
	 * @return
	 */
	protected Cliente get() {
		Cliente c = registro.getLast();
		System.out.println("Se ha cogido el cliente " + id + " de la cola");
		registro.removeLast();
		
		return c;
	}
	
	protected boolean isEmpty() {
		return registro.isEmpty();
	}
	
	protected int size() {
		return registro.size();
	}
}
