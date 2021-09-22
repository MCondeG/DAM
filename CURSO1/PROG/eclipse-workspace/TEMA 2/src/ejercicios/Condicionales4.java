package ejercicios;

import java.util.Scanner;

public class Condicionales4 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner s = new Scanner(System.in);
		
		System.out.println("Introduce 1 número");
		int a = s.nextInt();
		
		System.out.println("Introduce otro número");
		int b = s.nextInt();
		
		
		if (a != 0) {
			System.out.println("La solución de la ecuación ax+b=0 es x = "+((double)-b/(double)a));
		}
		else {
			if (b != 0) {
				System.out.println("La ecuación ax+b=0 no tiene solucion");
			}
			else {
				System.out.println("La ecuación ax+b=0 tiene infinitas soluciones (indeterminada)");
			}
		}
	}
}
