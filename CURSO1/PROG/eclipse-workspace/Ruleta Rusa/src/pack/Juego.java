package pack;

public class Juego {
		
	
	//ATRIBUTOS
	
	ConjJugador jugadores = new ConjJugador();
	Revolver r = new Revolver();
	
	private static int turno = 1;
	
	
	//CONSTRUCTOR
	
	public Juego() {
		
	}
	
	
	//GETTERS & SETTERS
	
	public static int getTurno() {
		return turno;
	}

	
	//MÉTODOS

	public void actualizaTurno() {
		
		if (turno == jugadores.getNumJug()) Juego.turno = 1;
		else Juego.turno++;
	}
	
	public boolean comprobarVivo() {
		
		return (jugadores.accederJugador(turno-1).isVivo());
	}
	
	public void cargarJuego() throws InterruptedException {
		
		System.out.println();
		System.out.println(" BIENVENIDO A LA RULETA RUSA");
		System.out.println("_____________________________");
		
		Thread.sleep(1000);
		
		System.out.println("\n\n\nBuena suerte, ¡lo pasarás de muerte!\n\n");
		
		Thread.sleep(1000);
		
		jugadores.setNumJug();
		jugadores.introducirJugadores();
	}
	
	public void jugar() throws InterruptedException {
		
		System.out.println("\n\n");
		System.out.print("Turno del "+jugadores.accederJugador(turno-1)+"...apunta el revolver y");
		
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(700);
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print(".");
		System.out.println("\n(pulsa ENTER para apretar el gatillo)");
		
		System.out.println();
			
		jugadores.accederJugador(turno-1).disparar(r);
			
		if (comprobarVivo()) {
			System.out.println("La bala no se encuentra ahí, el "+jugadores.accederJugador(turno-1)+" respira aliviado");
			System.out.println("El juego continúa");
			actualizaTurno();
		}
		else {
			System.out.println();
			System.out.println();
			System.err.println("¡¡¡BANG!!!");
			System.out.println("...El "+jugadores.accederJugador(turno-1)+" se dispara en la cabeza");
			System.out.println("\n        FIN DEL JUEGO");
		}
	}
}