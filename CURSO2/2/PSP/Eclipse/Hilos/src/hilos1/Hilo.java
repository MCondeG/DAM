package hilos1;


public class Hilo extends Thread {
	
	private int posicion;
	private int prioridad;
	private Thread tarea;

	
	public Hilo() {
		super();
	}
	
	public Hilo(int posicion) {
		super();
		this.posicion = posicion;
		this.prioridad = (int) (Math.random() * 10 + 1);
		this.tarea = new Thread();
		this.tarea.setPriority(prioridad);
	}
	
	
	
	public Thread getTarea() {
		return tarea;
	}


	public void setTarea(Thread tarea) {
		this.tarea = tarea;
	}


	@Override
	public void run() {
		
		System.out.println("Dentro del hilo: HILO" + Integer.toString(this.posicion) + ", Prioridad: " + Integer.toString(this.tarea.getPriority()) + ", ID: " + Long.toString(this.tarea.getId()));
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Se sale del hilo: HILO" + Integer.toString(this.posicion));
		
		this.stop();
	}
}