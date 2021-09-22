package pack;

import java.util.Scanner;

public class Operacion {
	
	Scanner sc = new Scanner(System.in);
	
	public boolean elegirModo() {
		
		int n;
		
		System.out.println("1. Modo 1 jugador (VS IA)");
		System.out.println("2. Modo jugador VS jugador");
		System.out.println();
		
		do {
			n = sc.nextInt();
			if ((n != 1) && (n != 2)) System.err.println("ERROR");
		} while ((n != 1) && (n != 2));
		
		System.out.println();
		
		if (n == 1) {
			System.out.println("Modo 1 jugador elegido\n\n");
			return false;
		}
		else {
			System.out.println("Modo 2 jugadores elegido\n\n");
			return true;
		}
	}
	
	public boolean elegirTurno(int cont, boolean turno) {
				
		if (cont == 0) {
			
			int n = (int)((Math.random()*10)+1);

			if (n <= 5) turno = false;
			else turno = true;
		}
		else turno = (!turno);
		
		if (turno) System.out.println("\n\n\n\n\nTurno del Jugador 2 (O)");
		else System.out.println("\n\n\n\n\nTurno del Jugador 1 (X)");
		
		return turno;
	}
	
	public void ponerMarca (char[][] juego, boolean[][] posocupada, boolean turno) {
		
		int fila, col;
		char c;
				
		if (turno) c = 'O';
		else c = 'X';

		System.out.println("\nIntroduce fila y columna para marcar (1 a 3)");

		do {
			fila = sc.nextInt();
			col = sc.nextInt();
			if ((fila < 1) || (fila > 3) || (col < 1) || (col > 3) || (posocupada[fila-1][col-1])) System.err.println("ERROR. Posición no permitida u ocupada");
		} while ((fila < 1) || (fila > 3) || (col < 1) || (col > 3) || (posocupada[fila-1][col-1]));
		
		posocupada[fila-1][col-1] = true;
		juego[fila-1][col-1] = c;
	}
	
	public void copiar (char[][] juego, char[][] aux) {
		
		for (int i = 0;i < juego.length;i++) {
			for (int j = 0;j < juego[i].length;j++) {
				aux[i][j] = juego[i][j];
			}
		}
	}
	
	public void trasponer (char[][] juego, char[][] aux) {
		
		copiar(juego, aux);
		
		for (int i = 0;i < juego.length;i++) {
			for (int j = 0;j < juego[i].length;j++) {
				juego[i][j] = aux[j][i];
			}
		}
	}
	
	public boolean ganadorFila (char[][] juego, boolean fin, int cont1, int cont2) {
		
		for (int i = 0;i < juego.length;i++) {			//comprueba si algún jugador hace 3 en raya en cada fila 
			for (int j = 0;j < juego[i].length;j++) {
				if (juego[i][j] == 'X') cont1++;
				else if (juego[i][j] == 'O') cont2++;
			}
			if (cont1 == 3 && !fin) {
				System.out.println("\n\n\n¡Jugador 1 (X) gana la partida!");
				fin = true;
			}
			else if (cont2 == 3 && !fin) {
				System.out.println("\n\n\n¡Jugador 2 (O) gana la partida!");
				fin = true;
			}
			else {
				cont1 = 0;
				cont2 = 0;
			}
		}
		
		return fin;
	}

	public boolean ganadorDiagPrin (char[][] juego, boolean fin, int cont1, int cont2) {
		
		for (int i = 0;i < juego.length;i++) {				//comprueba si existe 3 en raya en la diagonal principal
			if (juego[i][i] == 'X') cont1++;
			else if (juego[i][i] == 'O') cont2++;
		}
		
		if (cont1 == 3) {
			System.out.println("\n\n\n¡Jugador 1 (X) gana la partida!");
			fin = true;
		}
		else if (cont2 == 3) {
			System.out.println("\n\n\n¡Jugador 2 (O) gana la partida!");
			fin = true;
		}
		
		return fin;
	}
	
	public boolean ganadorDiagInv (char[][] juego, boolean fin, int cont1, int cont2) {
		
		for (int i = 0;i < juego.length;i++) {				//comprueba si existe 3 en raya en la diagonal inversa
			if (juego[i][juego.length - i - 1] == 'X') cont1++;
			else if (juego[i][juego.length - i - 1] == 'O') cont2++;
		}
		
		if (cont1 == 3) {
			System.out.println("\n\n\n¡Jugador 1 (X) gana la partida!");
			fin = true;
		}
		else if (cont2 == 3) {
			System.out.println("\n\n\n¡Jugador 2 (O) gana la partida!");
			fin = true;
		}

		return fin;
	}
	
	public boolean ganador (char[][] juego, char[][] aux, boolean fin) {
		
		int cont1 = 0;
		int cont2 = 0;
		
		if (!fin) {
			fin = ganadorFila(juego, fin, cont1, cont2);
		}
		
		if (!fin) {
			trasponer(juego, aux);				
			fin = ganadorFila(juego, fin, cont1, cont2);		//al trasponer la matriz, comprueba si algún jugador hace 3 en raya en cada columna
			trasponer(juego, aux);
		}
		
		if (!fin) {
			fin = ganadorDiagPrin(juego, fin, cont1, cont2);
		}
		
		if (!fin) {
			fin = ganadorDiagInv(juego, fin, cont1, cont2);
		}

		return fin;
	}
	
}