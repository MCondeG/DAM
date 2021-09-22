package ejercicios;

import java.util.Scanner;

public class Array7 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		int[] num = new int[8];
		
		Scanner sc = new Scanner(System.in);

		
		System.out.println("Introduce 10 enteros");
		
		for (int i = 0;i < num.length;i++) {
			num[i] = sc.nextInt();
		}
		
		for (int i = 0;i < num.length;i++) {
			System.out.println();
			System.out.print(num[i]);
			if (num[i]%2 == 0) {
				System.out.print("     par");
			}
			else {
				System.out.print("     impar");
			}
		}
		
		sc.close();
	}
}