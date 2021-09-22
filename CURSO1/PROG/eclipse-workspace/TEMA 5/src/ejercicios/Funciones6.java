package ejercicios;

import java.util.Scanner;

public class Funciones6 {

static Scanner sc = new Scanner (System.in);
	
	public static int [] introduceordenado (int numeros1 []) {
		
		System.out.println("Introduce un número: ");
		int num = sc.nextInt();
		
		int x = numeros1.length + 1;
		int [] numeros2 = new int [x];
		
		for (int i = 0; i < numeros1.length; i ++) {
			
			numeros1 [i] = numeros2 [i];
			
		}
		
		boolean insertar = false;
		
		//while
		
		for (int i = 0; i < x && insertar; i ++) {
			
			if (num < numeros2 [i]) {
				
				for (int j = x - 2; j >= i; j --) {
					
					numeros1 [j] = numeros2 [j];
					
				}
			
				numeros2 [i] = num;
				insertar = true;
				
			}
			
		}
		
		return numeros2;
		
	}
	
	public static void main(String[] args) {
		
		int [] numeros = {1,3,5,7,9,11,13,15,17,19};
		
		numeros = introduceordenado(numeros);
		
		for (int i = 0; i < numeros.length; i ++) {
			
			System.out.println(numeros[i] +"\t");
			
		}

	}

}
