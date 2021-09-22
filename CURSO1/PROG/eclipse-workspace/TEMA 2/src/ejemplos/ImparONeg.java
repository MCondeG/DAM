//leer numeros hasta encontrar un numero impar o negativo

package ejemplos;

import java.util.Scanner;

public class ImparONeg {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner sc = new Scanner(System.in);

		int n = 2;
		
		while (n>=0 && n%2 == 0) {
			System.out.println("Introduce numeros enteros");
			n = sc.nextInt();
		}
		System.out.println("Numero negativo o impar encontrado");
	}

}
