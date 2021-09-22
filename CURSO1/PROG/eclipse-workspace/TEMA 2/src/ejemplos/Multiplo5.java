package ejemplos;

import java.util.Scanner;

public class Multiplo5 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Introduce un número entero");
		int n = s.nextInt();
		
		if (n%5 == 0) {
			System.out.println("El número "+n+" es multiplo de 5");
		}
		else {
			System.out.println("El número "+n+" no es multiplo de 5");

		}

	}

}