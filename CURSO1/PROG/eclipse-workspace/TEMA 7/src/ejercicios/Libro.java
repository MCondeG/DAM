package ejercicios;

public class Libro {

	private String signatura;
	private String titulo;
	private String editorial;
	private Integer año;
	private String autor;
	private String isbn;
	private double precio;
	
	
	public Libro() {
		
	}
	
	public Libro(String signatura, String titulo, String editorial, Integer año, String autor, String isbn, double precio) {
		
		this.signatura = signatura;
		this.titulo = titulo;
		this.editorial = editorial;
		this.año = año;
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

	public Integer getAño() {
		return año;
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

	public void setAño(Integer año) {
		this.año = año;
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
		
		return "Libro [signatura = " + signatura + ", titulo = " + titulo + ", editorial = " + editorial + ", año = " + año
				+ ", autor = " + autor + ", ISBN = " + isbn + ", precio = " + precio + "€]";
	}
}