package ejercicios;

import java.util.Scanner;

public class Bucles15 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce 2 enteros distintos");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		
		if (n1 != n2) {
			if (n1 > n2) {
				int aux = n1;
				n1 = n2;
				n2 = aux;
			}
			for (int i = n1;i <= n2;i += 7) {
				System.out.print(i+" ");
			}
		}
		else {
			System.out.println("ERROR");
		}
	}
}