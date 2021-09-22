package ejercicios;

import java.util.Scanner;

public class Array10 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner sc = new Scanner(System.in);

		String[] color = {"verde","rojo","azul","amarillo","naranja","rosa","negro","blanco","morado"};
		String[] a = new String[7];
		String[] b = new String[7];
		
		int pos = 0;
		int j = 0;
		int k = 0;
		
		for (int i = 0;i < a.length;i++) {
			a[i] = sc.next();
			b[i] = a[i];
		}
		
		System.out.println();
		
		for (int i = 0;i < a.length;i++) {
			System.out.println(a[i]);
		}
		
		System.out.println();
		
		while (j < b.length) {
			while (k < color.length) {
				if (b[j].equalsIgnoreCase(color[k])) {
					a[pos] = color[k];
					pos++;
				}
			k++;
			}
			k = 0;
			j++;
		}
		
		j = 0;
		k = 0;
		
		while (j < b.length) {
			while (k < color.length) {
				if ((!(b[j].equalsIgnoreCase(color[k]))) && pos <7) {
					a[pos] = b[j];
					pos++;
				}
			k++;
			}
			k = 0;
			j++;
		}
		
		for (int i = 0; i < a.length;i++) {
			System.out.println(a[i]);
		}
	}
}