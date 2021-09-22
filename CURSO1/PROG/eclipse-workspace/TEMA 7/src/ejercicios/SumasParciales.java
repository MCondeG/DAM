package ejercicios;

public class SumasParciales {

	public static void main(String[] args) {
		
		ListaNumeros ln = new ListaNumeros();
		ListaNumeros sumaParcial = new ListaNumeros(ln.encuentraIguales());
		
		System.out.print("Lista: ");
		ln.listar();
		
		System.out.print("\nSumas parciales: ");
		sumaParcial.listar();
	}
}