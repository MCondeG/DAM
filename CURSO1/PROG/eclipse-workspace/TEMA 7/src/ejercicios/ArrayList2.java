package ejercicios;

import java.util.ArrayList;

public class ArrayList2 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		int n, tamaño, suma = 0, max = 0, min = 100;
		double media = 0;
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		tamaño = (int)((Math.random()*11)+10);
		
		for (int i = 0; i < tamaño; i++) {
			n = (int)(Math.random()*101);
			a.add(n);
			suma += n;
			min = Math.min(min, n);
			max = Math.max(max, n);
			System.out.print(a.get(i)+" ");
		}
		
		media = suma/tamaño;
		
		System.out.println();
		System.out.println();
		
		System.out.println("La suma es: "+suma);
		System.out.println("La media es: "+media);
		System.out.println("El mínimo es: "+min);
		System.out.println("El máximo es: "+max);
	}
}