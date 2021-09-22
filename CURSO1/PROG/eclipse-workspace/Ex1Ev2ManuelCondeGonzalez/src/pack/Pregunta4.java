package pack;

import java.util.Scanner;

public class Pregunta4 {
	
	public static void actualizaMatriz (int[][] m, int[] p) {
		
		if (p[0] != 0 && p[0] != 2) {
			m[p[0]-1][p[1]] = m[p[0]-1][p[1]] - 1;
			m[p[0]+1][p[1]] = m[p[0]+1][p[1]] - 1;
		}
		else if (p[0] == 0) {
			m[p[0]+1][p[1]] = m[p[0]+1][p[1]] - 1;
		}
		else m[p[0]-1][p[1]] = m[p[0]-1][p[1]] - 1;
		
		
		if (p[1] > 0 && p[1] < 4) {
			m[p[0]][p[1]-1] = m[p[0]][p[1]-1] - 1;
			m[p[0]][p[1]+1] = m[p[0]][p[1]+1] - 1;
		}
		else if (p[1] == 0) {
			m[p[0]][p[1]+1] = m[p[0]][p[1]+1] - 1;
		}
		else m[p[0]][p[1]-1] = m[p[0]][p[1]-1] - 1;

		
		if (p[0] != 0 && p[0] != 2 && p[1] > 0 && p[1] < 4) {
			m[p[0]-1][p[1]-1] = m[p[0]-1][p[1]-1] - 1;
			m[p[0]+1][p[1]+1] = m[p[0]+1][p[1]+1] - 1;
			m[p[0]+1][p[1]-1] = m[p[0]+1][p[1]-1] - 1;
			m[p[0]-1][p[1]+1] = m[p[0]-1][p[1]+1] - 1;
		}
		else if (p[0] == 0) {
			if (p[1] == 0) m[p[0]+1][p[1]+1] = m[p[0]+1][p[1]+1] - 1;
			else if (p[1] == 4) m[p[0]+1][p[1]-1] = m[p[0]+1][p[1]-1] - 1;
			else {
				m[p[0]+1][p[1]-1] = m[p[0]+1][p[1]-1] - 1;
				m[p[0]+1][p[1]+1] = m[p[0]+1][p[1]+1] - 1;
			}
		}
		else if (p[0] == 1) {
			if (p[1] == 0) {
				m[p[0]-1][p[1]+1] = m[p[0]-1][p[1]+1] - 1;
				m[p[0]+1][p[1]+1] = m[p[0]+1][p[1]+1] - 1;
			}
			else if (p[1] == 4) {
				m[p[0]-1][p[1]-1] = m[p[0]-1][p[1]-1] - 1;
				m[p[0]+1][p[1]-1] = m[p[0]+1][p[1]-1] - 1;
			}
			else {
				m[p[0]-1][p[1]-1] = m[p[0]-1][p[1]-1] - 1;
				m[p[0]-1][p[1]+1] = m[p[0]-1][p[1]+1] - 1;
			}
		}
		else if (p[0] == 2) {
			if (p[1] == 0) m[p[0]-1][p[1]+1] = m[p[0]-1][p[1]+1] - 1;
			else if (p[1] == 4) m[p[0]-1][p[1]-1] = m[p[0]-1][p[1]-1] - 1;
			else {
				m[p[0]-1][p[1]-1] = m[p[0]-1][p[1]-1] - 1;
				m[p[0]-1][p[1]+1] = m[p[0]-1][p[1]+1] - 1;
			}
		}
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int[][] mapa = {{1,2,3,11,35},{4,9,6,45,6},{9,0,5,50,14}};
		int[] pos = new int[2];
		
		System.out.println("Introduce fila y columna");
		pos[0] = sc.nextInt();
		pos[1] = sc.nextInt();

		System.out.println("Mapa original:");
		
		for (int i = 0; i < mapa.length; i++) {
			System.out.println();
			for (int j = 0; j < mapa[i].length; j++) {
				System.out.print(mapa[i][j]+" ");
			}
		}
		
		actualizaMatriz(mapa, pos);
		
		System.out.println("\n\n\nMapa Actualizado");
		
		for (int i = 0; i < mapa.length; i++) {
			System.out.println();
			for (int j = 0; j < mapa[i].length; j++) {
				System.out.print(mapa[i][j]+" ");
			}
		}
		
		sc.close();
	}
}