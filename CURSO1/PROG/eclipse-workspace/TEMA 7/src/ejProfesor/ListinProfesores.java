package ejProfesor;

import java.util.ArrayList;

public class ListinProfesores{

	private ArrayList <Profesor> listinProfesores;

	
	//Constructor

	public ListinProfesores () {
		listinProfesores = new ArrayList <Profesor> ();
	}

	
	//M?todos

	public void addProfesor (Profesor profesor) {
		
		listinProfesores.add(profesor); 
	} // Cierre m?todo addProfesor

	public void listar() {

		System.out.println ("Se procede a mostrar los datos de los profesores existentes en el list?n");

		for (Profesor tmp: listinProfesores) { //Uso de for extendido
			tmp.mostrarDatos();
		}
	} //Cierre m?todo
} //Cierre de la clase