package ejercicios;

import java.util.Comparator;

public class ComparadorLibroAņo implements Comparator<Libro> {

	@Override
	public int compare(Libro l1, Libro l2) {
		
		return (l1.getAņo().compareTo(l2.getAņo()));
	}
}