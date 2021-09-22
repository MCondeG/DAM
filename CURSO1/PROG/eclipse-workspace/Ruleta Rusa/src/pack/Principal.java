package pack;

public class Principal {

	public static void main(String[] args) throws InterruptedException {

		
		Juego j = new Juego();
		
		
		j.cargarJuego();
		
		do {
			
			j.jugar();
			
		} while (j.comprobarVivo());
	}
}