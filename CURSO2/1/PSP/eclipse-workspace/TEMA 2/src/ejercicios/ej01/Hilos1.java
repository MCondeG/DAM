package ejercicios.ej01;

import java.util.Scanner;

public class Hilos1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce cuantos terminos de la sucesión de Fibonacci quieres ver");
		int N = sc.nextInt();
		
		Hilos1Thread h = new Hilos1Thread(N);
		h.start();
		
		sc.close();
	}
}