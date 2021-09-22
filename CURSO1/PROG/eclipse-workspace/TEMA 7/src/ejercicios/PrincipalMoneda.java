package ejercicios;

import java.util.*;

public class PrincipalMoneda {

	public static void main(String[] args) {
		
		ArrayList<Moneda> mlista = new ArrayList<Moneda>();
		
		int i = 0;
		
		do {
			i = generaMoneda(mlista, i);
		} while (i < 6);
		
		for (Moneda mon: mlista) {
			System.out.println(mon);
		}	
	}
	
	public static int generaMoneda(ArrayList<Moneda> mlista, int i) {
		
		Moneda m = new Moneda();
		String cant;
		String pos;
		
		if (i == 0) {
			mlista.add(m);
			i++;
		}
		else {
			cant = mlista.get(i-1).getCantidad();
			pos = mlista.get(i-1).getPosicion();
			
			if (pos.compareTo(m.getPosicion()) == 0 || cant.compareTo(m.getCantidad()) == 0) {
				mlista.add(m);
				i++;
			}
		}
		
		return i;
	}
}