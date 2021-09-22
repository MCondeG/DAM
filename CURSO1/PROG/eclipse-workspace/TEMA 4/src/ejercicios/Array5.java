package ejercicios;

import java.util.Scanner;

public class Array5 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner sc = new Scanner(System.in);

		
		int[] num1 = new int[15];
		
		for (int i = 0;i<num1.length;i++) {
			num1[i] = sc.nextInt();
		}
		
		int a = num1[14];
		
		System.out.println();
		System.out.println("Array rotada:");
		
		for (int i = num1.length-1;i>=0;i--) {
			if (i == 0) {
				num1[i] = a;
			}
			else {
				num1[i] = num1[i-1];
			}
		}
		for (int i = 0;i<num1.length;i++) {
			System.out.print(num1[i]+" ");
		}
	}
}