package ejercicios;

import java.util.*;

public class ListaCartas {

	private ArrayList<Carta> a = new ArrayList<Carta>();
	private static int tama�o = 10;
	
	
	public ListaCartas() {
		
		creaLista(this.a);
	}


	public ArrayList<Carta> getA() {
		return a;
	}

	public int getTama�o() {
		return tama�o;
	}

	public void setA(ArrayList<Carta> a) {
		this.a = a;
	}

	
	public static void creaLista(ArrayList<Carta> a) {
		
		boolean repe;
		
		for (int i = 0; i < tama�o; i++) {
			
			repe = false;
			Carta c = new Carta();
			
			if (i > 0) {
				
				for (int j = 0; j < i; j++) {
					
					if (c.getNumero().compareTo(a.get(j).getNumero()) == 0 && c.getPalo().compareTo(a.get(j).getPalo()) == 0) repe = true;
				}
			}
			
			if (!repe) a.add(c);
			else i--;
		}
		
		
	}
	
	public void ordenar() {
		
		Collections.sort(this.a, new ComparadorCartas());
	}
	
	public void listar() {
		
		for (Carta c: a) {
			
			System.out.println(c);
		}
	}
}