package hilos3;

import java.io.IOException;

public class Hilo2 extends Thread {


	private Hilo1 h;
	private Ficheros f;
	
	
	public Hilo2(Hilo1 h) {
		super();
		this.h = h;
		this.f = new Ficheros("fichero2.txt");
	}
	
	
	@Override
	public void run() {
		
		try {
			h.join();
			f.escribirNum();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("HILO2: finalizada escritura");
		}
	}
}