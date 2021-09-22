package ejercicios;

import java.util.Scanner;

public class Array8 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

	Scanner sc = new Scanner(System.in);
			
		int[] num1 = new int[20];
		int[] num2 = new int[20];
		
		int pos = 0;

		for (int i = 0;i < num1.length;i++) {
			num1[i] = (int)(Math.random()*101);
			num2[i] = num1[i];
		}
		
		for (int i = 0;i < num1.length;i++) {
			System.out.print(num1[i]+" ");
		}
		
		System.out.println();
		System.out.println();
		
		for (int i = 0; i < num2.length;i++) {
			if (num2[i]%2 == 0) {
				num1[pos] = num2[i];
				pos++;
			}
		}
		
		for (int i = 0; i < num2.length;i++) {
			if (num2[i]%2 == 1) {
				num1[pos] = num2[i];
				pos++;
			}
		}
		
		for (int i = 0;i < num1.length;i++) {
			System.out.print(num1[i]+" ");
		}
		
		sc.close();
	}
}