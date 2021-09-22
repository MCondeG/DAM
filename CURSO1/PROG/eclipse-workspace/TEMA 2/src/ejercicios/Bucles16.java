package ejercicios;

import java.util.Scanner;

public class Bucles16 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un caracter");
		
		String cad = sc.nextLine();
		char c = cad.charAt(0);
		
		System.out.println("Introduce la altura de la piramide");
		int h = sc.nextInt();
		int i1 = 1;
		int i2 = 1;
		int i3 = 1;
		
		System.out.println();
		
		while (i1 <= h) {
			while (i2 <= h-1) {
				System.out.print(" ");
				i2++;
			}
			while (i3 <= (2*i1-1)) {
				System.out.print(c);
				i3++;
			}
			System.out.println();
			i1++;
			i2 = i1;
			i3 = 1;
		}
	}
}