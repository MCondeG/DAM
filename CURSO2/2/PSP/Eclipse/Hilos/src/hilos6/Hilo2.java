package hilos6;

public class Hilo2 extends Thread {
	
	private long mayor;
	private long tiempoEjecucion;
	private Vector v;
	private Hilo1 h;
	
	
	public Hilo2() {
		super();
	}
	
	public Hilo2(Vector v, Hilo1 h) {
		super();
		this.mayor = 0;
		this.tiempoEjecucion = 0;
		this.v = v;
		this.h = h;
	}
	
	
	public long getMayor() {
		return mayor;
	}

	public void setMayor(long mayor) {
		this.mayor = mayor;
	}

	public long getTiempoEjecucion() {
		return tiempoEjecucion;
	}

	public void setTiempoEjecucion(long tiempoEjecucion) {
		this.tiempoEjecucion = tiempoEjecucion;
	}

	@Override
	public void run() {
		
		try {
			h.join();
			long startTime = System.nanoTime();			
			this.mayor = this.v.mayor();		
			this.tiempoEjecucion = System.nanoTime() - startTime;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}