package hilos4;

public class Mensaje implements Runnable {
	
	private static int cont = 0;
	private String cadena;
	
	
	public Mensaje() {
		this.cadena = "Mensaje número ";
	}
	
	
	@Override
	public synchronized String toString() {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String numHilo;
		
		Mensaje.cont++;
		
		if (Mensaje.cont%2 == 0) numHilo = "HILO 2";
		else numHilo = "HILO 1";
		
		return (this.cadena + Mensaje.cont + " - " + numHilo);		
	}

	
	@Override
	public void run() {
		
		while(Mensaje.cont < 9) {	
			System.out.println(this.toString());
		}
	}
}