package es.iesnervion.example.ui;

import es.iesnervion.example.models.Coche;
import es.iesnervion.example.models.parking.Parking;

public class Main {
	public static void main(String[] args) {
		Parking p = new Parking(3, 2, 2);
		
		for (int i=0; i < 10; i++) {
			new Coche(i, p).start();
		}
	}
}
