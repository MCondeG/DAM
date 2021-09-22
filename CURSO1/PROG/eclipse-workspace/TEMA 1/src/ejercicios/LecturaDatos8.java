package ejercicios;

import java.util.Scanner;

public class LecturaDatos8 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner s = new Scanner(System.in);
		
		int x = s.nextInt();
		int hora = x/3600;
		int min = (x%3600)/60;
		int seg = x-((hora*3600)+(min*60));
		
		System.out.println(hora+" horas, "+min+" minutos y "+seg+" segundos");
	}
}