package hilos4;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		Mensaje m = new Mensaje();
		
		Thread t1 = new Thread(m);
		Thread t2 = new Thread(m);
		
		
		t1.start();
		t2.start();
	}
}