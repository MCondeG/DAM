package ejercicios;

import java.util.Scanner;

public class Funciones5{
	
	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		
		int [] numeros = new int [100];
		int [] nuevoVector = new int [numeros.length];
		
		for (int i = 0; i < numeros.length; i ++) {

			numeros[i] = (int)(Math.random()*10001);
			
		}
		
		nuevoVector = filtraCon7(numeros);
		
		for (int i = 0; i < nuevoVector.length; i ++) {
			
			System.out.print(nuevoVector[i]+" ");
			
		}

	}
	
	public static int [] filtraCon7 (int x []) {
		
		int k = 0;
		int [] nuevoVector = new int [x.length];
		boolean flag = false;
		
		for (int i = 0; i < x.length; i ++) {
			
			if (tiene7(x[i])) {
				
				nuevoVector[k] = x [i];
				flag = true;
				k ++;

			}
			
		}
		
		if (flag == false) {
		
			nuevoVector [k] = - 1;
			
		}
		
		if (flag = true) {
			
			return nuevoVector;
			
		}
		
		else {
			
			nuevoVector [0] = - 1;	
			
		}
		
		return nuevoVector;

	}
	
	public static boolean tiene7 (int num) {
		
		boolean tiene = false;
		int cifra = 0;
		int numaux = num;
		
		while (tiene == false && (numaux != 0)) {		
			
			cifra = numaux % 10;
			numaux = numaux / 10;
			
			if (cifra == 7) {
				
				tiene = true;
				return tiene;
			
			}	
			
		}

		return tiene;
		
	}

}