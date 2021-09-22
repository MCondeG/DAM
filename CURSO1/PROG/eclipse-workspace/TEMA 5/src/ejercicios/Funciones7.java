package ejercicios;

import java.util.Scanner;

public class Funciones7 {
	
	static Scanner sc = new Scanner (System.in);
	
	public static int busquedadicotomica (int vector []) {
		
		System.out.println("Introduce un número: ");
		int num = sc.nextInt();
		
		int fin = vector.length - 1;
		int medio;
		int principio = 0;
		
		while (principio <= fin) {
			
			medio = (principio + fin) / 2;
			
			if (vector[medio] == num) {
				
				return medio;
				
			}
			
			else if (num < vector [medio]) {
				
				fin= medio - 1;
				
			}
			
			else {
				
				principio = medio + 1;
				
			}
			
		}
		
		return (- 1);
		
	}
	
	public static void main(String[] args) {
		
		int [] vector = {5,10,15,20,25,30,35,40,45,50};
		int posicion = busquedadicotomica(vector);
		
		System.out.println("Está en la posición " +posicion);
		
		sc.close();
		
	}
	
}