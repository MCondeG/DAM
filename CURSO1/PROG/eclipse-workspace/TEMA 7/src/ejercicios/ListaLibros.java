package ejercicios;

import java.util.*;

public class ListaLibros {

	private LinkedList<Libro> a = new LinkedList<Libro>();
	
	
	public ListaLibros() {
		
	}
	
	public ListaLibros(LinkedList<Libro> a) {
		this.a = a;
	}

	
	public LinkedList<Libro> getA() {
		return a;
	}

	public void setA(LinkedList<Libro> a) {
		this.a = a;
	}
	
	
	public void insertar(Libro l) {
		
		this.a.add(l);
	}
	
	public void listar() {
		
		for (Libro libro: a) {
			
			System.out.println(libro);
		}
	}

	public void ordenA�o() {
		
		Collections.sort(this.a, new ComparadorLibroA�o());
	}
}