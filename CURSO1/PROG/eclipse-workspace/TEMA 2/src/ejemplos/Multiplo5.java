package ejemplos;

import java.util.Scanner;

public class Multiplo5 {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Introduce un n�mero entero");
		int n = s.nextInt();
		
		if (n%5 == 0) {
			System.out.println("El n�mero "+n+" es multiplo de 5");
		}
		else {
			System.out.println("El n�mero "+n+" no es multiplo de 5");

		}

	}

}