package ejercicios;

import java.util.Scanner;

public class String3 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner sc = new Scanner(System.in);
		
		int letra = 0;
		int digito = 0;
		int espacio = 0;
		
		System.out.println("Introduce una cadena de caracteres");
		String cad = sc.nextLine();
		
		System.out.println();
		
		for (int i = 0;i < cad.length();i++) {
			if (Character.isLetter(cad.charAt(i))) {
				letra++;
			}
			if (Character.isDigit(cad.charAt(i))) {
				digito++;
			}
			if (Character.isSpaceChar(cad.charAt(i))) {
				espacio++;
			}
		}
		
		System.out.println("La cadena tiene: "+letra+" letras, "+digito+" dígitos y "+espacio+" espacios");
		
	}

}
