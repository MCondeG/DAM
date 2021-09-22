package ejemplos;

import java.util.Scanner;

public class Equis {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce la altura de la X");
		int h = sc.nextInt();
		System.out.println();
		
		for (int i = 1;i <= h;i++) {
			for (int j = 1;j <= h;j++) {
				if ((i == j) || (i+j-1 == h)) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
