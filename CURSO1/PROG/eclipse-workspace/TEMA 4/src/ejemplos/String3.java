package ejemplos;

import java.util.Scanner;

public class String3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int cont = 0;
		
		System.out.println("introduce una cadena de caracteres");
		String cad = sc.nextLine().toUpperCase();
		
		System.out.println("Introduce una palabra para buscar en la cadena");
		String pal = sc.nextLine().toUpperCase();
		
		int pos = -(pal.length());

		do {
			pos = cad.indexOf(pal, pos+pal.length());
			if (pos != -1) cont++;
		} while (pos != -1);
		
		System.out.println();
		System.out.println("La palabra \""+pal+"\" aparece "+cont+" veces en el texto");
		
		sc.close();
	}
}