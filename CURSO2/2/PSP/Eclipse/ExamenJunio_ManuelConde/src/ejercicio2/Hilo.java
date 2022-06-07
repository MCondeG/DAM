package ejercicio2;

import java.io.IOException;

import utilidades.Ficheros;


public class Hilo implements Runnable {
	
	private int numHilo;
	private int[] numeros;
	
	
	public Hilo(int numHilo) {
		this.numHilo = numHilo;
		this.numeros = randomizar();
	}
	
	
	public synchronized int[] randomizar() {
		
		int min, max;
		int[] num = new int[10];
		
		min = this.numHilo * 10;
		max = (this.numHilo * 20) - ((this.numHilo - 1) * 10);
		
		
		for(int i = 0; i < 10; i++) {
			num[i] = (int)(Math.random() * (max - min) + 1);
		}
		
		return num;
	}
	
	@Override
	public void run() {
		
		String ruta = "src/ejercicio2";	
		String nombre = "aleatorios" + Integer.toString(this.numHilo) + ".txt";
		
		Ficheros f = new Ficheros(ruta, nombre);
		
		for (int i = 0; i < 10; i++) {
			try {
				f.escribirNum(this.numeros[i]);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}