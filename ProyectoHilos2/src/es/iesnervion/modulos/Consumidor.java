package es.iesnervion.modulos;

import java.util.List;

public class Consumidor extends Thread {
	private ConnectionThread connection;
	private List<Character> c;
	
	public Consumidor(ConnectionThread connection, List<Character> c) {
		this.connection = connection;
		this.c = c;
	}

	@Override
	public void run() {
		Character car;
		for (int i = 0; i < c.size(); i++) {
			car = connection.get();
			System.out.println("El consumidor get:: " + car);
		}
	}

}
