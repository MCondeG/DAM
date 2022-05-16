package hilos6;


public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		long mayor = 0;
		long tiempoEjecucion = 0;
		int size = 50000000;
		
		Vector v = new Vector(size);
		Vector m1 = v.dividirVector(1);
		Vector m2 = v.dividirVector(2);
		
		Hilo1 h = new Hilo1(v);
		Hilo2 h1 = new Hilo2(m1, h);
		Hilo2 h2 = new Hilo2(m2, h);
	
		
		h.start();
		h1.start();
		h2.start();
		
		h1.join();
		h2.join();
		
		
		mayor = Math.max(h1.getMayor(), h2.getMayor());
		tiempoEjecucion = Math.max(h1.getTiempoEjecucion(), h2.getTiempoEjecucion());
		
		System.out.println("Encontrado número " + mayor + " mediante el uso de 2 hilos.\tTiempo de ejecución = " + tiempoEjecucion + " ns");
	}
}