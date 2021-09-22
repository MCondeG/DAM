package ejercicios;

import java.util.Scanner;

public class Condicionales8 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner s = new Scanner(System.in);

		System.out.println("Introduce un número entero");
		int n = s.nextInt();
		
		if (!(n<1 || n>10)) {
			if (n%2 == 0) {
				System.out.println("Par");
			}
			else {
				System.out.println("Impar");
			}
		}
		else {
			System.out.println("ERROR");
		}
		
		
	}

}
