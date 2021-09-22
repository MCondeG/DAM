package ejemplos;

public class Libro {

		//atributos
	
	private String isbn;
	private String titulo;
	private String autor;
	private int numeroPaginas;
	private double precio;
	private int numeroEjemplares;
	
		//Constructor
	
	Libro (String isbn, String titulo, String autor, int numeroPaginas, double precio, int numeroEjemplares) {
		
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.numeroPaginas = numeroPaginas;
		this.precio = precio;
		this.numeroEjemplares = numeroEjemplares;
	}
	
		//Constructor vacío
	
	Libro () {
		
	}
	
		//setters y getters
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getNumeroEjemplares() {
		return numeroEjemplares;
	}

	public void setNumeroEjemplares(int numeroEjemplares) {
		this.numeroEjemplares = numeroEjemplares;
	}

	
	
		//Métodos
	
	public void comprarLibro () {
		this.numeroEjemplares++;
	}
	
	public void venderLibro () {
		
		if (this.numeroEjemplares > 0) this.numeroEjemplares--;
		else System.out.println("No hay ejemplares disponibles");
	}
}