package pack;

import java.util.Scanner;

public class Operacion {
	
	Scanner sc = new Scanner(System.in);

	public void crearLetras (char[] letra) {		//método para crear una lista de letras aleatorias sin repetición
		
		boolean flag = false;
		
		for (int i = 0; i < letra.length;i++) {
			do {
				letra[i] = (char)(int)((Math.random()*26)+65);
				flag = false;
				for (int j = 0;j < i;j++) {
					if (letra[j] == letra[i]) flag = true;
				}
			} while (flag);
		}
	}
	
	public void insertarLetras (char[] letra, String[][] tab, int size) {		//se insertan las letras generadas en la matriz de juego, por duplicado para que existan parejas
		
		int fila, col;
		
		for (int cont = 0; cont <= 1; cont++) {
			for (int i = 0; i < letra.length; i++) {
				
				do {
					fila = (int)(Math.random()*size);
					col = (int)(Math.random()*size);
				} while (tab[fila][col] != " ");
				
				tab[fila][col] = Character.toString(letra[i]);
			}
		}
	}
	
	public int pideDif () {
		
		int n;
		
		do {
			System.out.println("Introduce nivel de dificultad (tamaño del tablero: 2, 4 ó 6)");
			n = sc.nextInt();
			if (n != 2 && n != 4 && n != 6) System.err.println("\nERROR\n");
		} while (n != 2 && n != 4 && n != 6);
		
		return n;
	}
	
	public void pidePos (boolean[][] posOcupada, int[] pos, int size) {		//método para controlar la entrada de posiciones por el usuario
		
		do {
			
			System.out.println("\nIntroduce fila y columna (máximo "+size+")");
			pos[0] = sc.nextInt();
			pos[1] = sc.nextInt();
			if ((pos[0] > size || pos[1] > size) || (pos[0] > 0 && pos[1] > 0 && posOcupada[pos[0]-1][pos[1]-1])) System.err.println("\nERROR\n");

		} while ((pos[0] > size || pos[1] > size) || (pos[0] > 0 && pos[1] > 0 && posOcupada[pos[0]-1][pos[1]-1]));
		
		pos[0]--;
		pos[1]--;
		
		if (pos[0] >= 0 && pos[1] >= 0) posOcupada[pos[0]][pos[1]] = true;
	}
	
	public boolean comprobarLetra (String[][] tab, int[] pos1, int[] pos2) {		//comprueba si se ha acertado con las parejas
		
		return (tab[pos1[0]][pos1[1]].equals(tab[pos2[0]][pos2[1]]));
		
	}
	
	public boolean comprobarVictoria (int cont, int size) {							//comprueba la condición de victoria
		
		if (cont < ((size*size)/2)) return false;
		else return true;
	}
}