package ejercicios;

import java.util.Scanner;

public class Condicionales1 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner s = new Scanner(System.in);

		System.out.println("Introduce una hora");
		
		int h = s.nextInt();
		
		if (h>5 && h<13) {
			System.out.println("Buenos días");
		}
		else if (h>12 && h<21) {
			System.out.println("Buenas tardes");
		}
		else if ((h>20 && h<25) || (h>=0 && h<6)) {
			System.out.println("Buenas noches");
		}
		else {
			System.out.println("ERROR");
		}
		
	}

}