package ejercicios;

public class Publicacion {
	
	private int codigo;
	private String titulo;
	private int año;
	
	public Publicacion () {
		super();
	}
	
	public Publicacion (int c, String t, int a) {
		super();
		this.codigo = c;
		this.titulo = t;
		this.año = a;
		
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

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}


}
