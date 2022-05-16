package hilos7;

public class Main {

	public static void main(String[] args) {
		
		Directorio directorio = new Directorio("src");

		Thread t = new Thread(new Hilo(directorio));
		
		t.start();
	}
}