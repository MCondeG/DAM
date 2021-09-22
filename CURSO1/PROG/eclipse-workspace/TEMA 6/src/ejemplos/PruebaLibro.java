package ejemplos;

public class PruebaLibro {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Libro lib = new Libro();
		Libro miLibrito = new Libro();
		Libro quijote = new Libro();
		
	
		quijote.setAutor("Cervantes");
		quijote.setIsbn("sdegfsd");
		quijote.setTitulo("Quijote");
		quijote.setPrecio(19.99);
		quijote.setNumeroPaginas(1000);
		quijote.setNumeroEjemplares(10);
		
		System.out.println(quijote.getNumeroEjemplares());
		
		quijote.comprarLibro();
		
		System.out.println(quijote.getNumeroEjemplares());
		
		quijote.venderLibro();
		
		System.out.println(quijote.getNumeroEjemplares());
	}	
}