package ejercicios;

import java.util.Scanner;

public class LecturaDatos9 {
	
	static final double Pi = 3.1416;

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner s = new Scanner(System.in);
		
		double r = s.nextDouble();
		double h = s.nextDouble();
		double v = ((Math.pow(r,2))*h*Pi)/3.0;
			
		System.out.println("Volumen = "+v);
	}
}