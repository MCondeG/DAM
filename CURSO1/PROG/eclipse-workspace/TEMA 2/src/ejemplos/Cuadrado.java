package ejemplos;

import java.util.Scanner;

public class Cuadrado {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el lado del cuadrado");
		int l = sc.nextInt();
		System.out.println();
		
		for (int i = 1;i <= l;i++) {
			for (int j = 1;j <= l;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}