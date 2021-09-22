package ejercicios;

import java.util.*;

public class ListaEmpleado {

	private ArrayList<Empleado> a = new ArrayList<Empleado>();
	private static int tama�o = 10;
	
	
	
	public ListaEmpleado() {
		
		creaLista(this.a);
	}
	
	
	
	public ArrayList<Empleado> getA() {
		return a;
	}

	public int getTama�o() {
		return tama�o;
	}

	public void setA(ArrayList<Empleado> a) {
		this.a = a;
	}

	
	
	//******************** M�TODOS MODIFICACI�N LISTA ********************

	public static void creaLista(ArrayList<Empleado> a) {
		
		for (int i = 0; i < tama�o; i++) {
			a.add(new Empleado());
		}
	}
	
	public void insertar(int i, Empleado e) {
		
		this.a.add(i, e);
		tama�o++;
		
		listar(0);
	}
	
	
	
	//******************** M�TODOS ITERATOR ********************
	
	public static Iterator<Empleado> creaIterator(ArrayList<Empleado> a) {
		
		Iterator<Empleado> it = a.iterator();
		
		return it;
	}
	
	public void listar() {
		
		Iterator<Empleado> it = creaIterator(this.a);
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public void eliminarVocal() {
		
		Iterator<Empleado> it = creaIterator(this.a);
		
		char c;
		
		while (it.hasNext()) {
			
			c = it.next().getNombre().charAt(0);
			if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') it.remove();
		}
	}
	
	
	
	//******************** M�TODOS LISTITERATOR ********************
	
	public static ListIterator<Empleado> creaListIterator(ArrayList<Empleado> a, int i) {
		
		ListIterator<Empleado> lit = a.listIterator(i);
		
		return lit;
	}
	
	public void listar(int i) {
	
		ListIterator<Empleado> lit = creaListIterator(this.a, i);
		
		System.out.println();
		
		while (lit.hasNext()) {
			System.out.println(lit.next());
		}
	}
	
	public void listaInversa(int i) {
		
		ListIterator<Empleado> lit = creaListIterator(this.a, i);
		
		System.out.println("\n");
		System.out.println("Lista inversa:\n");
		
		while (lit.hasPrevious()) {
			System.out.println(lit.previous());
		}
	}
	
	public void modificar(int i) {
		
		ListIterator<Empleado> lit = a.listIterator(i);
		
		Empleado e = new Empleado("Teresa", "G�mez G�mez", 32);
		
		if (lit.hasNext()){
			lit.next();
			lit.set(e);
		}
		
		listar(0);
	}
	
	
	
	//******************** M�TODOS ORDENACI�N ********************
	
	public void orden() {
		
		Collections.sort(this.a);	
	}
	
	public void orden(ComparadorEmpleadoEdad comp) {
		
		Collections.sort(this.a, comp);
	}
	
	
	
	//******************** M�TODOS INVERSI�N ********************
	
	public void invierte() {
		
		Collections.reverse(this.a);
	}
	
	
	
	//******************** M�TODOS B�SQUEDA ********************
	
	public int busca(Empleado e) {
		
		return (Collections.binarySearch(this.a, e));
	}
	
	public int busca(Empleado e, ComparadorEmpleadoEdad comp) {
		
		return (Collections.binarySearch(this.a, e, comp));
	}
	
	
	
	//******************** M�TODOS COPIA ********************
	
	public void copia(ListaEmpleado leAux) {
		
		
		Collections.copy(leAux.a, this.a);
	}
	
	
	
	//******************** M�TODOS RELLENO ********************
	
	public void rellena() {

		Collections.fill(this.a, new Empleado("Manuel", "Conde", 32));
	}
	
	
	
	//******************** M�TODOS M�XIMOS Y M�NIMOS ********************

	public Empleado minimo() {
		
		return Collections.min(this.a);
	}
	
	public Empleado minimo(ComparadorEmpleadoEdad comp) {
		
		return Collections.min(this.a, comp);
	}
	
	public Empleado maximo() {
		
		return Collections.max(this.a);
	}
	
	public Empleado maximo(ComparadorEmpleadoEdad comp) {
		
		return Collections.max(this.a, comp);
	}
	
	
	
	//******************** M�TODOS CONSTANTES ********************
	
	public List listaVacia() {
		
		return Collections.EMPTY_LIST;
	}
	
	public Set conjuntoVacio() {
		
		return Collections.EMPTY_SET;
	}
	
	public Map mapaVacio() {
		
		return Collections.EMPTY_MAP;
	}
}