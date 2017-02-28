package es.iesnervion.example.models.supermercado;

import java.util.LinkedList;

import es.iesnervion.example.models.Cliente;

/**
 * Esta clase estara protegida y visible solo para el paquete es.iesnervion.example.models.supermercado. <br>
 * Gestionará todos los clientes que quieran pagar en el cajero que se le haya asignado por parametros. Mediante el metodo de
 * <b>Cola/Tail</b> recogeremos los {@link Cliente} y los introduciremos, se pondra de acuerdo con {@link #cajero}
 * y se le notificará por si este esta en el espera a introducir un {@link Cliente}.
 * @author adripol94
 *
 */
class Cola {
	
	/**
	 * Cola enla que se guardaran los clientes
	 */
	private LinkedList<Cliente> tail;
	
	/**
	 * Cada cola necesita que se asigne un cajero.
	 */
	private Cajero cajero;
	
	/**
	 * Identificador de la cola, normalmente el identificador coincidira con el cajero.
	 */
	private int id;

	/**
	 * Constructor: Inicializa a {@link #tail} y identifica a la cola.
	 * @param id
	 */
	protected Cola(int id) {
		this.id = id;
		tail = new LinkedList<Cliente>();
	}

	/**
	 * Asigna a la cola un cajero, ESTO es IMPORTANTISIMO, si la cola no tiene un cajero asignado este no podra funcionar.
	 * @param cajero
	 */
	protected void asignarCajero(Cajero cajero) {
		this.cajero = cajero;
	}

	/**
	 * Añade un cliente a la cola, en caso de no tener un cajero asignado no funionará, utiliza {@link #addToTail(Cliente)} y
	 * notifica a {@link Cajero} por si queda en espera
	 * @param c Cliente que esperará en la cola
	 * @throws Exception En caso de no tener un cajero asignado.
	 */
	protected void addClientToTail(Cliente c) throws Exception {
		if (cajero == null)
			throw new Exception("No se le ha asigando la cola a un CAJERO");

		System.out.println("Cliente " + c.getId() + " se va ha añadir a la cola " + id);
		addToTail(c);
		cajero.notifyAll();
	}

	/**
	 * Atiende al cliente, este metodo devolvera un cliente y hara uso de {@link #remove()} para eliminarlo.
	 * @return Cliente que va a ser atendido por {@link Cajero}
	 */
	protected Cliente atenderClient() {
		Cliente c;
		c = tail.getLast();
		System.out
				.println("Cliente " + c.getId() + " va a cobrar en la caja " + id + " GENTE EN COLA = " + tail.size());
		remove();
		return c;
	}

	/**
	 * Metodo que elimina el ultimo cliente de {@link #tail}
	 */
	private void remove() {
		tail.removeLast();
	}

	/**
	 * Añade a la cola {@link Cliente}.
	 * @param c Cliente
	 */
	private void addToTail(Cliente c) {
		tail.addFirst(c);
		System.out.println("Cliente " + c.getId() + " se ha añadido a la cola " + id);
	}

	/**
	 * Indica si la cola esta vacia
	 * @return <code>true</code> en caso de estarlo, <code>false</code> en caso de no estarlo.
	 */
	protected boolean vacia() {
		return tail.isEmpty();
	}

}
