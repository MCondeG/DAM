package ejercicios;

import java.util.Comparator;

public class ComparadorCartas implements Comparator<Carta> {

	@Override
	public int compare(Carta c1, Carta c2) {
		
		int comparador = c1.getRandP().compareTo(c2.getRandP());
		
		if (comparador == 0) comparador = c1.getRandN().compareTo(c2.getRandN());
		
		return (comparador);
	}
}