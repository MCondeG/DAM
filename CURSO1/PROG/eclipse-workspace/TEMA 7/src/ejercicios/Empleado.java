package ejercicios;

public class Empleado implements Comparable<Empleado> {

	private String nombre;
	private String apellido;
	private int edad;
	
	private static final String[] posiblesNombres = {"Manuel", "José", "Amparo", "Eva", "Fernando", "Alfonso", "María", "Isabel", "Enrique", "Laura", "Sara", "Rafael"};
	private static final String[] posiblesApellidos = {"Conde", "González", "Rodríguez", "Gil", "Fernández", "Sánchez", "López", "Serrano", "Jiménez", "Alonso", "Lozano", "Marín", "Benítez", "Menacho", "Ruiz", "Díaz", "García", "Álvarez", "Vera", "Guzmán"};
	
	
	public Empleado() {
		this.nombre = posiblesNombres[(int)(Math.random()*12)];
		this.apellido = posiblesApellidos[(int)(Math.random()*20)];
		this.edad = (int)(Math.random()*45)+20;
	}
	
	public Empleado(String nombre, String apellido, int edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	public Empleado(Empleado e) {
		this.nombre = e.nombre;
		this.apellido = e.apellido;
		this.edad = e.edad;
	}

	
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}


	@Override
	public String toString() {
		
		return (this.nombre+" "+this.apellido+", "+this.edad+" años");
	}
	
	@Override
	public int compareTo(Empleado e) {

		return (this.apellido.compareTo(e.apellido));
	}
}