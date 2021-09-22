package ejercicios;

import java.util.*;

public class Cadena {
	
	private String c;
	
	
	public Cadena() {
		
	}
	
	public Cadena(String c) {
		this.c = c;
	}

	
	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}
	
	
	public void apilar(LinkedList<Cadena> pila, Cadena cad) {
		
		pila.addFirst(cad);
	}
	
	public void desapilar(LinkedList<Cadena> pila) {
		
		pila.remove(0);
	}
	
	public void cima(LinkedList<Cadena> pila) {
		
		System.out.println(pila.peekFirst().getC());
	}
	
	public void listar(LinkedList<Cadena> pila) {
		
		for (int i = 0; i < pila.size(); i ++) {
			System.out.println(pila.get(i).getC());
		}
	}
}