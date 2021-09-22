package ejercicios.ej02;

public class Orden {

	public static void main(String[] args) {
		
		Hilos2Thread2 h2 = new Hilos2Thread2();
		Hilos2Thread1 h1 = new Hilos2Thread1(h2);
		
		h1.setPriority(Thread.MIN_PRIORITY);
		h2.setPriority(Thread.MAX_PRIORITY);
		
		h1.start();
		h2.start();
	}
}