package ejemplos;

import java.util.Scanner;

public class NaveEspacial {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el lado del cuadrado");
		int l = sc.nextInt();
		System.out.println();
		
		String s = " ";
		
		for (int i = 1;i < (l-2);i++) {
			s = s + " ";
		}
		
		for (int i = 1;i <= l;i++) {
			for (int j = 1;j <= l;j++) {
				if ((i == 1) || (i == l)) {
					System.out.print("*");

				}
				else {
					System.out.print("*"+s+"*");
				}
			}
			System.out.println();
		}
	}
}