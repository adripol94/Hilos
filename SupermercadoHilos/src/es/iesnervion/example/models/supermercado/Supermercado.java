package es.iesnervion.example.models.supermercado;

import es.iesnervion.example.models.Cliente;

/**
 * Clase publica, será la cara de todo el entramado de atras, esta clase inicializara todos cajeros y los ejecutara
 * dipone de un metodo para meter el cliente en cola.
 * 
 * @see Cajero
 * @see Cola
 * 
 * @author adripol94
 *
 */
public class Supermercado {
	
	/**
	 * Cajeros que obtendra dicho supermercado
	 */
	private Cajero[] cajeros;
	
	/**
	 * Inicializa y ejecuta un numero de {@link Cajero} que se le ha proporcionado por parametro.
	 * @param numCajas Numero de cajeros que tendra dicho supermercado
	 */
	public Supermercado(int numCajas) {
		cajeros = new Cajero[numCajas];
		
		for (int i=0; i < numCajas; i++) {
			cajeros[i] = new Cajero(new Cola(i), i);
			cajeros[i].start();
		}
	}
	
	/**
	 * Asignará un {@link Cliente} al Cajero, como antes de pasar por dicho cajero dene estar en cola,
	 * realmente este metodo lo metera en la cola. Gracias a {@link Cliente#getNCajero()} sabremos a que
	 * {@link Cajero} va a ir el {@link Cliente}.
	 * @see Cola
	 * @see Cajero
	 * @param c Cliente que se introducira
	 */
	public void moverseCola(Cliente c) {
		cajeros[c.getNCajero()].addToTail(c);
	}
	
	/**
	 * Devuelve el numero de Cajeros que existen en el supermercado
	 * @return Int referente al numero de cajeros
	 */
	public int numCajeros() {
		return cajeros.length;
	}
}
