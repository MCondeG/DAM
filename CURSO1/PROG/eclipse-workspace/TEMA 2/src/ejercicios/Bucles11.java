package ejercicios;

import java.util.Scanner;

public class Bucles11 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner sc = new Scanner(System.in);
		
		int pos = 0;
		int neg = 0;
		
		System.out.println("Introduce 10 números enteros");
		
		for (int i = 0; i < 10;i++) {
			int n = sc.nextInt();
			if (n>=0) {
				pos++;
			}
			else {
				neg++;
			}
		}
		System.out.println("Hay "+pos+" números positivos "+neg+" números negativos");

	}

}
