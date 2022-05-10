package hilos1;


public class Main {

	public static void main(String[] args) {
		
		Hilo[] tareas = {new Hilo(0), new Hilo(1), new Hilo(2)};
		
		tareas[0].start();
		tareas[1].start();
		tareas[2].start();
	}
}