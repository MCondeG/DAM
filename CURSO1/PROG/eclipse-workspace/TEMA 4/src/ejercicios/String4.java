package ejercicios;

import java.util.Scanner;

public class String4 {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce una cadena de caracteres");
		String cad = sc.nextLine();
		
		System.out.println();
		
		cad = cad.replace("a","o").replace("e", "o").replace("i", "o").replace("u", "o");
		
		System.out.println(cad);
	}

}
