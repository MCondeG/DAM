package ejercicios;

import java.util.Scanner;

public class Condicionales4 {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente

		Scanner s = new Scanner(System.in);
		
		System.out.println("Introduce 1 n�mero");
		int a = s.nextInt();
		
		System.out.println("Introduce otro n�mero");
		int b = s.nextInt();
		
		
		if (a != 0) {
			System.out.println("La soluci�n de la ecuaci�n ax+b=0 es x = "+((double)-b/(double)a));
		}
		else {
			if (b != 0) {
				System.out.println("La ecuaci�n ax+b=0 no tiene solucion");
			}
			else {
				System.out.println("La ecuaci�n ax+b=0 tiene infinitas soluciones (indeterminada)");
			}
		}
	}
}
