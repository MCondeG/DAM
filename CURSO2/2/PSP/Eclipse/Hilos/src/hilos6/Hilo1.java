package hilos6;

public class Hilo1 extends Thread {
	
	private Vector v;
	
	
	public Hilo1() {
		super();
	}
	
	public Hilo1(Vector v) {
		super();
		this.v = v;
	}
	
	
	@Override
	public void run() {
		
		long startTime = System.nanoTime();
		
		long n = this.v.mayor();
		
		long tiempoEjecucion = System.nanoTime() - startTime;
		
		System.out.println("Encontrado número " + n + " mediante el uso de 1 hilo.\tTiempo de ejecución = " + tiempoEjecucion + " ns");
	}
}