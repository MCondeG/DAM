package ejercicios;

import java.util.Scanner;

public class Bucles17 {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
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
			System.out.print(c);
			while (i3 <= (2*i1-3)) {
				if (i1 < h) {
					System.out.print(" ");
					i3++;	
				}
				else {
					System.out.print(c);
					i3++;
				}
			}
			if (i1 > 1) {
				System.out.print(c);
			}
			System.out.println();
			i1++;
			i2 = i1;
			i3 = 1;
		}
	}
}