package ejercicios;

import java.util.*;

public class ListaPersona {

	private ArrayList<Persona> a = new ArrayList<Persona>();
	private static int tama�o = 10;
	
	
	public ListaPersona() {
		
		creaLista(this.a);
	}
	
	
	public static void creaLista(ArrayList<Persona> a) {
		
		for (int i = 0; i < tama�o; i++) {
			a.add(new Persona());
		}
	}
	
	public void ordenApell() {
		
		Collections.sort(this.a);
		
		/* MODIFICACI�N PARA ORDENAR POR APELLIDO Y NOMBRE
		 * 
		 * 
		 Collections.sort(this.a, new ComparadorPersonaEdad());
		 *
		 *
		 */
	}
	
	public void ordenEdad() {
		
		Collections.sort(this.a, new ComparadorPersonaEdad());
	}
	
	public void listar() {
		
		for (int i = 0; i < tama�o; i++) {
			System.out.println(this.a.get(i));
		}
		System.out.println("\n\n");
	}
}