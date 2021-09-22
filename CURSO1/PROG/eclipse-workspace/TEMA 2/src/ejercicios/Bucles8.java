package ejercicios;

import java.util.Scanner;

public class Bucles8 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un numero entero");
		
		long n = sc.nextLong();
		int contador = 1;
		
		while (Math.abs(n) >= 10) {
			n = n/10;
			contador++;
		}
		
		System.out.println("El número tiene "+contador+" cifras");

	}

}
