package ejercicios;

import java.util.Scanner;

public class Condicionales6 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner s = new Scanner(System.in);
		
		System.out.println("¿Cual es el primer día del mes?");
		String dia = s.nextLine();

		System.out.println("Introduce el número del día del mes");
		int n = s.nextInt();
		
		if (n>0 && n<32) {
			switch (dia) {
				case "martes" :
					n++;
					break;
				case "miercoles" :
					n += 2;
					break;
				case "jueves" :
					n += 3;
					break;
				case "viernes" :
					n += 4;
					break;
				case "sabado" :
					n += 5;
					break;
				case "domingo" :
					n += 6;
					break;
				default:
					break;
			}
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