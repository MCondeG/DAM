package pack;

import java.util.Scanner;

public class Pregunta3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce la altura de la figura");
		int h = sc.nextInt();
		
		System.out.println();
		
		for (int i = 1;i <= h;i++) { //pieza superior izquierda
			for (int j = 1;j <= h;j++) {
				if (j+i >= h+2) {
					System.out.print(" ");
				}
				else {
					System.out.print("*");
				}
			}
			for (int j = h;j >= 1;j--) { //pieza superior derecha
				if (j+i >= h+2) {
					System.out.print(" ");
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println();	
		}
		
		//variando la condicion de inicialización y fin de las variables i,j podemos dar la vuelta a cada una de las piezas de la figura
		
		for (int i = h;i >= 1;i--) { //pieza inferior izquierda
			for (int j = 1;j <= h;j++) {
				if (j+i >= h+2) {
					System.out.print(" ");
				}
				else {
					System.out.print("*");
				}
			}
			for (int j = h;j >= 1;j--) { //pieza inferior derecha
				if (j+i >= h+2) {
					System.out.print(" ");
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println();	
		}
		
		sc.close();
	}
}