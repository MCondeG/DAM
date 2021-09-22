package pack;

public class Operacion {
	
	public void inicializar (int[] posiciones) {	//inicia el vector de posiciones a un valor controlado
		
		for (int i = 0;i < posiciones.length;i++) {
			posiciones[i] = -99;
		}
	}

	public String elegir (String[] palabra, String palEleg) {	//elegir palabra aleatoria
		
		int n = (int)(Math.random()*20);
		
		palEleg = palabra[n];
		
		return palEleg;
	}
	
	public boolean comparar (String palEleg, char letra, int[] posiciones, boolean acierto) {
					//compara la letra introducida con la palabra elegida y guarda los aciertos en vector de posiciones
		int pos = -1;
		int cont = 0;
		
		do {
			pos = palEleg.indexOf(letra, pos+1);
			if (pos != -1) {
				posiciones[cont] = pos;
				cont++;
				acierto = true;
			}
		} while (pos != -1);
		
		return acierto;
	}
	
	public void cambiar (int[] posiciones, char[] guion2, char letra) {		//cambia los guiones por letras
		
		int i = 0;
		
		while (posiciones[i] != -99) {
				guion2[posiciones[i]] = letra;
				i++;
		}
	}
	
	public boolean comprobar (char[] guion2, boolean victoria) {	//control de victoria
		
		victoria = true;
		
		for (int i = 0;i < guion2.length;i++) {
			if (guion2[i] == '_') victoria = false;
		}
		
		return victoria;
	}
	
	public int pista (char[] guion2, String palEleg) {		//da una letra al azar
		
		int pos;
		
		do {
			pos = (int)(Math.random()*(guion2.length));
		} while (guion2[pos] != '_');
		
		guion2[pos] = palEleg.charAt(pos);
		
		return 1;
	}
}
