package es.iesnervion.example.models.supermercado;

import es.iesnervion.example.models.Cliente;

/**
 * Metodo publico referente al supermercado, este metodo es el encargado de gestionar todo desde fuera,
 * obtendra el numero de cajeros y creara una cola por cajero. 
 * @author adripol94
 *
 */
public class Supermercado {
	
	/**
	 * El supermercado tiene X numeros de cajeros
	 */
	private Cajero[] cajeros;
	
	/**
	 * Inicializa los cajeros propuestos por parametro.
	 * @param numCajeros Numero de cajeros que dispone el supermercado.
	 */
	public Supermercado(int numCajeros) {
		cajeros = new Cajero[numCajeros];
		
		for (int i=0; i < numCajeros; i++) {
			cajeros[i] = new Cajero(new Cola(i), i);
			cajeros[i].start();
		}
	}
	
	/**
	 * Para entrar en el cajero debera entrar por aqui.
	 * @param c Cliente que entra en el cajero.
	 * @param id Identificador del cajero.
	 */
	public synchronized void entrarEnCaja(Cliente c, int id) {
		System.out.println("El usuario " + c.getId() + " va ha entrar en el cajero " + id);
		cajeros[id].addToTail(c);
		
	}
	
	public int numCajeros() {
		return cajeros.length;
	}
}
