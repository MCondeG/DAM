package ejercicios.ej02;

public class Hilos2Thread1 extends Thread {

	private Hilos2Thread2 h;
	
	
	public Hilos2Thread1() {
		super();
	}
	
	public Hilos2Thread1(Hilos2Thread2 h) {
		
		super();
		this.h = h;
	}
	
	
	@Override
	public void run() {
		
		try {
			h.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Hola Mundo! Soy el hilo número 1");
		}
	}
}