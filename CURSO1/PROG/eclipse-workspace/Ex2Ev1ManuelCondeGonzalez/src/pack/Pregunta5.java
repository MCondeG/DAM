package pack;

import java.util.Scanner;

public class Pregunta5 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Introduce una cadena");
		String c = sc.nextLine();
		
		StringBuffer cad = new StringBuffer(c);
		
		cad.reverse();
		
		String c2 = cad.toString();
		
		if (c.equalsIgnoreCase(c2)) System.out.println("\nLa cadena introducida es un palíndromo");
		else System.out.println("\nLa cadena introducida no se lee igual al revés");
		
		sc.close();
	}

}
