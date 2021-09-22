//Leer un conjunto de numeros y calcular su media, el numero de datos se lee por teclado

package ejemplos;

import java.util.Scanner;

public class Media {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el numero total de datos");
		int n = sc.nextInt();
		double media = 0.0;
		double m;
		int contador = 1;
		
		while (contador<=n) {
			System.out.println("Introduce dato");
			m = sc.nextDouble();
			media = media + m;
			contador++;
		}

		System.out.println("La media de los datos es: "+(media/n));
	}

}
