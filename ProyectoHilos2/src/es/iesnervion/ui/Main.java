/**
 * 
 */
package es.iesnervion.ui;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import es.iesnervion.modulos.ConnectionThread;
import es.iesnervion.modulos.Consumidor;
import es.iesnervion.modulos.Productor;

/**
 * Productor Consumidor
 * @author apol
 *
 */
public class Main {

	public static void main(String[] args) {
		List<Character> c = Arrays.asList(new Character[] {'d', 'w', 'a', 'g', 'j', 'y', 'w'});
		ConnectionThread con = new ConnectionThread();
		Productor pro = new Productor(con, c);
		Consumidor cons = new Consumidor(con, c);
		Thread conHilo = new Thread(cons);
		
		pro.start();
		conHilo.start();
		
	}

}
