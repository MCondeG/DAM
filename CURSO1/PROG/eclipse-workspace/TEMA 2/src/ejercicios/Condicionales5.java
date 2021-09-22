package ejercicios;

import java.util.Scanner;

public class Condicionales5 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner s = new Scanner(System.in);

		System.out.println("Introduce el día del mes");
		int n = s.nextInt();
		
		if (n>0 && n<32) {
			switch (n%7) {
			case 1:
				System.out.println("Lunes");
				break;
			case 2:
				System.out.println("Martes");
				break;
			case 3:
				System.out.println("Miércoles");
				break;
			case 4:
				System.out.println("Jueves");
				break;
			case 5:
				System.out.println("Viernes");
				break;
			case 6:
				System.out.println("Sábado");
				break;
			case 0:
				System.out.println("Domingo");
				break;
			default:
				break;
			}	
		}
		else {
			System.out.println("ERROR");
		}
	}
}