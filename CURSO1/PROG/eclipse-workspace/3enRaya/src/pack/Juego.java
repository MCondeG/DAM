package pack;

public class Juego {

	public static void main(String[] args) throws InterruptedException {
		// TODO Apéndice de método generado automáticamente

		Tablero t = new Tablero();
		Operacion o = new Operacion();
		IA ia = new IA();
		
		int cont = 0;										//contador de turnos
		int[] pos = new int[2];								//vector para guardar las posiciones elegidas de la IA
		char[][] tab = new char[5][5];						//matriz para guardar el tablero de juego con formato
		char[][] juego = new char[3][3];					//matriz para guardar los caracteres X ó O
		char[][] aux = new char[3][3];						//matriz auxiliar para trasponer
		boolean[][] posocupada = new boolean[3][3];			//false para posicion libre, true para ocupada
		
		boolean modo;    		  							//false para 1 jugador, true para 2 jugadores
		boolean turno = false;								//false para turno jugador 1, true para jugador 2
		boolean fin = false;								//true para terminar el juego

		
		System.out.println(" 3 EN RAYA");
		System.out.println("___________\n\n\n");
		
		t.inicializar(tab);
		t.pintar(tab);
		
		Thread.sleep(2000);
		
		System.out.println("\n\n\n\n");
		
		modo = o.elegirModo();
		
		if (modo) {			//2 jugadores
			
			System.out.println("Jugador 1 juega con X");
			System.out.println("Jugador 2 juega con O");
			System.out.println();
			
			do {
				
				turno = o.elegirTurno(cont, turno);
				o.ponerMarca(juego, posocupada, turno);
				t.actualizar(juego, tab);
				t.pintar(tab);
				fin = o.ganador(juego, aux, fin);
				
				cont++;
				
				if (cont == 9 && !fin) {
					System.out.println("\n\n\n\t¡Empate!");
					fin = true; 
				}
				
			} while (!fin);
			
		}
		else {				//1 jugador
			
			System.out.println("Eres el jugador 1, juegas con X");
			System.out.println("Tu rival juega con O. ¡Buena suerte!");
			
			do {
				
				turno = o.elegirTurno(cont, turno);
				if (turno) {
					Thread.sleep(1000);
					ia.decisionIA(juego, aux, posocupada, pos);
				}
				else o.ponerMarca(juego, posocupada, turno);
				t.actualizar(juego, tab);
				t.pintar(tab);
				fin = o.ganador(juego, aux, fin);
				
				cont++;
				
				if (cont == 9 && !fin) {
					System.out.println("\n\n\n\t¡Empate!");
					fin = true; 
				}
				
			} while (!fin);
		}
	}
}