package ejercicios;

import java.util.ArrayList;

public class ArrayList2 {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente

		int n, tama�o, suma = 0, max = 0, min = 100;
		double media = 0;
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		tama�o = (int)((Math.random()*11)+10);
		
		for (int i = 0; i < tama�o; i++) {
			n = (int)(Math.random()*101);
			a.add(n);
			suma += n;
			min = Math.min(min, n);
			max = Math.max(max, n);
			System.out.print(a.get(i)+" ");
		}
		
		media = suma/tama�o;
		
		System.out.println();
		System.out.println();
		
		System.out.println("La suma es: "+suma);
		System.out.println("La media es: "+media);
		System.out.println("El m�nimo es: "+min);
		System.out.println("El m�ximo es: "+max);
	}
}