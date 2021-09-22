package ejercicios;

import java.util.Scanner;

public class String7 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce una cadena");
		String c = sc.nextLine();
		
		StringBuffer cad = new StringBuffer(c);
		
		cad.reverse();
		
		System.out.println(cad);
	}

}
