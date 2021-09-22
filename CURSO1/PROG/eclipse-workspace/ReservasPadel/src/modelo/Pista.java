package modelo;

import java.io.IOException;

import control.ControladorFicheros;

public class Pista {		//clase con los atributos y métodos que definen una pista
	
	private int num;
	private ListaFechas reservas;
	private ControladorFicheros fic;
	
	
	public Pista() {
		
	}
	
	public Pista(int num) {
		
		this.num = num;
		this.reservas = new ListaFechas();
		this.fic = new ControladorFicheros(this.num);
		
		try {
			Pista.reservarDesdeFichero(this.reservas, this.fic);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public ListaFechas getReservas() {
		return reservas;
	}

	public void setReservas(ListaFechas reservas) {
		this.reservas = reservas;
	}
	
	
	public static void reservarDesdeFichero(ListaFechas reservas, ControladorFicheros fic) throws IOException {
		
		reservas.setLf(fic.leer());
	}
	
	// añade la fecha si esta pasa la validación y no está introducida con anterioridad. Control de posibles errores
	public int añadirReserva(Fecha fecha) {
		
		int codError;
		
		if (fecha.isValido()) {
			if (this.reservas.contiene(fecha)) codError = 2;
			else {
				codError = 0;
				this.reservas.getLf().add(fecha);
				try {
					this.fic.escribir(fecha);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		else codError = 1;
		
		return codError;
	}
}