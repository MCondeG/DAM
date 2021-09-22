package ejemplos;

import java.util.Scanner;

public class SemanaSwitch2 {

	public enum Dias{LUNES,MARTES,MIERCOLES,JUEVES,VIERNES,SABADO,DOMINGO}

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Introduce un dia de la semana");
		
		String dia = s.nextLine();
		
		switch (dia) {
		case "lunes": 
			System.out.println(Dias.LUNES);
			break;
		case "martes": 
			System.out.println(Dias.MARTES);
			break;
		case "miercoles": 
			System.out.println(Dias.MIERCOLES);
			break;
		case "jueves": 
			System.out.println(Dias.JUEVES);
			break;
		case "viernes": 
			System.out.println(Dias.VIERNES);
			break;
		case "sabado": 
			System.out.println(Dias.SABADO);
			break;
		case "domingo": 
			System.out.println(Dias.DOMINGO);
			break;
		default:
			System.out.println("Error");
			break;
		}
	}

}