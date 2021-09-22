package ejercicios;

import java.util.Scanner;

public class Condicionales2 {
	
	public enum Meses {ENERO,FEBRERO,MARZO,ABRIL,MAYO,JUNIO,JULIO,AGOSTO,SEPTIEMBRE,OCTUBRE,NOVIEMBRE,DICIEMBRE}

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner s = new Scanner(System.in);
		
		System.out.println("Introduce un numero entero entre 1 y 12");
		
		int n = s.nextInt();
		
		if (n == 1) {
			System.out.println("El número "+n+" corresponde al mes "+Meses.ENERO);
		}
		else if (n == 2) {
			System.out.println("El número "+n+" corresponde al mes "+Meses.FEBRERO);
		}
		else if (n == 3) {
			System.out.println("El número "+n+" corresponde al mes "+Meses.MARZO);
		}
		else if (n == 4) {
			System.out.println("El número "+n+" corresponde al mes "+Meses.ABRIL);
		}
		else if (n == 5) {
			System.out.println("El número "+n+" corresponde al mes "+Meses.MAYO);
		}
		else if (n == 6) {
			System.out.println("El número "+n+" corresponde al mes "+Meses.JUNIO);
		}
		else if (n == 7) {
			System.out.println("El número "+n+" corresponde al mes "+Meses.JULIO);
		}
		else if (n == 8) {
			System.out.println("El número "+n+" corresponde al mes "+Meses.AGOSTO);
		}
		else if (n == 9) {
			System.out.println("El número "+n+" corresponde al mes "+Meses.SEPTIEMBRE);
		}
		else if (n == 10) {
			System.out.println("El número "+n+" corresponde al mes "+Meses.OCTUBRE);
		}
		else if (n == 11) {
			System.out.println("El número "+n+" corresponde al mes "+Meses.NOVIEMBRE);
		}
		else if (n == 12) {
			System.out.println("El número "+n+" corresponde al mes "+Meses.DICIEMBRE);
		}
		else {
			System.out.println("ERROR");
		}
			
	}

}
