package pack;

import java.util.Scanner;

public class Pregunta6 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce numero de filas de la matriz (altura de la piramide)");
		int n = sc.nextInt();
		
		char[][] p = new char[n][2*n-1];
		
		System.out.println();
		
		for (int i = 0;i < p.length;i++) {
			for (int j = 0;j < p[i].length/2+1;j++) {
				if (i+j >= n-1) p[i][j] = '*';
				else p[i][j] = ' ';
			}
		}
		
		for (int i = 0;i < p.length;i++) {
			for (int j = p[i].length/2+1;j < p[i].length;j++) {
				if (j-i >= n) p[i][j] = ' ';
				else p[i][j] = '*';
			}
		}

		for (int i = 0;i < p.length;i++) {
			System.out.println();
			for (int j = 0;j < p[i].length;j++) {
				System.out.print(p[i][j]+"\t");
			}
		}
		
		sc.close();
	}
}
