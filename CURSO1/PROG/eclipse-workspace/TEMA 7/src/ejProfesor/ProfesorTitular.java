package ejProfesor;

public class ProfesorTitular extends Profesor {

	private String especialidad;
	
	
	public ProfesorTitular(String especialidad) {
		
		super();
		this.especialidad = especialidad;
	}
	
	public ProfesorTitular(String nombre, String apellidos, int edad, String especialidad) {
		
		super(nombre, apellidos, edad);
		this.especialidad = especialidad;
	}

	
	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	
	@Override
	public void mostrarDatos() {
		
		super.mostrarDatos();
		System.out.println("Datos ProfesorTitular. Especialidad: " + this.especialidad);
	}
}