package ejercicios;

import java.util.Scanner;

public class String6 {
	
	public static void nopor (String c) {
		
		c = c.replace("es", "no por");
		
		System.out.println(c);
	}
	
	public static void asterisco (String c) {
		
		c = c.replaceAll("\\d+", "*");		// \\d+ remplaza todas las cadenas de digitos hasta encontrar un caracter distinto
		
		System.out.println(c);
		
	}

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner sc = new Scanner(System.in);
			
		System.out.println("Introduce una cadena");
		String c = sc.nextLine();
		
		nopor(c);
		asterisco(c);
	}
}
