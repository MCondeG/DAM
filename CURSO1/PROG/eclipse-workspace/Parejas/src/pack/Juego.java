package pack;

public class Juego {

	public static void main(String[] args) throws InterruptedException {
		
		Tablero t = new Tablero();
		Operacion o = new Operacion();
		
		int size;						//tamaño de la matriz
		int cont = 0;					//contador para letras acertadas
		boolean salir = false;			//controla la salida del programa
		boolean acierto;				//controla el acierto de letras
		boolean victoria = false;		//controla la victoria
		int[] pos1 = new int [2];		//vector para guardar la posición de la primera casilla elegida
		int[] pos2 = new int [2];		//vector para guardar la posición de la segunda casilla elegida

		System.out.println(" JUEGO DE LAS PAREJAS");
		System.out.println("______________________\n\n\n");
		
		size = o.pideDif();
		
		String[][] tab1 = new String[size][size];				//matriz no visible para el usuario donde se ordenan las letras elegidas aleatoriamente
		String[][] tab2 = new String[size][size];				//tablero visible
		boolean[][] posOcupada = new boolean[size][size];		//matriz de posiciones ocupadas
		char[] letra = new char[(size*size)/2];					//vector con la mitad de elementos que el tablero de juego
		
		t.iniciaTableroBlanco(tab1);
		t.iniciaTableroVisual(tab2);
		
		o.crearLetras(letra);
		o.insertarLetras(letra, tab1, size);
		
		System.out.println("\n\nJuega hasta que aciertes todas. Si deseas abandonar, introduce 0 ó un número negativo\n");
		
		do {
			
			Thread.sleep(2000);
			
			t.pintaTablero(tab2);
			o.pidePos(posOcupada, pos1, size);
			
			if (pos1[0] < 0 || pos1[1] < 0) salir = true;
			
			if (!salir) {
				
				Thread.sleep(500);
				
				t.destapar(tab1, tab2, pos1);
				t.pintaTablero(tab2);
				o.pidePos(posOcupada, pos2, size);
			
				if (pos2[0] < 0 || pos2[1] < 0) salir = true;
				
				if (!salir) {
					
					Thread.sleep(500);

					t.destapar(tab1, tab2, pos2);
					t.pintaTablero(tab2);	
	
					acierto = o.comprobarLetra(tab1, pos1, pos2);
					
					if (acierto) {
						cont++;
						System.out.println("\nHAS ACERTADO LA LETRA '"+tab1[pos1[0]][pos1[1]]+"'");
					}
					else {
						t.retapar(tab2, pos1, posOcupada);
						t.retapar(tab2, pos2, posOcupada);
						System.out.println("\nHas fallado, sigue intentándolo");
					}
					
					victoria = o.comprobarVictoria(cont, size);
				}
				else System.out.println("\n\n\n¡Adios!");
			}
			else System.out.println("\n\n\n¡Adios!");
			
			if (victoria) System.out.println("\n\n\n¡ENHORABUENA¡ HAS ACERTADO TODAS LAS PAREJAS");
			
		} while (!salir && !victoria);
	}
}