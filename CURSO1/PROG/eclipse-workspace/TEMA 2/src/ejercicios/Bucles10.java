package ejercicios;

import java.util.Scanner;

public class Bucles10 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce cuantos terminos de la sucesión de Fibonacci quieres ver");
		int n = sc.nextInt();
		System.out.println();

		long n1 = 0;
		long n2 = 1;
		long f = 0;
		int contador = 1;
		
		if (n >= 0) {
			while (contador <= n) {
				if (contador < 3) {
					System.out.print(f+" ");
					f = 1;
					contador++;
				}
				else {
					f = n1 + n2;
					System.out.print(f+" ");
					n1 = n2;
					n2 = f;
					contador++;
				}
			}	
		}
		else {
			System.out.println("ERROR");
		}
	}
}