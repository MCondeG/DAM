package ejercicio1;

import java.io.IOException;

import utilidades.Ficheros;


public class Hilo extends Thread {
	
	private Ficheros f;
	private int numHilo, inicio, ultima;
	private Hilo h = null;
	
	
	public Hilo(int numHilo, Ficheros f) {
		super();
		this.numHilo = numHilo;
		this.f = f;
	}
	
	public Hilo(int numHilo, Hilo h, Ficheros f) {
		super();
		this.numHilo = numHilo;
		this.f = f;
		this.h = h;
	}
	
	
	@Override
	public void run() {
		
		try {
			
			if (numHilo != 1) {
				h.join();		//espera la finalizacion del hilo
				f.imprimirLinea(3, 4);
			}
			else f.imprimirLinea(1, 2);
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}