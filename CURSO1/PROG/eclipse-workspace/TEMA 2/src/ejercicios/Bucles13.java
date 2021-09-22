package ejercicios;

import java.util.Scanner;

final class Bucles13 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un entero positivo");
		int n = sc.nextInt();
		
		int i = n-1;
		boolean p = true;
		
		while ((i > 1) && (p == true)) {
			if (n%i == 0) {
				p = false;
			}
			i--;
		}
		if (p) {
			System.out.println("El número "+n+" es primo");
		}
		else {
			System.out.println("El número "+n+" no es primo");
		}
	}
}