package ejercicios;

import java.util.Scanner;

public class Funciones10 {

static Scanner sc = new Scanner (System.in);
	
	private static void rotarALaIzquierdaNVeces(int [] array, int rot, int [] aux) {
		
		for (int i = 0; i < rot; i++) {
			
			rotarizquierda(array, aux);
			
			for (int j = 0; j < array.length; j ++) {
				
				aux [j] = array [j];
				
			}
			
		}
	}
	
	public static int[] rotarizquierda(int[] numeros, int [] aux){

		  for(int j = 0; j < numeros.length - 1; j++) {
			  
			  numeros[j] = aux[j+1];
			  
		  }
		  
		  numeros [aux.length - 1] = aux[0];
		  
		  return numeros;
		  
		}
	
	public static void main(String[] args) {
		
		int [] vector = {5,10,15,20,25,30,35,40,45,50};
		int [] aux = {5,10,15,20,25,30,35,40,45,50};
		
		System.out.println("Introduce el número de veces que quieres rotar: ");
		int n = sc.nextInt();
		
		rotarALaIzquierdaNVeces(vector, n, aux);
		
		for (int i = 0; i < vector.length; i++) {
			
			System.out.print (vector[i] +" ");
			
		}

	}

}
