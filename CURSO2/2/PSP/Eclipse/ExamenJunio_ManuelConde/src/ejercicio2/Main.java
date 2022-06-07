package ejercicio2;

public class Main {

	
	
	public static void main(String[] args) {

		Hilo[] hilos = new Hilo[3];
		Thread[] tareas = new Thread[3];
		
		for (int i = 0; i < 3; i++) {
			hilos[i] = new Hilo(i+1);
			tareas[i] = new Thread(hilos[i]);
			tareas[i].start();
		}
	}
}