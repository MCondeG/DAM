package ejercicios;

import java.util.Comparator;

public class ComparadorLibroAño implements Comparator<Libro> {

	@Override
	public int compare(Libro l1, Libro l2) {
		
		return (l1.getAño().compareTo(l2.getAño()));
	}
}