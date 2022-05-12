package hilos3;

import java.io.IOException;

public class Hilo1 extends Thread {
	
	private Ficheros f;
	
	public Hilo1() {
		super();
		this.f = new Ficheros("fichero1.txt");
	}
	
	
	@Override
	public void run() {
		try {
			f.escribirNum();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("HILO1: finalizada escritura");
		}
	}
}