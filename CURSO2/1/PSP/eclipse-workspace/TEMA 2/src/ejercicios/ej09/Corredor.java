package ejercicios.ej09;

public class Corredor extends Thread {
	private Relevo rel;
	private int num;

	public Corredor(Relevo rel, int numCorredor) {
		this.rel = rel;
		this.num = numCorredor;
	}

	@Override
	public void run() {
		try {
			cogerRelevo();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		darRelevo();
	}

	public synchronized void cogerRelevo() throws InterruptedException {
		//para poder controlar el hilo que debe correr se incluye la posición al intentar coger el relevo
		rel.coger(num);
		System.out.println("Soy el thread " + num + ", corriendo");
	}

	public synchronized void darRelevo() {
		System.out.println("Terminé, pasando el relevo");
		rel.dar();
	}
}