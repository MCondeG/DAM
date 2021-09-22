package pack;

public class Tablero {
	
	public void iniciaTableroBlanco (String[][] tab) {			//inicializa la matriz de letras a espacios en blanco
		
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				tab[i][j] = " ";
			}
		}
	}
	
	public void iniciaTableroVisual (String[][] tab) {			//inicializa el tablero visual con las posiciones de cada casilla
		
		char a,b;
		
		for (int i = 0; i < tab.length; i++) {
			a = Character.forDigit((i+1), 10);
			for (int j = 0; j < tab[i].length; j++) {
				b = Character.forDigit((j+1), 10);
				tab[i][j] = a+","+b;
			}
		}
	}
	
	public void pintaTablero (String[][] tab) {			//pinta el tablero con las posiciones o las letras, según corresponda
		
		System.out.println("\n\n");

		for (int i = 0;i < tab.length;i++) {
			System.out.println();
			System.out.print("    ");
			for (int k = 0;k <tab[i].length;k++) {
				System.out.print("+=======");
			}
			
			System.out.print("+");
			System.out.println();
			System.out.print("    |");
			
			for (int l = 0;l <tab[i].length;l++) {
				System.out.print("       |");
			}
			System.out.println();
			
			for (int j = 0;j < tab[i].length;j++) {
				if (j == 0) {
					System.out.printf("    |\t%-4s|",tab[i][j]);
				}
				else {
					System.out.printf("\t%-4s|",tab[i][j]);
				}
			}
			
			System.out.println();
			System.out.print("    |");
			
			for (int l = 0;l <tab[i].length;l++) {
				System.out.print("       |");
			}
			
			if (i == (tab.length - 1)) {
				System.out.println();
				System.out.print("    ");
				for (int k = 0;k <tab[i].length;k++) {
					System.out.print("+=======");
				}
				System.out.print("+");
			}
		}
		
		System.out.println("\n");
	}
	
	public void destapar (String[][] tab1, String[][] tab2, int[] pos) {				//destapa una letra en el tablero
		
		tab2[pos[0]][pos[1]] = tab1[pos[0]][pos[1]];
		System.out.println("\nHas encontrado la letra '"+tab1[pos[0]][pos[1]]+"'");
	}
	
	public void retapar (String[][] tab2, int[] pos, boolean[][] posOcupada) {			//vuelve a tapar una letra en el tablero y libera la posición ocupada
		
		tab2[pos[0]][pos[1]] = (pos[0]+1)+","+(pos[1]+1);
		posOcupada[pos[0]][pos[1]] = false;
	}
}