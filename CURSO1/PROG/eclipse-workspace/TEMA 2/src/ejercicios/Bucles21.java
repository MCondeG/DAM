package ejercicios;

import java.util.Scanner;

public class Bucles21 {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un entero");
		int n = sc.nextInt();
		int cont = 0;
		
		for (int i = 3;i <= n;i+=3) {
			System.out.print(i+" ");
			cont++;
		}
		System.out.println();
		System.out.println("Hay "+cont+" m�ltiplos de 3");
	}

}
