package ejercicios;

import java.util.Scanner;

public class Condicionales12 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner s = new Scanner(System.in);

		System.out.println("Nº de horas trabajadas");
		int hora = s.nextInt();
		
		if (hora <= 40) {
			System.out.println("El salario es "+(hora*12));
		}
		else {
			System.out.println("El salario es "+((40*12)+((hora-40)*16)));
		}

	}

}
