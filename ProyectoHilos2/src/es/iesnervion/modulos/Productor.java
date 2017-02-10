package es.iesnervion.modulos;

import java.util.List;

public class Productor extends Thread{
	private ConnectionThread connection;
	private List<Character> c;
	
	

	public Productor(ConnectionThread con, List<Character> c) {
		this.connection = con;
		this.c = c;
	}



	@Override
	public void run() {
		for (int i = 0; i < c.size(); i++) {
			connection.put(c.get(i));
			System.out.println("Productor insert:: " + c.get(i));
			
			try {
				sleep((int)(Math.random() * 100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	

}
