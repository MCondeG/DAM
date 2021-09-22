package pack;

import java.util.Scanner;

public class ConjJugador {
	
	
	//ATRIBUTOS
	
	static Scanner sc = new Scanner(System.in);
	
	private int numJug = 9;
	private Jugador[] conj = new Jugador[numJug];
	
	
	//CONSTRUCTOR
	
	public ConjJugador() {
		
	}
	
	public ConjJugador(Jugador[] conj) {
		this.conj = conj;
	}
	
	public ConjJugador(int numJug, Jugador[] conj) {
		this.numJug = numJug;
		this.conj = conj;
	}
	
	
	//GETTERS & SETTERS

	public int getNumJug() {
		return numJug;
	}

	public Jugador[] getConj() {
		return conj;
	}

	public void setNumJug() {
		
		int n;
		
		do {
			System.out.println("¿Cuantos jugadores participan? (por defecto 9)");
			n = sc.nextInt();
			if (n < 2 || n > 9) System.err.println("ERROR. Mínimo 2 jugadores y máximo 9");
			else this.numJug = n;
		} while (n < 2 || n > 9);
	}

	public void setConj(Jugador[] conj) {
		this.conj = conj;
	}
	
	
	//MÉTODOS
	
	public Jugador accederJugador(int n) {
		
		return this.conj[n];
	}
	
	public void introducirJugadores() {
		
		for (int i = 1; i <= numJug; i++) {
			Jugador j = new Jugador(i, true);
			this.conj[i-1] = j;
		}
	}
}