package ejercicios;

import java.util.*;

public class PrincipalEmpleadoCollections {
	
	static int indice = 1;

	public static void main(String[] args) throws InterruptedException {

		ListaEmpleado le = new ListaEmpleado();
		ListaEmpleado leAux = new ListaEmpleado();
		
		
		titulo();
		
		prueba("ordenaci�n");
		ordenar(le);
		
		prueba("inversi�n");
		invertir(le);
		
		prueba("b�squeda");
		buscar(le);
		
		prueba("copiado");
		copiar(le, leAux);
		
		prueba("rellenado");
		rellenar(leAux);
		
		prueba("m�ximos y m�nimos");
		maxMin(le);
		
		prueba("constantes");
		constantes(le);
		
	}
	
	
	public static void ordenar(ListaEmpleado le) {
		
		System.out.println("- Lista ordenada seg�n apellido");
		le.orden();
		le.listar(0);
		
		System.out.println("\n\n- Lista ordenada seg�n edad");
		le.orden(new ComparadorEmpleadoEdad());
		le.listar(0);
	}
	
	public static void invertir(ListaEmpleado le) {
		
		System.out.println("- Lista invertida");
		le.invierte();
		le.listar(0);
	}
	
	public static void buscar(ListaEmpleado le) {
		
		Empleado e1 = new Empleado(le.getA().get((int)(Math.random()*10)));
		Empleado e2 = new Empleado("Pepe", "P�rez", 100);
		int pos;
		
		System.out.println("- Lista ordenada seg�n apellido:\n");
		le.orden();
		pos = le.busca(e1);
		System.out.println("Empleado: "+e1+". Encontrado en posici�n: "+pos+"\n");
		
		pos = le.busca(e2);
		System.out.println("Empleado "+e2+". No encontrado. Si existiera se encontrar�a en posici�n: "+(-pos));
		
		
		ComparadorEmpleadoEdad comp = new ComparadorEmpleadoEdad();
		
		System.out.println("\n\n- Lista ordenada seg�n edad:\n");
		le.orden(comp);
		pos = le.busca(e1, comp);
		System.out.println("Empleado: "+e1+". Encontrado en posici�n: "+pos+"\n");
		
		pos = le.busca(e2, comp);
		System.out.println("Empleado "+e2+". No encontrado. Si existiera se encontrar�a en posici�n: "+(-pos));
	}
	
	public static void copiar(ListaEmpleado le, ListaEmpleado leAux) {
		
		le.copia(leAux);
		
		System.out.println("- Lista copiada");
		leAux.listar(0);
	}
	
	public static void rellenar(ListaEmpleado leAux) {
		
		System.out.println("- Lista rellena con el empleado del mes");
		leAux.rellena();
		leAux.listar(0);
	}
	
	public static void maxMin(ListaEmpleado le) {
		
		Empleado e = new Empleado();
		
		e = le.minimo();
		System.out.println("- M�nimo con lista ordenada seg�n apellido: "+e);
		
		e = le.maximo();
		System.out.println("\n- M�ximo con lista ordenada seg�n apellido: "+e);
		
		
		ComparadorEmpleadoEdad comp = new ComparadorEmpleadoEdad();
		
		e = le.minimo(comp);
		System.out.println("\n\n- M�nimo con lista ordenada seg�n edad: "+e);
		
		e = le.maximo(comp);
		System.out.println("\n- M�ximo con lista ordenada seg�n edad: "+e);
		
	}
	
	public static void constantes(ListaEmpleado le) {
		
		final List l = le.listaVacia();
		System.out.println("- Lista vac�a constante creada\n");
		
		final Set s = le.conjuntoVacio();
		System.out.println("- Conjunto vac�o constante creado\n");
		
		final Map m = le.mapaVacio();
		System.out.println("- Mapa vac�o constante creado\n");
	}
	
	
	public static void titulo() throws InterruptedException {
		
		System.out.println();
		System.out.println("                          +---------------------------------------------+");
		System.out.println("                          |  PRUEBA DE M�TODOS DE LA CLASE COLLECTIONS  |");
		System.out.println("                          +---------------------------------------------+\n");
		
		Thread.sleep(3000);
	}
	
	public static void prueba(String s) throws InterruptedException {
		
		System.out.println("\n\n");
		System.out.print(indice+". Probando m�todos de "+s);
		
		for (int i = 0; i < 3; i++) {
			Thread.sleep(500);
			System.out.print(".");
			Thread.sleep(500);
		}
		
		System.out.println("\n\n");
		
		indice++;
	}
}