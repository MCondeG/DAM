package ejercicios;

import java.util.Scanner;

public class LecturaDatos3 {
	
	static final double Conversion = 166.386;

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Introduce una cantidad en euros");
		
		double euro = s.nextDouble();
		
		System.out.print("El valor de "+euro+"� en pesetas es: "+(euro*Conversion));

	}

}