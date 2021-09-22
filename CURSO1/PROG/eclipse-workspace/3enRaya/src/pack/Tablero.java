package pack;

public class Tablero {
	
	public void inicializar (char[][] tab) {
		
		for (int i = 0;i < 5;i++) {
			tab[1][i] = '-';
			tab[3][i] = '-';
			tab[i][1] = '|';
			tab[i][3] = '|';
			tab[1][3] = '|';
		}
	}
	
	public void pintar (char[][] tab) {
		
		System.out.println("\n");
		
		for (int i = 0;i < tab.length;i++) {
			System.out.println();
			for (int j = 0;j < tab[i].length;j++) {
				if (j == 0) System.out.print("\t"+tab[i][j]+" ");
				else System.out.print(tab[i][j]+" ");
			}
		}
	}
	
	public void actualizar (char[][] juego, char[][] tab) {
		
		tab[0][0] = juego [0][0];
		tab[0][2] = juego [0][1];
		tab[0][4] = juego [0][2];
		tab[2][0] = juego [1][0];
		tab[2][2] = juego [1][1];
		tab[2][4] = juego [1][2];
		tab[4][0] = juego [2][0];
		tab[4][2] = juego [2][1];
		tab[4][4] = juego [2][2];	
	}
}