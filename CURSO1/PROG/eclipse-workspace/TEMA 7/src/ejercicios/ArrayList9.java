package ejercicios;

import java.util.*;

public class ArrayList9 {
	
	
	//ATRIBUTOS
	
	private int fila;
	private int col;
	private ArrayList<Integer>[] m = new ArrayList[this.fila];
	
	
	//CONSTRUCTORES
	
	public ArrayList9(int fila, int col) {
		this.fila = fila;
		this.col = col;
		
		int[][] valores = new int[fila][col];
		
		for (int i = 0; i < valores.length; i++) {			
			for (int j = 0; j < valores[i].length; j++) {
				valores[i][j] = 0;
			}
		}
		
		inicializar(valores);
	}
	
	public ArrayList9(int fila, int col, int[][] valores) {
		this.fila = fila;
		this.col = col;
		
		inicializar(valores);
	}
	
	
	//GETTERS & SETTERS
	
	public void setElemento(int i, int j, int elem) {
		m[i].set(j, elem);
	}
	
	public int getElemento(int i, int j) {
		return (m[i].get(j));
	}

	
	//MÉTODOS

	private void inicializar(int[][] valores) {
		
		for (int i = 0; i < this.m.length; i++) {
			m[i] = new ArrayList<Integer>();
			for (int j = 0; j < this.m[i].size(); j++) {
				m[i].add(j, valores[i][j]); 
			}
		}
	}
	
	public void espejo(ArrayList<Integer>[] m) {
		
		for (int i = 0; i < this.m.length; i++) {
			Collections.reverse(m[i]);
		}
	}
	
	public void transponer(ArrayList<Integer>[] m) {
		
	}
	
	public void imprimir() {
		
		for (int i = 0; i < this.m.length; i++) {
			System.out.println();
			for (int j = 0; j < this.m[i].size(); j++) {
				System.out.print(m[i].get(j)+" ");
			}
		}
	}
}