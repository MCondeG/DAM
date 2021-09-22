package ejercicios;

import java.util.Scanner;

public class Bucles25 {
	private static int NumCifras (long n) {
		
		int cifras = 1;
		
		while (n >= 10) {
			n = n/10;
			cifras++;
		}
		return cifras;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un numero entero");
		long n = Math.abs(sc.nextLong());
		
		long suma = 0;
		long d = 10;
		long dif = n-((n/d)*d);
		int cifras = NumCifras(n);
		
		for (int i = 1;i <= cifras;i++) {
			if (dif%2 == 0) {
				System.out.print(dif+" ");
				suma = suma + dif;
			}
			n = n/d;
			dif = n-((n/d)*d);
		}
		System.out.println();
		System.out.println("La suma de los dígitos pares es "+suma);
	}
}