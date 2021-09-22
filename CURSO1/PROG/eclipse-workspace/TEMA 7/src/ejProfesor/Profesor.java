package ejProfesor;

public class Profesor extends Persona {
	
	private String IdProfesor;

	
	public Profesor () {
		super();
		IdProfesor = "Unknown";
	}
	
	public Profesor (String nombre, String apellidos, int edad) {
		super(nombre, apellidos, edad);
		IdProfesor = "Unknown";
	}

	
	public void setIdProfesor (String IdProfesor) {
		this.IdProfesor = IdProfesor;
	}

	public String getIdProfesor () {
		return IdProfesor;
	}

	
	public void mostrarDatos() {
		
		System.out.println ("Datos Profesor. Profesor de nombre: " + getNombre() + " " + getApellidos() +" con Id de profesor: " + getIdProfesor());
	}

} //Cierre de la clase