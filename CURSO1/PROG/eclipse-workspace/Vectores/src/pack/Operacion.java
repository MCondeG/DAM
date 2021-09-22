package pack;

public class Operacion {		//clase con metodos para operar con el vector en su conjunto
	
	public int[] aux = new int[30];
	
	public void contar (int[] n, int nelem) {
			
			System.out.println();
			System.out.println("Hay "+nelem+" elementos en el vector");
			if (nelem == 30) {
				System.out.println("Vector completo");
			}
		}
	
	public void imprimir (int[] n, int nelem) {
		
		for (int i = 0; i < nelem;i++) {
			System.out.print(n[i]+" ");
		}
		
		System.out.println();
		System.out.println("Hay "+nelem+" elementos en el vector");
		if (nelem == 30) {
			System.out.println("Vector completo");
		}
	}
	
	public void copiar (int[] n) {
		
		for (int i = 0;i < n.length;i++) {
			aux[i] = n[i];
		}
	}
	
	public void pruebaordenado (int[] n, int nelem) {
		
		for (int i = 0;i < nelem;i++) {
			n[i] = 1;
		}
	}
	
	public void pruebadesordenado (int[] n, int nelem) {
		
		int nrandom;
		
		for (int i = 0;i < nelem;i++) {
			nrandom = (int)(Math.random()*101);
			n[i] = nrandom;
		}
	}
	
	public void desplazar (int[] n, boolean sentido, int pos, int nelem) {
		
		copiar(n);
		
		if (sentido) {			//desplazar a la derecha
			for (int i = pos;i < nelem-1;i++) {
				n[i+1] = aux[i];
			}
		}
		else {					//desplazar a la izquierda
			for (int i = pos;i < nelem-1;i++) {
				n[i] = aux[i+1];
			}
			
		}
	}
	
	public void burbuja (int[] n, int nelem) {
		
		int numaux;
		
		for (int i = 0;i < nelem;i++) {
			for (int j = 0;j < nelem;j++) {
				if ((j < nelem - 1) && (n[j] > n[j+1])) {
					numaux = n[j];
					n[j] = n[j+1];
					n[j+1] = numaux;
				}
			}
		}
	}
	
	public void insercion (int[] n, int nelem) {
		
		int numaux, j;
		
		for (int i = 0;i < nelem;i++) {
			numaux = n[i];
			j = i-1;
			
			while ((j >= 0) && (n[j] > numaux)) {
				n[j+1] = n[j];
				j--;
			}
			n[j+1] = numaux;
		}
	}

	public void seleccion (int[] n, int nelem) {

		int numaux, min;
		
		for (int i = 0;i < nelem;i++) {
			
			min = i;
			
			for (int j = i;j < nelem;j++) {
				if (n[min] > n[j]) {
					min = j;
				}
				
				numaux = n[i];
				n[i] = n[min];
				n[min] = numaux;
			}
		}
	}
}