package ejercicios;

public class Persona implements Comparable<Persona> {

	private String nombre;
	private String apellido;
	private Integer edad;
	
	private static final String[] posiblesNombres = {"Manuel", "José", "Amparo", "Eva", "Fernando", "Alfonso", "María", "Isabel", "Enrique", "Laura", "Sara", "Rafael"};
	private static final String[] posiblesApellidos = {"Conde", "González", "Rodríguez", "Gil", "Fernández", "Sánchez", "López", "Serrano", "Jiménez", "Alonso"};
	
	
	public Persona() {
		this.nombre = posiblesNombres[(int)(Math.random()*12)];
		this.apellido = posiblesApellidos[(int)(Math.random()*10)];
		this.edad = Integer.valueOf((int)(Math.random()*30)+20);
	}
	

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}


	@Override
	public String toString() {
		
		return (this.nombre+" "+this.apellido+", "+this.edad+" años");
	}

	@Override
	public int compareTo(Persona p) {

		return this.apellido.compareTo(p.apellido);
	}
}