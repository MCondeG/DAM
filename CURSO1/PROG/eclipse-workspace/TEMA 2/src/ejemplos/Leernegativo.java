//leer numeros enteros hasta encontrar un negativo

package ejemplos;

import java.util.Scanner;

public class Leernegativo {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner sc = new Scanner(System.in);
		
		int n = 1;
		
		while (!(n<0)) {
			System.out.println("Introduce un entero");
			n = sc.nextInt();
		}
		
		System.out.println("Número negativo encontrado");

	}

}
