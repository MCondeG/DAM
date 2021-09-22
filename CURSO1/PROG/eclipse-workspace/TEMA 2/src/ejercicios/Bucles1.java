package ejercicios;

import java.util.Scanner;

public class Bucles1 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner sc = new Scanner(System.in);

		int n;
		
		do {
			System.out.println("Introduce un numero entero");
			n = sc.nextInt();
		}while (n%2 == 0);

		System.out.println("Numero impar encontrado");
	}

}
