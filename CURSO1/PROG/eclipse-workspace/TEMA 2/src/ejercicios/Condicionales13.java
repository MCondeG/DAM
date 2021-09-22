package ejercicios;

import java.util.Scanner;

public class Condicionales13 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce la hora, minutos y segundos");
		int h = sc.nextInt();
		int m = sc.nextInt();
		int s = sc.nextInt();

		if (h < 0 || h > 23 || m < 0 || m > 59 || s < 0 || s > 59) {
			System.out.println("ERROR");
		} else {
			if (s == 59) {
				if (m == 59) {
					if (h == 23) {
						System.out.println("La hora dentro de 1 segundo ser� 00:00");
					} else {
						System.out.println("La hora dentro de 1 segundo ser� " + (h + 1) + " horas");
					}
				} else {
					System.out.println("La hora dentro de 1 segundo ser� " + h + " horas y " + (m + 1) + " minutos");
				}
			} else {
				System.out.println("La hora dentro de 1 segundo ser� " + h + " horas y " + m + " minutos y " + (s + 1)
						+ " segundos");
			}
		}
	}
}