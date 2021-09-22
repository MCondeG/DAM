package ejercicios;

import java.util.Scanner;

public class ConjLibro {
	
	Libros [] conjL = new Libros [10];
	int nElementos = 0;
	static Scanner sc = new Scanner (System.in);
	
	ConjLibro () {
			
	}
	
	ConjLibro (Libros [] conjuntoL, int nEl) {
		
		this.conjL = conjuntoL;
		this.nElementos = nEl;
		
	}

	public Libros[] getConjL() {
		return conjL;
	}

	public void setConjL(Libros[] conjL) {
		this.conjL = conjL;
	}

	public int getnElementos() {
		return nElementos;
	}

	public void setnElementos(int nElementos) {
		this.nElementos = nElementos;
	}
	
	
	public void insertar (Libros libro) {
		
		if (nElementos >= 10) System.out.println("Está completo");
		else {
			if (buscar(libro.getCodigo()) == true) System.out.println("Este código ya existe");
	
			else {
				
				if (nElementos == 0) {
					
					conjL [nElementos] = libro;
					nElementos ++;
					
				}
				
				else {
					
					boolean busca = false;
					
					for (int i = 0; i < nElementos && busca == false; i ++) {
						
						if (libro.getCodigo() < conjL[i].getCodigo()) {
							
							nElementos ++;
							
							for (int j = nElementos; j > i; j --) {
								
								conjL[i] = conjL [j-1];
								
							}
							
							conjL[i] = libro;
							busca = true;
							
						}
						
					}
					
					if (busca == false) {
						
						nElementos ++;
						conjL[nElementos - 1] = libro;
						
					}
					
				}
				
			}
		
		}
		
	}
	
	public void eliminar (int s) {
		
		for (int i = 0; i < nElementos; i ++) {
			
			if (conjL[i].getCodigo() == s) {
				
				for (int j = i; j < nElementos; j ++) {
					
					conjL [j] = conjL [j+1];
					
				}
				
				nElementos --;
				
			}
			
		}
		
	}
	
	public void consultarLibro (int r) {
		
		System.out.println("Intoduce el código del libro a consultar: ");
		r = sc.nextInt();
		
		for (int i = 0; i < nElementos; i ++) {
			
			if (conjL[i].getCodigo() == r) {
			
			System.out.println("Libro " + i +": " +conjL[i].toString());
			
			}
			
		}
		
	}
	
	public boolean buscar (int x) {
		
		boolean busqueda = false;
		
		for (int i = 0; i < nElementos && busqueda == false; i ++)
		
		if (conjL[i].getCodigo() == x) {
			
			busqueda = true;
			
		}
		
		return busqueda;
		
	}
	
	public void listar () { 
		
		for (int i = 0; i < nElementos; i ++) {
			
			System.out.println("Libro " + i +": " +conjL[i].toString());
			
		}
			
	}
		
}
