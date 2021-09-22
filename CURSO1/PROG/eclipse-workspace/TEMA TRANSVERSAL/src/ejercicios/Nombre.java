package ejercicios;

public class Nombre {
	
	private String nombre;
	private int codigo;
	
	public Nombre() {
		
	}
	
	public Nombre(String nombre, int codigo) {
		this.nombre = nombre;
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}