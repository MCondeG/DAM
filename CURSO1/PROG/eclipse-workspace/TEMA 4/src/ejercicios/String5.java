package ejercicios;

import java.util.Scanner;

public class String5 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce una cadena de caracteres");
		String cad = sc.nextLine();
		
		System.out.println();
		
		String cad1 = cad.substring(0, (cad.length()/2));
		
		System.out.println(cad1);
	}

}
