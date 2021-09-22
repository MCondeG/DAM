package pack;

public class IA {
	
	Operacion op = new Operacion();
	
	public void ponerMarcaIA (char[][] juego, char[][] aux, boolean[][] posocupada, int[] pos) {

			juego[pos[0]][pos[1]] = 'O';
			
			posocupada[pos[0]][pos[1]] = true;
		
	}
	
	public boolean casiGanadorFila (char[][] juego, boolean[][] posocupada, int cont1, int cont2, int[] pos) {
		
		for (int i = 0;i < juego.length;i++) { 
			for (int j = 0;j < juego[i].length;j++) {
				if (juego[i][j] == 'X') cont1++;
				else if (juego[i][j] == 'O') cont2++;
			}
			if (cont2 == 2) {
				for (int k = 0;k < juego[i].length;k++) {
					if (!posocupada[i][k]) {
						pos[0] = i;
						pos[1] = k;
						return true;
					}
				}
			}
			else if (cont1 == 2) {
				for (int k = 0;k < juego[i].length;k++) {
					if (!posocupada[i][k]) {
						pos[0] = i;
						pos[1] = k;
						return true;
					}
				}
			}
			else {
				cont1 = 0;
				cont2 = 0;
			}
		}
			
		return false;	
	}

	public boolean casiGanadorDiagPrin (char[][] juego, boolean[][] posocupada, int cont1, int cont2, int[] pos) {
		
		for (int i = 0;i < juego.length;i++) {				
			if (juego[i][i] == 'X') cont1++;
			else if (juego[i][i] == 'O') cont2++;
		}
		
		if (cont2 == 2) {
			for (int i = 0;i < juego.length;i++) {
				if (!posocupada[i][i]) {
					pos[0] = i;
					pos[1] = i;
					return true;
				}
			}
		}
		else if (cont1 == 2) {
			for (int i = 0;i < juego.length;i++) {
				if (!posocupada[i][i]) {
					pos[0] = i;
					pos[1] = i;
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean casiGanadorDiagInv (char[][] juego, boolean[][] posocupada, int cont1, int cont2, int[] pos) {
		
		for (int i = 0;i < juego.length;i++) {				
			if (juego[i][juego.length - i - 1] == 'X') cont1++;
			else if (juego[i][juego.length - i - 1] == 'O') cont2++;
		}
		
		if (cont2 == 2) {
			for (int i = 0;i < juego.length;i++) {
				if (!posocupada[i][juego.length - i - 1]) {
					pos[0] = i;
					pos[1] = juego.length - i - 1;
					return true;
				}
			}
		}
		else if (cont1 == 2) {
			for (int i = 0;i < juego.length;i++) {
				if (!posocupada[i][juego.length - i - 1]) {
					pos[0] = i;
					pos[1] = juego.length - i - 1;
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean casiGanadorIA (char[][] juego, boolean[][] posocupada, char[][] aux, int[] pos) {
		
		int cont1 = 0;
		int cont2 = 0;
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
		int posaux;
		
		flag1 = casiGanadorFila (juego, posocupada, cont1, cont2, pos);
		
		if (!flag1) flag2 = casiGanadorDiagPrin (juego, posocupada, cont1, cont2, pos);
		
		if (!flag1 && !flag2) flag3 = casiGanadorDiagInv (juego, posocupada, cont1, cont2, pos);
		
		if (!flag1 && !flag2 && !flag3) {
			op.trasponer (juego,aux);
			flag4 = casiGanadorFila (juego, posocupada, cont1, cont2, pos);
			op.trasponer (juego,aux);	
			
			if (flag4) {
				
				posaux = pos[0];
				pos[0] = pos[1];
				pos[1] = posaux;
			}	
		}
		
		if (flag1 || flag2 || flag3 || flag4) return true;
		else return false;
	}
	
	public void decisionIA (char[][] juego, char[][] aux, boolean[][] posocupada, int[] pos) {
		
		boolean flag = casiGanadorIA (juego, posocupada, aux, pos);
		boolean salida = false;
		
		if (flag) {
			ponerMarcaIA (juego, aux, posocupada, pos);
		}
		else if (!posocupada[1][1]) {	
			pos[0] = 1;
			pos[1] = 1;
			ponerMarcaIA (juego, aux, posocupada, pos);
		}
		else {	
			do {
				pos[0] = (int)(Math.random()*3);
				pos[1] = (int)(Math.random()*3);
				if (!posocupada[pos[0]][pos[1]]) {
					ponerMarcaIA (juego, aux, posocupada, pos);
					salida = true;
				}
			} while ((posocupada[pos[0]][pos[1]]) && (!salida));
		}
	}
}