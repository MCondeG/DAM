package ejercicios;

import java.util.Scanner;

public class String1 {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
		Scanner sc = new Scanner(System.in);

		
		System.out.println("Introduce nombre");
		String nom = sc.nextLine();
		
		System.out.println("\nIntroduce apellido");
		String apell = sc.nextLine();
		
		System.out.println();
		
		System.out.println("El nombre es: "+nom+". Longitud = "+nom.length());
		System.out.println("El apellido es: "+apell+". Longitud = "+apell.length());
	}

}
