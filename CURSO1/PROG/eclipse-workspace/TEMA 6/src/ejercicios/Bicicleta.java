package ejercicios;

public class Bicicleta extends Vehiculo {
	
	private String tipo;
	
	Bicicleta(String marca, String modelo, String color, double kilometros, String tipo) {
		super(marca, modelo, color, kilometros);
		this.tipo = tipo;
	}
	
	Bicicleta() {
		
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}