package ejercicios;

public class SecuenciasOrdenadas {

	public static void main(String[] args) {

		ListaNumeros ln = new ListaNumeros();
		ConjuntoSecuencias cs = new ConjuntoSecuencias(ln);
		
		System.out.print("Lista: ");
		ln.listar();
		
		System.out.println("\nSecuencias ordenadas");
		cs.listar();
	}
}