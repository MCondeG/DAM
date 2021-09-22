package ejercicios;

import java.util.Scanner;

public class Condicionales18 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduzca la base imponible");
		double x = sc.nextDouble();
		
		System.out.println("Introduzca el tipo de IVA");
		String iva = sc.next();
		
		System.out.println("Introduzca el codigo promocional");
		String cod = sc.next();
		
		double x2 = 0;
		double x3 = 0;
		
		switch (iva) {
		case "general":
			x2 = x*21/100;
			break;
		case "reducido":
			x2 = x/10;
			break;
		case "superreducido":
			x2 = x*4/100;
			break;
		default:
			System.out.println("ERROR");
			break;
		}
		
		switch (cod) {
		case "nopro":
			x3 = 0;
			break;
		case "mitad":
			x3 = -((x+x2)/2);
			break;
		case "meno5":
			x3 = -5;
			break;
		case "5porc":
			x3 = -((x+x2)*5/100);
			break;
		default:
			System.out.println("ERROR");
			break;	
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		System.out.println("BASE IMPONIBLE: "+x);
		System.out.println("IVA ("+iva+"): "+x2);
		System.out.println("PRECIO CON IVA: "+(x+x2));
		System.out.println("CÓDIGO PROMOCIONAL ("+cod+"): "+x3);
		System.out.println("TOTAL: "+(x+x2+x3));
		
	}

}
