package ejercicios;

import java.util.Scanner;

public class Array9 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		int[] num = new int[10];
		int inicio, fin;		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce 10 enteros");
		
		for (int i = 0;i < num.length;i++) {
			num[i] = sc.nextInt();
		}
		
		System.out.println();
		for (int i = 0;i < num.length;i++) {
			System.out.println(i+". "+num[i]);
		}
		
		System.out.println();
		do {
			System.out.println("Introduce 2 enteros entre 0 y 9");
			inicio = sc.nextInt();
			fin = sc.nextInt();
		} while (!((inicio < fin) && (inicio>=0) && (inicio<=9) && (fin>=0) && (fin<=9)));
		
		int a = num[num.length-1];
		
		System.out.println();
		System.out.println("Array rotada:");
		
		for (int i = num.length-1;i > fin;i--) {
				num[i] = num[i-1];
		}
		num[fin] = num[inicio];
		
		for (int i = inicio;i > 0;i--) {
			num[i] = num[i-1];
		}
		num[0] = a;
		
		for (int i = 0;i<num.length;i++) {
			System.out.println(i+". "+num[i]);
		}
	}
}