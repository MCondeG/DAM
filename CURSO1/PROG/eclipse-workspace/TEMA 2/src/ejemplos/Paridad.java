package ejemplos;

import java.util.Scanner;

public class Paridad {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Introduce un n�mero entero");
		int n = s.nextInt();
		
		if (n%2 == 0) {
			System.out.println("El n�mero "+n+" es par");
		}
		else {
			System.out.println("El n�mero "+n+" es impar");

		}

	}

}