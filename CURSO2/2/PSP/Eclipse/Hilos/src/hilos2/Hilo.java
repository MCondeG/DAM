package hilos2;

public class Hilo extends Thread {
	
	
	private int n1, n2;
	
	
	public Hilo(int n1, int n2) {
		super();
		this.n1 = n1;
		this.n2 = n2;
	}
	
	@Override
	public void run() {
		
		if (this.isDaemon()) System.out.println("Soy un demonio!");
		else System.out.println("Soy un hilo!");
		
		
		while(n1 != n2) {
			
			System.out.println(n1);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			n1++;
		}
		
		if (!(this.isDaemon())) System.out.println(n1 + "\nTarea finalizada");
	}
}