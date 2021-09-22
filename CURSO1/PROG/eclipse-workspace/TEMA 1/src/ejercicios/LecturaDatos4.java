package ejercicios;

import java.util.Scanner;

public class LecturaDatos4 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner s = new Scanner(System.in);
		
		double x = s.nextDouble();
		double y = s.nextDouble();
		
		System.out.println((x+y)+" "+(x-y)+" "+(x*y)+" "+(x/y));
	}
}