package ejercicios;

import java.util.Scanner;

public class String4 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce una cadena de caracteres");
		String cad = sc.nextLine();
		
		System.out.println();
		
		cad = cad.replace("a","o").replace("e", "o").replace("i", "o").replace("u", "o");
		
		System.out.println(cad);
	}

}
