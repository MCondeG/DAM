package ejemplos;

import java.util.Scanner;

public class String2 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner sc = new Scanner(System.in);
		
		int cont = 0;
		int pos = -1;
		
		String vocal = "AEIOU";
		
		System.out.println("introduce una cadena de caracteres");
		
		String cad = sc.nextLine().toUpperCase();
		
		for (int i = 0;i < vocal.length();i++) {
			do {
				pos = cad.indexOf(vocal.charAt(i), pos+1);
				if (pos != -1) cont++;
			} while (pos != -1);
		}
		
		System.out.println();
		System.out.println("La cadena tiene "+cont+" vocales");
		
		sc.close();
	}
}