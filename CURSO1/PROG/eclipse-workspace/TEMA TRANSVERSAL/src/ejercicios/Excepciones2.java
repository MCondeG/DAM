package ejercicios;

import java.util.Scanner;

public class Excepciones2 {

	public static void main(String[] args) throws IntervaloException {
		// TODO Apéndice de método generado automáticamente

		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce entero entre 0 y 9");
		int n = sc.nextInt();
		
		rango(n);
		
		sc.close();
	}
	
	public static void rango (int n) throws IntervaloException {
		
		IntervaloException e = new IntervaloException();
		
		if (n < 0) {
			System.err.println("ERROR. Número < 0");
			throw e;
		}
		else if (n > 9) {
			System.err.println("ERROR. Numero > 9");
			throw e;
		}
		else System.out.println("Número correcto");
	}
}