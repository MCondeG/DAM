package ejercicios;

public class Publicacion {
	
	private int codigo;
	private String titulo;
	private int a�o;
	
	public Publicacion () {
		super();
	}
	
	public Publicacion (int c, String t, int a) {
		super();
		this.codigo = c;
		this.titulo = t;
		this.a�o = a;
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getA�o() {
		return a�o;
	}

	public void setA�o(int a�o) {
		this.a�o = a�o;
	}


}
