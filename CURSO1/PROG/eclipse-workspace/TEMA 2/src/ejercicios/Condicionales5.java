package ejercicios;

import java.util.Scanner;

public class Condicionales5 {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente

		Scanner s = new Scanner(System.in);

		System.out.println("Introduce el d�a del mes");
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
				System.out.println("Mi�rcoles");
				break;
			case 4:
				System.out.println("Jueves");
				break;
			case 5:
				System.out.println("Viernes");
				break;
			case 6:
				System.out.println("S�bado");
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