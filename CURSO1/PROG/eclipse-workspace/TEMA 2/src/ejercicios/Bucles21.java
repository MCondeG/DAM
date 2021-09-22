package ejercicios;

import java.util.Scanner;

public class Bucles21 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un entero");
		int n = sc.nextInt();
		int cont = 0;
		
		for (int i = 3;i <= n;i+=3) {
			System.out.print(i+" ");
			cont++;
		}
		System.out.println();
		System.out.println("Hay "+cont+" múltiplos de 3");
	}

}
