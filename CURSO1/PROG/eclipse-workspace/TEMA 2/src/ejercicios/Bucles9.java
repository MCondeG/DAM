package ejercicios;

import java.util.Scanner;

public class Bucles9 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner sc = new Scanner(System.in);

		double x = 0.0;
		double media = 0.0;
		int contador = 0;
		
		x = sc.nextDouble();
		
		while (x >= 0.0) {	
			media = media + x;
			contador++;
			x = sc.nextDouble();
		}
		
		System.out.println("La media es "+(media/(contador)));
	}

}