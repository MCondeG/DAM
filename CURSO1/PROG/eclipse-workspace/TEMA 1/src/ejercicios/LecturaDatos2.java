package ejercicios;

import java.util.Scanner;

public class LecturaDatos2 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner s = new Scanner(System.in);
		System.out.println("Introduce 3 numeros cualesquiera separados por espacio");
		
		double x = s.nextDouble();
		double y = s.nextDouble();
		double z = s.nextDouble();
		double media = (x+y+z)/3.0;
		
		System.out.print("La media es "+media);

	}

}