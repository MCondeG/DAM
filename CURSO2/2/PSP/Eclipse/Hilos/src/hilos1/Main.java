package hilos1;


public class Main {

	public static void main(String[] args) {
		
		int prioridad;
		Hilo[] tareas = new Hilo[3];
		
		
		for (int i = 0; i < tareas.length; i++) {
			
			prioridad = (int) (Math.random() * 10 + 1);

			tareas[i] = new Hilo(i);
			tareas[i].setPriority(prioridad);
			tareas[i].start();
		}
	}
}