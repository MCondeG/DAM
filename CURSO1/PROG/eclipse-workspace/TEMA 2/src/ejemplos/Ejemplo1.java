package ejemplos;

import java.util.Scanner;

public class Ejemplo1 {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		if (n>0) {
			System.out.print("El n�mero "+n+" es positivo");
		}
		else if (n==0) {
			System.out.print("El n�mero es 0");
		}
		else {
			System.out.print("El n�mero "+n+" es negativo");
		}

	}

}