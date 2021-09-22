package ejemplos;

import java.util.Scanner;

public class CuadradoHueco {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el lado del cuadrado");
		int l = sc.nextInt();
		System.out.println();
		
		String s = " ";
		
		for (int i = 1;i < (l-2);i++) {
			s = s + "  ";
		}
		
		for (int i = 1;i <= l;i++) {
			if ((i == 1) || (i == l)) {
				for (int j = 1;j <= l;j++) {
					System.out.print("* ");
				}
			}
			else {
				System.out.print("* "+s+" *");
			}
			System.out.println();
		}
	}
}