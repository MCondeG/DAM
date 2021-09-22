package ejercicios;

import java.util.Scanner;

public class Funciones4 {
	
	public static int numCifras (int n) {
		
		int cifras = 1;
		
		while (n >= 10) {
			n = n/10;
			cifras++;
		}
		
		return cifras;
	}
	
	public static int invierteNum(int n) {
		
		int naux;
		int n2 = 0; 
		int a = 0; //cifra concreta de cada iteración del bucle
		int d = 10;
		
		int cifras = numCifras(n);
		int cont = cifras;
		
		while (cont > 0) {
			naux = (n/d)*d; //trunca la variable y añade un 0 al final
			a = (n - naux)/(d/10); //restando la variable original aislamos el dígito que buscamos
			n2 = n2 + (a*(int)Math.pow(10, cont-1)); //contruimos el número al revés
			d = d*10;
			cont--;
		}
		
		return n2;
	}
	
	public static String convierteEnPalabras(int n) {
		
		String c = "";
		int cifras = numCifras(n);
		int cifra;
		
		int n2 = invierteNum(n);
		
		do {
			
			cifra = n2%10;
			n2 = n2/10;
			
			switch (cifra) {
			case 0:
				c = c.concat("cero, ");
				break;
			case 1:
				c = c.concat("uno, ");
				break;
			case 2:
				c = c.concat("dos, ");
				break;
			case 3:
				c = c.concat("tres, ");
				break;
			case 4:
				c = c.concat("cuatro, ");
				break;
			case 5:
				c = c.concat("cinco, ");
				break;
			case 6:
				c = c.concat("seis, ");
				break;
			case 7:
				c = c.concat("siete, ");
				break;
			case 8:
				c = c.concat("ocho, ");
				break;
			case 9:
				c = c.concat("nueve, ");
				break;
			default:
				break;			
			}
			
			cifras--;
		} while (cifras > 0);
		
		
		return c;
	}

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un número entero");
		
		int n = sc.nextInt();
		
		String cad = convierteEnPalabras(n).trim();
		cad = cad.substring(0, cad.length()-1);
		
		System.out.println("\n"+cad);
		
		sc.close();
	}
}