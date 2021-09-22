package pack;

import java.util.Scanner;

public class Jugador {
	
	
	//ATRIBUTOS
	
	static Scanner sc = new Scanner(System.in);
	
	private static final String nombre = "Jugador";
	private int id;
	private boolean vivo;
	
	
	//CONSTRUCTOR
	
	public Jugador() {
		
	}
	
	public Jugador(int id, boolean vivo) {
		this.id = id;
		this.vivo = vivo;
	}
	
	
	//GETTERS & SETTERS

	public static String getNombre() {
		return nombre;
	}

	public int getId() {
		return id;
	}

	public boolean isVivo() {
		return vivo;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	
	
	//MÉTODOS
	
	@Override
	public String toString() {
		
		return (Jugador.nombre+" "+this.id);
	}
	
	public void disparar(Revolver r) {
		
		sc.nextLine();
		if (r.disparar()) this.vivo = false; 
	}
}