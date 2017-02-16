package es.iesnervion.apol.ui;

import es.iesnervion.apol.ent.ClaseThread;
import es.iesnervion.apol.ent.Lector;
import es.iesnervion.apol.ent.Productor;

public class Main {
	
	public static void main(String[] args) {
		Character[] c = {'h', 'o', 'l', 'a'};
		ClaseThread clase = new ClaseThread();
		Productor pro = new Productor(c, clase);
		Lector lec = new Lector(c.length, clase);
		
		pro.start();
		lec.start();
	}
}
