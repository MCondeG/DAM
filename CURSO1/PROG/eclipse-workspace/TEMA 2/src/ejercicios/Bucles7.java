package ejercicios;

import java.util.Scanner;

public class Bucles7 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un entero entre 1 y 9");
		
		int n = sc.nextInt();
		int contador = 0;
		
		if (n<1 || n>9) {
			System.out.println("ERROR");
		}
		else {
			while (contador<=10) {
				System.out.println(""+n+" * "+contador+" = "+(n*contador));
				contador++;
			}
		}

	}

}
