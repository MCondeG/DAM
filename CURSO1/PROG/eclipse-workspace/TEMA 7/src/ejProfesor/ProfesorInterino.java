package ejProfesor;

import java.util.Calendar;

public class ProfesorInterino extends Profesor {
	
	private Calendar FechaComienzoInterinidad;
	
	
	public ProfesorInterino(Calendar fechaComienzaInterinidad) {
		super();
		FechaComienzoInterinidad = fechaComienzaInterinidad;
	}
	
	public ProfesorInterino (String nombre, String apellidos, int edad, Calendar fechaComienzaInterinidad) {
		super(nombre, apellidos, edad);
		FechaComienzoInterinidad = fechaComienzaInterinidad;
	}

	
	public Calendar getFechaComienzoInterinidad () {
		return FechaComienzoInterinidad;
	}
	
	
	@Override
	public void mostrarDatos() {
		
		super.mostrarDatos();
		System.out.println("Datos ProfesorInterino. Comienzo interinidad: " + FechaComienzoInterinidad.getTime().toString());
	}
} //Cierre de la clase