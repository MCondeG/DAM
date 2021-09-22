package ejemplos;

import java.util.Scanner;

public class CompararCadenas {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		/* compare.To compara 2 cadenas de caracteres y devuelve 0 si son iguales
		 * funciona restando el valor ASCII de cada caracter, por lo que devuelve un valor numerico
		 */
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Introduce un nombre");
		String nom1 = s.nextLine();
		
		System.out.println("Introduce otro nombre");
		String nom2 = s.nextLine();
		
		if (nom1.compareTo(nom2) == 0) {
			System.out.println("Los nombres son iguales");
		}
		else {
			System.out.println("Los nombres son distintos");
		}

	}

}