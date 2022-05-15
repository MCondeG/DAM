package hilos3;

import java.io.IOException;

public class Hilo3 extends Thread {
	
private Ficheros f;
	
	public Hilo3() {
		super();
		this.f = new Ficheros("fichero3.txt");
	}
	
	
	@Override
	public void run() {
		try {
			f.escribirNum();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("HILO3: finalizada escritura");
		}
	}
}