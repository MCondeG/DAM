package hilos7;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		String palabra = "java";
		String palabra1 = "hilo";
		String palabra2 = "directorio";
		
		Directorio directorio = new Directorio("src");
		Directorio directorio1 = new Directorio("src");
		Directorio directorio2 = new Directorio("src");

		Thread t = new Thread(new Hilo(palabra, directorio));
		Thread t1 = new Thread(new Hilo(palabra1, directorio1));
		Thread t2 = new Thread(new Hilo(palabra2, directorio2));
		
		
		System.out.println("1 HILO:");
		t.start();
		t.join();
		
		System.out.println("\n2 HILOS:");
		t1.start();
		t2.start();
	}
}