package ejercicios;

import java.util.Scanner;

public class Condicionales9 {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Introduce 3 numeros enteros distintos");
		
		int n = s.nextInt();
		int m = s.nextInt();
		int o = s.nextInt();
			
		if (n>m && m>o) {
			System.out.print("El n�mero "+n+" es el mayor");
		}
		else if (o>n && n>m) {
			System.out.print("El n�mero "+o+" es el mayor");
		}
		else if (m>o && o>n) {
			System.out.print("El n�mero "+m+" es el mayor");
		}
		else if (n>o && o>m) {
			System.out.print("El n�mero "+n+" es el mayor");
		}
		else if (o>m && m>n) {
			System.out.print("El n�mero "+o+" es el mayor");
		}
		else if (m>n && n>o) {
			System.out.print("El n�mero "+m+" es el mayor");
		}
		else {
			System.out.print("Existen al menos 2 numeros iguales");
		}
	}
}