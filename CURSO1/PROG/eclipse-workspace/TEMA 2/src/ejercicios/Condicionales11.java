package ejercicios;

import java.util.Scanner;

public class Condicionales11 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner s = new Scanner(System.in);
		
		System.out.println("Introduce los coeficientes de la ecuación de segundo grado: ax2 + bx +c = 0");
		double a = s.nextDouble();
		double b = s.nextDouble();
		double c = s.nextDouble();
		
		double x1 = (-b+(Math.sqrt(b*b-4*a*c)))/(2*a);
		double x2 = (-b-(Math.sqrt(b*b-4*a*c)))/(2*a);
		
		double real = (-b)/2*a;
		double compleja = Math.sqrt(Math.abs((b*b-4*a*c)/(2*a)));
		
		
		if ((b*b-4*a*c)>=0) {
			System.out.println("Las soluciones reales de la ecuación son:");
			System.out.println("x1 = "+x1);
			System.out.println("x2 = "+x2);
		}
		else {		
			System.out.println("Las soluciones complejas de la ecuación son:");
			System.out.println("x1 = "+real+" + "+compleja+"i");
			System.out.println("x2 = "+real+" - "+compleja+"i");
		}
	}
}