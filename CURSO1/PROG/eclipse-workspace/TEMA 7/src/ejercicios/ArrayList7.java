package ejercicios;

import java.util.*;

public class ArrayList7 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		int n, r;
		
		for (int i = 0; i < 10; i++) {
			r = (int)(Math.random()*101);
			a.add(r);
		}
		
		System.out.println("Introduce un entero");
		n = sc.nextInt();
		
		Collections.sort(a);
		
		System.out.println("\nLista original");
		for (int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i)+" ");
		}
		
		insertaEnOrden(a, n);
		
		System.out.println("\n\nNueva lista:");
		for (int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i)+" ");
		}
		
		sc.close();
	}
	
	public static void insertaEnOrden(ArrayList<Integer> a, int n) {
		
		int pos = encuentraPosicion(a, n);
		
		a.add(pos, n);
	}
	
	public static int encuentraPosicion(ArrayList<Integer> a, int n) {
		
		int i = 0;
		boolean encontrado = false;
		
		while (!encontrado && i < a.size()) {
			if (a.get(i) >= n) encontrado = true;
			else i++;
		}
		
		return i;
	}
}