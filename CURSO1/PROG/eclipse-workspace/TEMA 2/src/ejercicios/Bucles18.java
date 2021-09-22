package ejercicios;

import java.util.Scanner;

public class Bucles18 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner sc = new Scanner(System.in);

		int n = 0;
		int npar = 0;
		double media = 0.0;
		int contador = 0;

		System.out.println("Introduce enteros positivos, negativo para finalizar");
		
		n = sc.nextInt();
		
		while (n >= 0) {	
			if (n%2 == 1) {
				media = media + n;
				contador++;
			}
			else if (n > npar) {
				npar = n;
			}
			n = sc.nextInt();
		}
		
		System.out.println("La media de los impares es "+(media/(contador)));
		System.out.println("El mayor de los pares es "+npar);
	}
}