package ejercicio1;

import java.io.IOException;

import utilidades.Ficheros;

public class Main {

	public static void main(String[] args) {
		
		Ficheros f = new Ficheros("src/ejercicio1", "lectura.txt");
		
		Hilo h1 = new Hilo(1, f);
		Hilo h2 = new Hilo(2, h1, f);
		
		h1.start();
		h2.start();
	}
}