package pack2;

public class Persona {

	private String nombreApellido;
	private String dni;
	
	public Persona() {
		
	}
	
	public Persona(String nombreApellido, String dni) {
		this.nombreApellido = nombreApellido;
		this.dni = dni;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public String getDni() {
		return dni;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
}