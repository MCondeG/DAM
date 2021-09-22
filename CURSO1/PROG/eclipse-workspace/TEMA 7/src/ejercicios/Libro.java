package ejercicios;

public class Libro {

	private String signatura;
	private String titulo;
	private String editorial;
	private Integer a�o;
	private String autor;
	private String isbn;
	private double precio;
	
	
	public Libro() {
		
	}
	
	public Libro(String signatura, String titulo, String editorial, Integer a�o, String autor, String isbn, double precio) {
		
		this.signatura = signatura;
		this.titulo = titulo;
		this.editorial = editorial;
		this.a�o = a�o;
		this.autor = autor;
		this.isbn = isbn;
		this.precio = precio;
	}

	
	public String getSignatura() {
		return signatura;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getEditorial() {
		return editorial;
	}

	public Integer getA�o() {
		return a�o;
	}

	public String getAutor() {
		return autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public double getPrecio() {
		return precio;
	}

	public void setSignatura(String signatura) {
		this.signatura = signatura;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public void setA�o(Integer a�o) {
		this.a�o = a�o;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	
	@Override
	public String toString() {
		
		return "Libro [signatura = " + signatura + ", titulo = " + titulo + ", editorial = " + editorial + ", a�o = " + a�o
				+ ", autor = " + autor + ", ISBN = " + isbn + ", precio = " + precio + "�]";
	}
}