package ejercicios;

import java.util.*;

public class ComparadorEmpleadoEdad implements Comparator<Empleado> {

	@Override
	public int compare(Empleado e1, Empleado e2) {
		
		Integer edad1 = new Integer(e1.getEdad());
		Integer edad2 = new Integer(e2.getEdad());
		
		return (edad1.compareTo(edad2));
	}
}