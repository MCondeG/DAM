package ejercicios;

import java.util.Scanner;

public class Bucles24 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce la altura de la L");
		int h = sc.nextInt();
		
		int l = (h/2)+1;
		int i = 1;
		
		System.out.println();
		
		while (i<h) {
			System.out.println("*");
			i++;
		}
		i = 1;
		while (i<=l) {
			System.out.print("*");
			i++;
		}
		
	
	}

}
