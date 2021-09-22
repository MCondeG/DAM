package pack;

import java.util.Scanner;

public class Operacion {			//clase para gestionar los cambios realizados en la matriz
	
	Scanner sc2 = new Scanner(System.in);
	
	public void rellenar (int[][] matriz) {
		
		System.out.println("Introduce los 16 elementos de la matriz por orden de filas");
		
		for (int i = 0;i < matriz.length;i++) {
			for (int j = 0;j < matriz[i].length;j++) {
				matriz[i][j] = sc2.nextInt();
			}
		}
		
		System.out.println("\nMatriz cargada");
	}
	
	public void copiar (int[][] matriz, int[][] aux) {
		
		for (int i = 0;i < matriz.length;i++) {
			for (int j = 0;j < matriz[i].length;j++) {
				aux[i][j] = matriz[i][j];
			}
		}
	}
	
	public void trasponer (int[][] matriz, int[][] aux) {
		
		copiar(matriz, aux);
		
		for (int i = 0;i < matriz.length;i++) {
			for (int j = 0;j < matriz[i].length;j++) {
				matriz[i][j] = aux[j][i];
			}
		}
		
		System.out.println("\nMatriz traspuesta");
	}
	
	public void tabla (int[][] matriz) {		//muestra la matriz dentro de una tabla
		
		System.out.println();
		
		for (int i = 0;i < matriz.length;i++) {
			System.out.println();
			System.out.print("    ");
			for (int k = 0;k <matriz[i].length;k++) {
				System.out.print("+=======");
			}
			
			System.out.print("+");
			System.out.println();
			System.out.print("    |");
			
			for (int l = 0;l <matriz[i].length;l++) {
				System.out.print("       |");
			}
			System.out.println();
			
			for (int j = 0;j < matriz[i].length;j++) {
				if (j == 0) {
					System.out.printf("    |\t%-4d|",matriz[i][j]);
				}
				else {
					System.out.printf("\t%-4d|",matriz[i][j]);
				}
			}
			
			System.out.println();
			System.out.print("    |");
			
			for (int l = 0;l <matriz[i].length;l++) {
				System.out.print("       |");
			}
			
			if (i == (matriz.length - 1)) {
				System.out.println();
				System.out.print("    ");
				for (int k = 0;k <matriz[i].length;k++) {
					System.out.print("+=======");
				}
				System.out.print("+");
			}
		}
		
		System.out.println("\n");
	}

	public void prueba (int[][] matriz) {				//rellena la matriz con numeros aleatorios entre 0 y 100
		
		for (int i = 0;i < matriz.length;i++) {
			for (int j = 0;j < matriz[i].length;j++) {
				matriz[i][j] = (int)(Math.random()*101);
			}
		}
		
		System.out.println("\nMatriz de pruebas cargada");
	}
}