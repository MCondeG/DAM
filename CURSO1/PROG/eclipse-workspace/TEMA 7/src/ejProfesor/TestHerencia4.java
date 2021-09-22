package ejProfesor;

import java.util.Calendar;

public class TestHerencia4 {

	public static void main (String [ ] Args) {

		Profesor profesor1 = new Profesor ("Juan", "Hern�ndez Garc�a", 33);
		profesor1.setIdProfesor("Prof 22-387-11");

		Calendar fecha1 = Calendar.getInstance();
		fecha1.set(2019,10,22); //Los meses van de 0 a 11, luego 10 representa noviembre

		ProfesorInterino interino1 = new ProfesorInterino("Jos� Luis", "Morales P�rez", 54, fecha1);
		ProfesorTitular titular1 = new ProfesorTitular("Juan", "Rodr�guez L�pez", 45, "Matem�ticas");

		ListinProfesores listin1 = new ListinProfesores ();
		listin1.addProfesor(profesor1);
		listin1.addProfesor(interino1);
		listin1.addProfesor(titular1);
		listin1.listar();
		
	} //Cierre del main
}