package hilos3;


public class Main {

	public static void main(String[] args) {
				
		
		Hilo1 h1 = new Hilo1();
		Hilo2 h2 = new Hilo2(h1);
		Hilo3 h3 = new Hilo3();
		

		h1.setPriority(Thread.MAX_PRIORITY);
		h2.setPriority(Thread.MIN_PRIORITY);
		h3.setDaemon(true);
		
		h1.start();
		h2.start();
		h3.start();
	}
}