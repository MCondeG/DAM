package ejercicios;

import java.util.Scanner;

public class String2 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente


		Scanner sc = new Scanner(System.in);

		
		System.out.println("Introduce nombre");
		String nom = sc.nextLine();
		
		System.out.println("\nIntroduce primer apellido");
		String apell1 = sc.nextLine();
		
		System.out.println("\nIntroduce segundo apellido");
		String apell2 = sc.nextLine();
		
		String cad = nom.concat(apell1).concat(apell2); 
		
		System.out.println();
		
		System.out.println(cad);
	}

}
