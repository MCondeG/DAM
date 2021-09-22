package ejercicios;

import java.util.Scanner;

public class Condicionales15 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce la hora y minutos");
		int h = sc.nextInt();
		int m = sc.nextInt();
		
		int s = ((24*3600)-((h*3600)+(m*60)));
		
		System.out.println("Quedan "+s+" segundos para la medianoche");
		

	}

}
