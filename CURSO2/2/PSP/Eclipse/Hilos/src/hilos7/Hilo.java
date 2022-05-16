package hilos7;

import java.io.FileNotFoundException;

public class Hilo implements Runnable {
	
	private Directorio directorio;
	private String palabra;
	
	
	public Hilo(String palabra, Directorio directorio) {
		this.palabra = palabra;
		this.directorio = directorio;
	}
	
	
	@Override
	public void run() {
		
		try {
			this.directorio.scan(this.palabra, this.directorio.getRuta());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("La palabra '" + this.palabra + "' se encuentra en un total de " + this.directorio.getCont() + " archivos");
		}
	}
}