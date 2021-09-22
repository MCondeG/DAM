package ejercicios.ej02;

public class Hilos2Thread2 extends Thread {

	public Hilos2Thread2() {
		super();
	}
	
	
	@Override
	public void run() {
		
		System.out.println("Hola Mundo! Soy el hilo número 2");
	}
}