package hilos2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int n1, n2;
		Scanner sc = new Scanner(System.in);
		Hilo tarea;
		
		System.out.println("Introduce un primer número natural");
		n1 = sc.nextInt();
		System.out.println("Introduce un segundo número natural");
		n2 = sc.nextInt();
				
		tarea = new Hilo(n1,n2);	
		if (n1 > n2) tarea.setDaemon(true);
		
		System.out.println();
		tarea.start();
		
		if (tarea.isDaemon()) {
			while(true) {}
		}
		
		sc.close();
	}
}