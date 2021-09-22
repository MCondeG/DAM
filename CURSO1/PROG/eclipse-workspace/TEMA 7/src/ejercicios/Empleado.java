package ejercicios;

public class Empleado implements Comparable<Empleado> {

	private String nombre;
	private String apellido;
	private int edad;
	
	private static final String[] posiblesNombres = {"Manuel", "Jos�", "Amparo", "Eva", "Fernando", "Alfonso", "Mar�a", "Isabel", "Enrique", "Laura", "Sara", "Rafael"};
	private static final String[] posiblesApellidos = {"Conde", "Gonz�lez", "Rodr�guez", "Gil", "Fern�ndez", "S�nchez", "L�pez", "Serrano", "Jim�nez", "Alonso", "Lozano", "Mar�n", "Ben�tez", "Menacho", "Ruiz", "D�az", "Garc�a", "�lvarez", "Vera", "Guzm�n"};
	
	
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
		
		return (this.nombre+" "+this.apellido+", "+this.edad+" a�os");
	}
	
	@Override
	public int compareTo(Empleado e) {

		return (this.apellido.compareTo(e.apellido));
	}
}