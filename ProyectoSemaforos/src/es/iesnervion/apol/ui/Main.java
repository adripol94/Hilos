package es.iesnervion.apol.ui;

import es.iesnervion.apol.ent.Monitor;
import es.iesnervion.apol.ent.Lector;
import es.iesnervion.apol.ent.Productor;

public class Main {
	
	public static void main(String[] args) {
		Character[] c = {'h', 'o', 'l', 'a'};
		Monitor clase = new Monitor(c.length);
		Productor pro = new Productor(c, clase);
		Lector lec = new Lector(c.length, clase);
		
		
		lec.start();
		pro.start();
	}
}
