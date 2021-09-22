package ejercicios;

import java.util.*;

public class ComparadorPersonaEdad implements Comparator<Persona> {

	@Override
	public int compare(Persona p1, Persona p2) {
		
		return (p1.getEdad().compareTo(p2.getEdad()));
	}
	
	
	/* MODIFICACIÓN PARA ORDENAR POR APELLIDO Y NOMBRE
	 * 
	 * 
	@Override
	public int compare(Persona p1, Persona p2) {
	
		int comparador = p1.getApellido().compareTo(p2.getApellido());
		
		if (comparador == 0) comparador = p1.getNombre().compareTo(p2.getNombre());
		
		return (comparador);
	}
	 *
	 *
	 */
}