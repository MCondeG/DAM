package ejercicios;

import java.util.Scanner;

public class Funciones8 {

	static Scanner sc = new Scanner (System.in);
	
	public static void busquedaSecuencial (int lista []) {
		
		boolean encontrado = false;	
		int i = 0;
		int pos = - 1;
		
		System.out.println("Introduce un n�mero: ");
		int num=sc.nextInt();
		
		for (i = 0; i < lista.length; i ++) {
			
			if (lista[i] == num) {
				
				encontrado = true;
				pos = i;
			}
				
		}

		if (encontrado) {
			
			System.out.println("S� hay alg�n valor: " +num +" en la posici�n: " +pos);
			
		}
			
		else {
			
			System.out.println("No hay ningun valor: " +num +" en la lista");
			
		}
			
		
	}
	
		
	public static void main(String[] args) {
			
			int [] vector = {5,10,15,20,25,30,35,40,45,50};
			busquedaSecuencial(vector);
			
			sc.close();

	}
		
}	
