package modelo;

public class Fecha {		//clase con los atributos y m�todos que definen una fecha

	private int hora;
	private int dia;
	private int mes;
	private int a�o;
	private boolean valido;
	
	
	public Fecha() {
		
	}
	
	public Fecha(int hora, int dia, int mes, int a�o) {
		
		this.hora = hora;
		this.dia = dia;
		this.mes = mes;
		this.a�o = a�o;
		
		this.valido = validar();
	}

	
	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getA�o() {
		return a�o;
	}

	public void setA�o(int a�o) {
		this.a�o = a�o;
	}

	public boolean isValido() {
		return valido;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}
	
	
	// validaci�n de los par�metros de las fechas para evitar fechas incoherentes
	public boolean validar() {
		
		if ((this.hora >= 8 && this.hora <= 21) && (this.dia >= 1 && this.dia <= 31) && (this.mes >= 1 && this.mes <= 12) && (this.a�o >= 2020 && this.a�o <= 2025)) {
			return true;
		}
		else return false;
	}
	
	@Override
	public boolean equals(Object o) {
		
		Fecha f = (Fecha) o;
		
		if (this.getHora() == f.getHora() && this.getDia() == f.getDia() && this.getMes() == f.getMes() && this.getA�o() == f.getA�o()) {
			return true;
		}
		else return false;
	}
	
	@Override
	public String toString() {
		
		String cad = String.valueOf(this.dia) + "/" + String.valueOf(this.mes) + "/" + String.valueOf(this.a�o) + "\t" + (String.valueOf(this.hora) + ":00");
		
		return cad;
	}
}