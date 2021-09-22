package ejercicios;

import java.util.Scanner;

public class Bucles12 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce una base y un exponente");
		
		int b = sc.nextInt();
		int e = sc.nextInt();
		
		//Usando la clase Math
		
		System.out.println(""+b+"^"+e+" = "+Math.pow(b, e));
		System.out.println("Calculado usando la clase Math");
		System.out.println("");
		
		//Usando while
		
		int contador = 1;
		double pot = 1.0;
		
		if (e>=0) {
			while (contador<=e) {
				pot = pot*b;
				contador++;
			}
		}
		else {
			while (contador<=(-e)) {
				pot = pot/b;
				contador++;
			}
		}
		
		System.out.println(""+b+"^"+e+" = "+pot);
		System.out.println("Calculado usando bucle while");
	}
}