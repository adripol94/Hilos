package es.iesnervion.example.models.supermercado;

import es.iesnervion.example.models.Cliente;

public class Supermercado {
	private Cajero[] cajeros;
	
	public Supermercado(int numCajas) {
		cajeros = new Cajero[numCajas];
		
		for (int i=0; i < numCajas; i++) {
			cajeros[i] = new Cajero(new Cola(i), i);
			cajeros[i].start();
		}
	}
	
	public void moverseCola(Cliente c) {
		cajeros[c.getNCajero()].addToTail(c);
	}
	
	public int numCajeros() {
		return cajeros.length;
	}
}
