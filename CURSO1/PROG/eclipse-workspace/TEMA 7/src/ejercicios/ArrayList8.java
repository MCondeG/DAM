package ejercicios;

import java.util.*;

public class ArrayList8 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		int r;
		
		for (int i = 0; i < 10; i++) {
			r = (int)(Math.random()*101);
			a.add(r);
			System.out.print(r+" ");
		}
		
		System.out.println("\n");
				
		if (estaOrdenada(a)) System.out.println("Lista ordenada");
		else System.out.println("Lista desordenada");
		
	}
	
	public static boolean estaOrdenada(ArrayList<Integer> a) {
		
		boolean orden = true;
		
		for (int i = 0; i < (a.size() - 1); i++) {
			if (a.get(i) > a.get(i+1)) orden = false;
		}
		
		return orden;
	}
}