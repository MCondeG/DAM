package ejercicios;

import java.util.Scanner;

public class Condicionales16 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un caracter");
		
		String cad = sc.nextLine();
		char c = cad.charAt(0);
		
		System.out.println("Pintar pirámide. Introduce una opción");
		System.out.println("1- Apuntando hacia arriba");
		System.out.println("2- Apuntando hacia abajo");
		System.out.println("3- Apuntando hacia la izquierda");
		System.out.println("4- Apuntando hacia la derecha");
		
		int n = sc.nextInt();
		System.out.println();
		System.out.println();
		System.out.println();
		
		switch (n) {
		case 1:
			System.out.println("    "+c);
			System.out.println("   "+c+c+c);
			System.out.println("  "+c+c+c+c+c);
			System.out.println(" "+c+c+c+c+c+c+c);
			System.out.println(""+c+c+c+c+c+c+c+c+c);
			break;
		case 2:
			System.out.println(""+c+c+c+c+c+c+c+c+c);
			System.out.println(" "+c+c+c+c+c+c+c);
			System.out.println("  "+c+c+c+c+c);
			System.out.println("   "+c+c+c);
			System.out.println("    "+c);
			break;
		case 3:
			System.out.println("       "+c);
			System.out.println("     "+c+c+c);
			System.out.println("   "+c+c+c+c+c);
			System.out.println(" "+c+c+c+c+c+c+c);
			System.out.println("   "+c+c+c+c+c);
			System.out.println("     "+c+c+c);
			System.out.println("       "+c);
			break;
		case 4:
			System.out.println(" "+c);
			System.out.println(" "+c+c+c);
			System.out.println(" "+c+c+c+c+c);
			System.out.println(" "+c+c+c+c+c+c+c);
			System.out.println(" "+c+c+c+c+c);
			System.out.println(" "+c+c+c);
			System.out.println(" "+c);
			break;
		default:
			System.out.println("ERROR");
			break;
		}
	}	
}