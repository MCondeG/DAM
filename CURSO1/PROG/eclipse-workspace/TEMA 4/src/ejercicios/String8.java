package ejercicios;

import java.util.Scanner;

public class String8 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		
		Scanner sc = new Scanner(System.in);
		
		int cont = 0;
		
		System.out.println("introduce una cadena de caracteres");
		String c1 = sc.nextLine();
		
		System.out.println("Introduce una subcadena para buscar en la cadena");
		String c2 = sc.nextLine();
		
		int pos = -(c2.length());

		StringBuffer cad = new StringBuffer(c1);
		
		do {
			pos = c1.indexOf(c2, pos+c2.length());
			if (pos != -1) {
				cont++;
				cad.replace(pos, pos+c2.length(), c2.toUpperCase());
			}
		} while (pos != -1);
		
		System.out.println();
		System.out.println("La subcadena \""+c2+"\" aparece "+cont+" veces en el texto");
		
		System.out.println();
		
		System.out.println(cad);
		
		sc.close();
	}

}
