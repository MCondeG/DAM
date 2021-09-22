package ejercicios;

import java.util.Scanner;

public class PrincipalMatriz {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		int fil, col;
		
		System.out.println("Introduce n�mero de filas iniciales de la Matriz");
		fil = sc.nextInt();
		System.out.println("Introduce n�mero de columnas iniciales de la Matriz");
		col = sc.nextInt();
		
		Matriz m = new Matriz(fil, col, false);
		
		System.out.println("\nMatriz din�mica "+fil+"x"+col+" inicializada con �xito!");
		m.imprimir();
		
		System.out.println("\n");
		
		menu(m, fil, col);
	}
	
	public static void menu(Matriz m, int fil, int col) {
		
		int n;
		
		do {
		
			System.out.println("\n\n");
			System.out.println("�Qu� desea hacer?");
			System.out.println("1. Generar matriz aleatoria");
			System.out.println("2. Matriz sim�trica");
			System.out.println("3. Matriz traspuesta");
			System.out.println("Por defecto - Salir");
			n = sc.nextInt();
			
			switch (n) {
			case 1:
				Matriz aux1 = new Matriz(fil, col, true);
				m = aux1;
				System.out.println("\nMatriz aleatoria "+fil+"x"+col+" generada con �xito!");
				m.imprimir();
				break;
			case 2:
				m.espejo();
				System.out.println();
				m.imprimir();
				break;
			case 3:
				Elemento[][] trasp = m.trasponer();
				Matriz aux2 = new Matriz(fil, col, trasp);
				m = aux2;
				System.out.println();
				m.imprimir();
				break;
			default:
				break;
			}
			
		} while (n == 1 || n == 2 || n == 3);
	}
}