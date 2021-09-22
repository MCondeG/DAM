package ejercicios;

import java.util.*;

public class ArrayList6 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		ArrayList a = new ArrayList();

		int n;
		
		for (int i = 0; i < 10; i++) {
			n = (int)(Math.random()*101);
			a.add(n);
			System.out.print(a.get(i)+" ");
		}
		
		a = calculaInversa(a);
		
		System.out.println();
		System.out.println();
		
		for (int i = 0; i < 10; i++) {
			System.out.print(a.get(i)+" ");
		}
	}
	
	public static ArrayList calculaInversa(ArrayList a) {
		Collections.reverse(a);
		return a;
	}
}