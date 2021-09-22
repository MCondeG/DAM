package ejemplos;

import java.util.Scanner;

public class MayorMenor {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		
		if (n>m) {
			System.out.print("El número "+n+" es mayor que "+m);
		}
		else if (n == m) {
			System.out.print("Los 2 numeros son iguales");
		}
		else {
			System.out.print("El número "+n+" es menor que "+m);
		}

	}

}