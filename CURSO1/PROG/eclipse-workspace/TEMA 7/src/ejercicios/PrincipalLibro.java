package ejercicios;

public class PrincipalLibro {

	public static void main(String[] args) {

		ListaLibros ll = new ListaLibros();
		
		ll.insertar(new Libro("111TOLseñ", "El Señor de los Anillos", "Ediciones Minotauro", 1954, "J. R. R. Tolkien", "11111", 29.95));
		ll.insertar(new Libro("111CERqui", "El Quijote", "Francisco de Robles", 1605, "Miguel de Cervante Saavedra", "22222", 29.95));
		ll.insertar(new Libro("111ROWhar", "Harry Potter y la Piedra Filosofal", "Salamandra", 1997, "J. K. Rowling", "33333", 19.95));
		ll.insertar(new Libro("111HUXmun", "Un Mundo Feliz", "DEBOLSILLO", 1932, "Aldous Huxley", "44444", 19.95));
		ll.insertar(new Libro("111CARjue", "El Juego de Ender", "Tor Books", 1985, "Orson Scott Card", "55555", 15.00));
		
		ll.ordenAño();
		
		ll.listar();
	}
}