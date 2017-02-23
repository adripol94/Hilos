package es.iesnervion.example.ui;

import es.iesnervion.example.models.Coche;
import es.iesnervion.example.models.Parking;

public class Main {
	public static void main(String[] args) {
		Parking p = new Parking();
		
		for (int i=0; i < 100; i++) {
			new Coche(i, p).start();
		}
	}
}
