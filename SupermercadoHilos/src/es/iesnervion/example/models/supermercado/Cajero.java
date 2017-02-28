package es.iesnervion.example.models.supermercado;

import es.iesnervion.example.models.Cliente;

/**
 * Clase que exteiende de <b>Thread</b>, esta clase gestionará todos los {@link Cliente} que decidan pasar por su Caja,
 * los añadira a la {@link Cola} correspondiente y cuando sea su turno les atendera. <br>
 * En el momento que {@link Cola} este vacia se pondra a la espera, una vez haya un cliente será despertado por
 * {@link Cola} y lo atenderá, simulará el tiempo de pago y una vez eso terminará.
 * @author adripol94
 *
 */
class Cajero extends Thread {
	
	/**
	 * Cola que tendrá el cajero
	 */
	private Cola cola;
	
	/**
	 * Indetificador del cajero
	 */
	private int id;
	
	/**
	 * Constructor, Se le asignará una {@link Cola} y se identificará al Cajero.
	 * @param cola Cola que se le ha asignado
	 * @param id Indetificador del Cajero
	 */
	protected Cajero(Cola cola, int id) {
		this.cola = cola;
		cola.asignarCajero(this);
		this.id = id;
	}

	/**
	 * Metodo sincrono, añade un cliente a la cola, simplementente llama a {@link Cola#addClientToTail(Cliente)} para añadirlo.
	 * @param c Cliente que se va a introducir en la cola.
	 */
	protected synchronized void addToTail(Cliente c) {
		try {
			cola.addClientToTail(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo Runnable, con un bucle infinito en su interior, este metodo preguntará por {@link Cola#vacia()} para saber
	 * si esta vacia en ese caso utilizaremos {@link #wait()} para esperar, una vez sea avisado de que hay un cliente y 
	 * {@link Cola} le notifique, llamará a {@link Cola#atenderClient()} para obtener un {@link Cliente} de la cola,
	 * simulara el tiempo de pago al final.
	 */
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
					//notify();
					try {
						Thread.sleep(c.getTiempoPago());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Cliente " + c.getId() + " ha pagado en cola " + id + "!");
				}
			}
		}
		
	}

}
