package ejercicios;

import java.util.Comparator;

public class ComparadorLibroA�o implements Comparator<Libro> {

	@Override
	public int compare(Libro l1, Libro l2) {
		
		return (l1.getA�o().compareTo(l2.getA�o()));
	}
}