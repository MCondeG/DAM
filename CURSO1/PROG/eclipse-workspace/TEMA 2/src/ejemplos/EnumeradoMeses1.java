package ejemplos;

import java.util.Scanner;

public class EnumeradoMeses1 {
	
	public enum Meses {ENERO,FEBRERO,MARZO,ABRIL,MAYO,JUNIO,JULIO,AGOSTO,SEPTIEMBRE,OCTUBRE,NOVIEMBRE,DICIEMBRE}

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Introduce 2 cadenas de caracteres");
		
		String cad1 = s.nextLine();
		String cad2 = s.nextLine();
		
		int n1 = cad1.compareTo(Meses.ENERO.toString());
		int n2 = cad1.compareTo(Meses.FEBRERO.toString());
		int n3 = cad1.compareTo(Meses.MARZO.toString());
		int n4 = cad1.compareTo(Meses.ABRIL.toString());
		int n5 = cad1.compareTo(Meses.MAYO.toString());
		int n6 = cad1.compareTo(Meses.JUNIO.toString());
		int n7 = cad1.compareTo(Meses.JULIO.toString());
		int n8 = cad1.compareTo(Meses.AGOSTO.toString());
		int n9 = cad1.compareTo(Meses.SEPTIEMBRE.toString());
		int n10 = cad1.compareTo(Meses.OCTUBRE.toString());
		int n11 = cad1.compareTo(Meses.NOVIEMBRE.toString());
		int n12 = cad1.compareTo(Meses.DICIEMBRE.toString());
		
		int m1 = cad2.compareTo(Meses.ENERO.toString());
		int m2 = cad2.compareTo(Meses.FEBRERO.toString());
		int m3 = cad2.compareTo(Meses.MARZO.toString());
		int m4 = cad2.compareTo(Meses.ABRIL.toString());
		int m5 = cad2.compareTo(Meses.MAYO.toString());
		int m6 = cad2.compareTo(Meses.JUNIO.toString());
		int m7 = cad2.compareTo(Meses.JULIO.toString());
		int m8 = cad2.compareTo(Meses.AGOSTO.toString());
		int m9 = cad2.compareTo(Meses.SEPTIEMBRE.toString());
		int m10 = cad2.compareTo(Meses.OCTUBRE.toString());
		int m11 = cad2.compareTo(Meses.NOVIEMBRE.toString());
		int m12 = cad2.compareTo(Meses.DICIEMBRE.toString());
		
		if ((n1 == 0 || n2 == 0 || n3 == 0 || n4 == 0 || n5 == 0 || n6 == 0 || n7 == 0 || n8 == 0 || n9 == 0 || n10 == 0 || n11 == 0 || n12 == 0) && (m1 == 0 || m2 == 0 || m3 == 0 || m4 == 0 || m5 == 0 || m6 == 0 || m7 == 0 || m8 == 0 || m9 == 0 || m10 == 0 || m11 == 0 || m12 == 0)) {
			System.out.println("Los 2 son meses");
		}
		else {
			System.out.println("Alguno no es un mes");
		}
	}

}