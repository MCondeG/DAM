package ejemplos;

import java.util.Scanner;

public class Ejemplo1 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		if (n>0) {
			System.out.print("El número "+n+" es positivo");
		}
		else if (n==0) {
			System.out.print("El número es 0");
		}
		else {
			System.out.print("El número "+n+" es negativo");
		}

	}

}