package ejercicios;

import java.util.Scanner;

final class Bucles19 {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente

		Scanner sc = new Scanner(System.in);

		System.out.println("�Cu�ntos primos quieres ver?");
		int n = sc.nextInt();
		
		int contp = 0;
		int a = 2;
		int i = a-1;
		boolean p = true;
		
		while (contp < n) {
			while ((i > 1) && (p == true)) {
				if (a%i == 0) {
					p = false;
				}
				i--;
			}
			if (p) {
				System.out.print(a+" ");
				contp++;
			}
			a++;
			i = a-1;
			p = true;
		}
	}
}