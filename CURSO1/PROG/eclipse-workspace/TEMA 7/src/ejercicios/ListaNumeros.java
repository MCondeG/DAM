package ejercicios;

import java.util.*;

public class ListaNumeros {
	
	private ArrayList<Integer> a = new ArrayList<Integer>();
	private static int tamaño = 10;
	
	
	public ListaNumeros() {
		
		creaLista(this.a);
	}
	
	public ListaNumeros(ArrayList<Integer> a) {
		this.a = a;
	}
	
	public ListaNumeros(boolean p) {
		
	}
	
	
	public ArrayList<Integer> getA() {
		return a;
	}
	
	public static int getTamaño() {
		return tamaño;
	}

	public void setA(ArrayList<Integer> a) {
		this.a = a;
	}


	public static void creaLista(ArrayList<Integer> a) {
		
		for (int i = 0; i < tamaño; i++) {
			a.add((int)(Math.random()*9)+1);
		}
	}
	
	public static ListIterator<Integer> creaListIterator(ArrayList<Integer> a, int n) {
		
		ListIterator<Integer> lit = a.listIterator(n);
		
		return lit;
	}
	
	public void listar() {
		
		ListIterator<Integer> it = creaListIterator(this.a, 0);
		
		System.out.print("{");
		while (it.hasNext()) {
			if (it.hasPrevious()) System.out.print(", "+it.next());
			else System.out.print(it.next());
		}
		System.out.println("}");
	}
	
	public ArrayList<Integer> encuentraIguales() {
		
		ArrayList<Integer> num = new ArrayList<Integer>();
		ArrayList<Integer> cantidad = new ArrayList<Integer>();
		ArrayList<Integer> suma = new ArrayList<Integer>();
		
		int cont, n1, n2, sumaCant;
		boolean fin;
		
		for (int i = 0; i < tamaño; i++) {
			
			cont = 1;
			fin = false;
			
			for (int j = i+1; j < tamaño && (!fin); j++) {
				
				n1 = this.a.get(i);
				n2 = this.a.get(j);
					
				if (n1 == n2) cont++;
				else {
					num.add(n1);
					cantidad.add(cont);
					fin = true;
					i += (cont-1);
				}
				
			}
		}
		
		sumaCant = sumaCantidades(cantidad);
		
		num.add(this.a.get(sumaCant));
		cantidad.add(tamaño - sumaCant);
		
		for (int i = 0; i < num.size(); i++) {
			
			suma.add(multiplicaListas(num, cantidad, i));
		}
		
		return suma;
	}
	
	public int sumaCantidades(ArrayList<Integer> cantidad) {
		
		int suma = 0;
		
		for (int i = 0; i < cantidad.size(); i++) {
			
			suma += cantidad.get(i);
		}
		
		return suma;
	}
	
	public static int multiplicaListas(ArrayList<Integer> num, ArrayList<Integer> cantidad, int i) {
		
		return (num.get(i) * cantidad.get(i));
	}
	
	
	public ArrayList<Integer> encuentraSecuencia(int n) {
		
		ArrayList<Integer> subSec = new ArrayList<Integer>();
		
		int n1, n2;
		boolean fin = false;
		
		for (int i = n; i < tamaño  && (!fin); i++) {
			
			n1 = this.a.get(i);
			if (i != (tamaño - 1)) n2 = this.a.get(i+1);
			else n2 = 100;
			
			subSec.add(n1);
			
			if (n1 > n2) fin = true;
		}
		
		return subSec;
	}
}
