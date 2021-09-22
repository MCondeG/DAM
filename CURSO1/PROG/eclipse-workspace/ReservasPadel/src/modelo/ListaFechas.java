package modelo;

import java.util.ArrayList;

public class ListaFechas {		//clase que envuelve un arraylist de fechas

	private ArrayList<Fecha> lf;
	
	
	public ListaFechas() {
		
		this.lf = new ArrayList<Fecha>();
	}
	
	
	public ArrayList<Fecha> getLf() {
		return lf;
	}

	public void setLf(ArrayList<Fecha> lf) {
		this.lf = lf;
	}


	//comprueba si la fecha está ya introducida en el sistema. Usa el equals modificado de la clase Fecha
	public boolean contiene(Fecha f) {
		
		boolean p = false;
		
		for (int i = 0; i < this.lf.size(); i++) {
			if (this.lf.get(i).equals(f)) p = true;
		}
		
		return p;
	}
}