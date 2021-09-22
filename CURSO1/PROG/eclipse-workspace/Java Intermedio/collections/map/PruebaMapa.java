package map;

import java.util.*;

public class PruebaMapa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Integer, Persona> mapaPersonas = new HashMap<Integer, Persona>();
		
		Persona p0 = new Persona();
		Persona p1 = new Persona();
		Persona p2 = new Persona();
		Persona p3 = new Persona();
		Persona p4 = new Persona();

		
		mapaPersonas.put(0, p0);
		mapaPersonas.put(1, p1);
		mapaPersonas.put(4, p4);
		mapaPersonas.put(3, p3);
		mapaPersonas.put(2, p2);


		Set<Integer> conjuntoClaves = mapaPersonas.keySet();	//se crea un set con las claves de nuestro mapa
		Iterator<Integer> it = conjuntoClaves.iterator();
		
		while (it.hasNext()) {
			
			Integer clave = it.next();
			
			System.out.println("CLAVE: "+clave);
		}
		
		System.out.println("\n");
		System.out.println("MAPA PERSONAS:\n"+mapaPersonas);
		
		System.out.println("\n");
		System.out.println("Existe la clave 3? "+mapaPersonas.containsKey(3));
		System.out.println("Existe la persona usuario2? "+mapaPersonas.containsValue(p2));
	}
}