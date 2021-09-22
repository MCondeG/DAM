package ejercicios;

import java.util.Scanner;

public class Bucles26 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce la altura de la U");
		int h = sc.nextInt();
		
		int l = (h/2)+1;
		int i = 1;
		
		String esp = " ";
		
		for (int e = 1;e < (l);e++) {
			esp = esp+" ";
		}
		
		System.out.println();
		
		while (i<h) {
			System.out.println("*"+esp+"*");
			i++;
		}
		i = 1;
		System.out.print(" ");
		while (i<=l) {
			System.out.print("*");
			i++;
		}
		System.out.print(" ");
	}
}