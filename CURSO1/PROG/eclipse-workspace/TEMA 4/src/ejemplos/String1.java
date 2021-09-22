package ejemplos;

import java.util.Scanner;

public class String1 {
	
	public static boolean validar (String dni) {
		
		char[] c = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
		
		boolean valido = false;
		char letra = Character.toUpperCase(dni.charAt(8));
		int dninum = Integer.valueOf(dni.substring(0, 8)).intValue();
		int resto = dninum%23;
		
		if (letra == c[resto]){
			valido = true;
		}
		
		return (valido);
	}

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner sc = new Scanner(System.in);
		
		String dni = new String();
		boolean valido;
		
		System.out.println("Introduce un DNI");
		dni = sc.nextLine();
		System.out.println();
		
		valido = validar(dni);
		
		if (valido) {
			System.out.println("DNI valido");
		}
		else {
			System.err.println("DNI erroneo");
		}
		sc.close();
	}
}
