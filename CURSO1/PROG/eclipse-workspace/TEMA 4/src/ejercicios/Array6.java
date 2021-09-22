package ejercicios;

import java.util.Scanner;

public class Array6 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner sc = new Scanner(System.in);
		
		
		int[] num = new int[100];

		for (int i = 0;i < num.length;i++) {
			num[i] = (int)(Math.random()*21);
			System.out.print(num[i]+" ");
		}
		
		System.out.println();
		System.out.println();
		System.out.println("introduce 2 números (el primero entre 0 y 20");
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		
		System.out.println();
		for (int i = 0;i < num.length;i++) {
			if (num[i] == n1) {
				num[i] = n2;
				System.out.print("\""+num[i]+"\" ");
			}
			else {
				System.out.print(num[i]+" ");
			}
		}
	}
}