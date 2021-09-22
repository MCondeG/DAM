package ejercicios;

import java.util.Scanner;

public class Array2 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		int[] num = new int[10];
		
		Scanner sc = new Scanner(System.in);

		for (int i = 0;i < num.length;i++) {
			num[i] = sc.nextInt();
		}
		System.out.println();
		
		for (int i = num.length-1;i >= 0;i--) {
			System.out.print(num[i]+" ");
		}
		
		sc.close();
	}
	
}
