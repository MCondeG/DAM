package ejercicios;

import java.util.Scanner;

public class Condicionales10 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Introduce 3 numeros enteros distintos");
		
		int n = s.nextInt();
		int m = s.nextInt();
		int o = s.nextInt();
			
		if (n>m && m>o) {
			System.out.print("El número "+n+" es mayor que "+m+" y que "+o);
		}
		else if (o>n && n>m) {
			System.out.print("El número "+o+" es mayor que "+n+" y que "+m);
		}
		else if (m>o && o>n) {
			System.out.print("El número "+m+" es mayor que "+o+" y que "+n);
		}
		else if (n>o && o>m) {
			System.out.print("El número "+n+" es mayor que "+o+" y que "+m);
		}
		else if (o>m && m>n) {
			System.out.print("El número "+o+" es mayor que "+m+" y que "+n);
		}
		else if (m>n && n>o) {
			System.out.print("El número "+m+" es mayor que "+n+" y que "+o);
		}
		else {
			System.out.print("Existen al menos 2 numeros iguales");
		}
	}
}