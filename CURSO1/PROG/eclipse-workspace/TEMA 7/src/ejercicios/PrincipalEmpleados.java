package ejercicios;

import java.util.*;

public class PrincipalEmpleados {

	public static void main(String[] args) {
		
		ArrayList<Empleados> a = new ArrayList<Empleados>();
		
		for (int i = 0; i < 10; i++) {
			creaLista(a);
		}
		
		ListIterator<Empleados> lit = a.listIterator();
		
		System.out.println("- Lista:\n");
		muestraLista(lit);
		System.out.println("\n\n- Lista inversa:\n");
		muestraListaInversa(lit);
	}
	
	public static void creaLista(ArrayList<Empleados> a) {
		
		Empleados e = new Empleados();
		a.add(e);
	}
	
	public static void muestraLista(ListIterator<Empleados> lit) {
		
		while (lit.hasNext()) {
			System.out.println(lit.next());
		}
	}
	
	public static void muestraListaInversa(ListIterator<Empleados> lit) {
		
		while (lit.hasPrevious()) {
			System.out.println(lit.previous());
		}
	}
}