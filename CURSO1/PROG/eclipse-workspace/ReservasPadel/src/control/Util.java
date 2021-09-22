package control;

import modelo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

public class Util {		//clases con distintos metodos útiles

	public Util() {
		
	}
	
	
	// filtra el mes seleccionado de una lista de fechas dada
	public ArrayList<Fecha> filtrarMes(ArrayList<Fecha> reservas, int Mes) {
		
		Stream<Fecha> listaMes = reservas.stream().filter(x -> x.getMes() == Mes);
		
		return (ArrayList<Fecha>) listaMes.collect(Collectors.toList());
	}
	
	// separa el objeto fecha leido del fichero en sus distintos atributos para poder guardarlo de nuevo en el arraylist
	public Fecha separarFechas (String cad) {
		
		int dia;
		int mes;
		int año;
		int hora;
		String[] c1;
		String[] c2;
		String[] c3;
		
		c1 = cad.split("/");
		c2 = c1[2].split("\t");	
		c3 = c2[1].split(":");
		
		dia = Integer.parseInt(c1[0]);
		mes = Integer.parseInt(c1[1]);
		año = Integer.parseInt(c2[0]);
		hora = Integer.parseInt(c3[0]);
		
		return new Fecha(hora, dia, mes, año);
	}
}
