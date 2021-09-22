package ejercicios;

import java.util.Scanner;

public class Bucles23 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un entero");
		int n = sc.nextInt();
		
		System.out.println("Introduce un divisor");
		int d = sc.nextInt();
		
		if (n>0 && d>0) {
			for (int i = n;i>=1;i--) {
				if (i%d != 0) {
					System.out.print(i+" ");
				}
			}
		}
		else {
			System.out.println("ERROR");
		}

		sc.close();
	}
}