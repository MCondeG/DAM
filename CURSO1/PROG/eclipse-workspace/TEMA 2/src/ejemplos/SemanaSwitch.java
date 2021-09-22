package ejemplos;

import java.util.Scanner;

public class SemanaSwitch {

	public enum Dias{LUNES,MARTES,MIERCOLES,JUEVES,VIERNES,SABADO,DOMINGO}

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Introduce un entero");
		
		int n = s.nextInt();
		
		switch (n) {
		case 1: 
			System.out.println(Dias.LUNES);
			break;
		case 2: 
			System.out.println(Dias.MARTES);
			break;
		case 3: 
			System.out.println(Dias.MIERCOLES);
			break;
		case 4: 
			System.out.println(Dias.JUEVES);
			break;
		case 5: 
			System.out.println(Dias.VIERNES);
			break;
		case 6: 
			System.out.println(Dias.SABADO);
			break;
		case 7: 
			System.out.println(Dias.DOMINGO);
			break;
		default:
			System.out.println("Error");
			break;
		}
	}

}
