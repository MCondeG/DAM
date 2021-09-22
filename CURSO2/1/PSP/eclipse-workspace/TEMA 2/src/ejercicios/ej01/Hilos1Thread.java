package ejercicios.ej01;

public class Hilos1Thread extends Thread {

	private int N;
	
	private static long n1 = 1;
	private static long n2 = 1;
	private static long f = 1;
	
	
	public Hilos1Thread() {
		super();
	}
	
	public Hilos1Thread(int N) {
		
		super();
		this.N = N;
	}
	
	
	@Override
	public void run() {
		
		System.out.println();		

		if (this.N >= 0) {
			for (int i = 0; i < this.N; i++) {
				
				if (i < 2) {
					System.out.print(f+" ");
					f = 1;
				}
				else {
					f = n1 + n2;
					System.out.print(f+" ");
					n1 = n2;
					n2 = f;
				}
				
			}	
		}
		else System.err.println("ERROR. Introduce entero positivo");
		
	}
}