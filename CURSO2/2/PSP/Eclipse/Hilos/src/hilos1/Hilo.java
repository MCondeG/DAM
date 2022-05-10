package hilos1;


public class Hilo extends Thread {
	
	private int posicion;

	
	public Hilo() {
		super();
	}
	
	public Hilo(int posicion) {
		super();
		this.posicion = posicion;
	}


	@Override
	public void run() {
		
		System.out.println("Dentro del hilo: HILO" + Integer.toString(this.posicion) + ", Prioridad: " + Integer.toString(this.getPriority()) + ", ID: " + Long.toString(this.getId()));
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Se sale del hilo: HILO" + Integer.toString(this.posicion));
	}
}