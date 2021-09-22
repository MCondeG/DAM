package ejercicios;

import java.util.Scanner;

public class Bucles20 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner sc = new Scanner(System.in);

		double suma = 0.0;
		double media = 0.0;
		int cont = 0;
		double x;
		
		System.out.println("Introduce números");
		
		do {
			x = sc.nextDouble();
			suma = suma + x;
			cont++;
			
		} while (suma < 100.0);
		
		suma = suma - x;
		cont--;
		
		media = suma/cont;
		
		System.out.println();
		System.out.println("El total acumulado es "+suma);
		System.out.println("Se han introducido "+cont+" números");
		System.out.println("La media es "+media);
	}
}