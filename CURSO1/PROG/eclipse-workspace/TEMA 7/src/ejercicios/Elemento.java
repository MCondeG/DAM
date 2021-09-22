package ejercicios;

import java.util.*;

public class Elemento {
	
	private int e;
	
	
	public Elemento() {

	}
	
	public Elemento(int e) {
		this.e = e;
	}
	
	public Elemento(Elemento e) {
		this.e = e.getE();
	}
	
	public Elemento(boolean p) {
		
		if (p) this.e = (int)(Math.random()*10);
		else this.e = 0;
	}

	
	public int getE() {
		return e;
	}

	public void setE(int e) {
		this.e = e;
	}
	
	
	public void encolar(LinkedList<Elemento> cola, Elemento elem) {
		
		cola.addFirst(elem);
	}
	
	public void desencolar(LinkedList<Elemento> cola) {
		
		cola.remove(cola.size() - 1);
	}
	
	public void listar(LinkedList<Elemento> cola) {
		
		for (int i = 0; i < cola.size(); i ++) {
			System.out.println(cola.get(i).getE());
		}
	}
}