package ejercicios;

import java.util.Scanner;

public class Random2 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner sc = new Scanner(System.in);
		
		int n = (int)(Math.random()*101);
		int x;
		int i = 5;
		
		System.out.println("Intenta adivinar un número entero entre 0 y 100");
		
		do {
			x = sc.nextInt();
			i--;
			if (x == n) {
				System.out.println("Felicidades!! has adivinado el número!");
			}
			else if (i == 0) {
				System.out.println("Perdiste. El número que buscabas era "+n);
			}
			else {
				System.out.println("Inténtalo de nuevo. Te quedan "+i+" intentos");
				System.out.print("Pista: el número que buscas es ");
				if (n>x) {
					System.out.println("mayor que el introducido");
				}
				else {
					System.out.println("menor que el introducido");
				}
			}
		} while (i>0);
	}
}