package hilos3;


public class Main {

	public static void main(String[] args) {
		
		Hilo[] tareas = new Hilo[3];
		
		
		for (int i = 0; i < tareas.length; i++) {
			
			tareas[i] = new Hilo(i);
			
			switch (i) {
				case 0:
					tareas[i].setPriority(Thread.MAX_PRIORITY);
					break;
				case 1:
					tareas[i].setPriority(Thread.MIN_PRIORITY);
					break;
				case 2:
					tareas[i].setDaemon(true);
					break;
				default:
					break;
			}
			
			tareas[i].start();
		}	
	}
}