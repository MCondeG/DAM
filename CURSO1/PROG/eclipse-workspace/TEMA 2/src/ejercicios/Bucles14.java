package ejercicios;

import java.util.Scanner;

public class Bucles14 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un entero positivo");
		int n = sc.nextInt();
		long suma = 0;
		
		if (n >= 0) {
			for (int i = n+1;i <= (n+100);i++) {
				suma = suma + i;
			}
		}
		else {
			System.out.println("ERROR");
		}
		
		System.out.println("Suma realizada con bucles");
		System.out.println(suma);
		
		System.out.println("Suma realizada con el método de Gauss");
		suma = (((n+1)+(n+100))*100)/2;
		System.out.println(suma);

	}

}
