package ejemplos;

import java.util.Scanner;

public class MayorMenor {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		
		if (n>m) {
			System.out.print("El n�mero "+n+" es mayor que "+m);
		}
		else if (n == m) {
			System.out.print("Los 2 numeros son iguales");
		}
		else {
			System.out.print("El n�mero "+n+" es menor que "+m);
		}

	}

}