package ejercicios;

import java.util.Scanner;

public class Array4 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		int[] num = new int[10];
		
		Scanner sc = new Scanner(System.in);

		
		System.out.println("Introduce 10 enteros");
		
		for (int i = 0;i < num.length;i++) {
			num[i] = sc.nextInt();
		}
		
		int min = num[0];
		int max = num[0];
		
		int posmin = num[0];
		int posmax = num[0];
		
		for (int i = 0;i < num.length;i++) {
			if (num[i]<min) {
				min = num[i];
				posmin = i;
			}
			if (num[i]>max) {
				max = num[i];
				posmax = i;
			}
		}
		
		for (int i = 0;i < num.length;i++) {
			System.out.println();
			System.out.print(num[i]);
			if (i == posmin) {
				System.out.print("     mínimo");
			}
			if (i == posmax) {
				System.out.print("     máximo");
			}
		}
		
		sc.close();
	}
}