package pack;

import java.util.Scanner;

public class Pregunta1 {
	
	public static void copiarAux (String[] s, String[] aux) {
		 for (int i = 0; i < aux.length; i++) {
			 aux[i] = s[i];
		 }
	}
	
	public static void rotarDerecha(String[] s, String[] aux) {

		copiarAux(s, aux);
		
		for(int i = 0; i < s.length - 1; i++) {	  
			s[i+1] = aux[i];
			  
		}
		  
		s[0] = aux[aux.length - 1];	  
	}
	
	public static void main(String[] args) {

		String[] s = {"manzana", "fresa", "piña", "albaricoque", "kiwi", "manzana", "mango", "limón", "granada", "pera"};
		String[] aux = new String[10];
		int cont = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce nueva posición inicial");
		int pos = sc.nextInt();
		
		System.out.println("\nVector original:");
		
		for (int i = 0; i < s.length; i++) {
			if (i == s.length - 1) System.out.print(s[i]);
			else System.out.print(s[i]+", ");
		}
		
		do {
			rotarDerecha(s, aux);
			cont++;
		} while (cont < pos);
		
		System.out.println("\n\nNuevo vector:");
		
		for (int i = 0; i < s.length; i++) {
			if (i == s.length - 1) System.out.print(s[i]);
			else System.out.print(s[i]+", ");
		}
		
		sc.close();
	}
}