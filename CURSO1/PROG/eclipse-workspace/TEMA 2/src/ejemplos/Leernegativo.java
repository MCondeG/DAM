//leer numeros enteros hasta encontrar un negativo

package ejemplos;

import java.util.Scanner;

public class Leernegativo {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
		Scanner sc = new Scanner(System.in);
		
		int n = 1;
		
		while (!(n<0)) {
			System.out.println("Introduce un entero");
			n = sc.nextInt();
		}
		
		System.out.println("N�mero negativo encontrado");

	}

}
