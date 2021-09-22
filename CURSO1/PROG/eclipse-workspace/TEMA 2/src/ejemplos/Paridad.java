package ejemplos;

import java.util.Scanner;

public class Paridad {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Introduce un número entero");
		int n = s.nextInt();
		
		if (n%2 == 0) {
			System.out.println("El número "+n+" es par");
		}
		else {
			System.out.println("El número "+n+" es impar");

		}

	}

}