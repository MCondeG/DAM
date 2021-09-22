package ejercicios;

public class Coche extends Vehiculo {

	private String matricula;
	private double peso;
	
	Coche(String marca, String modelo, String color, double kilometros, String matricula, double peso) {
		super(marca, modelo, color, kilometros);
		this.matricula = matricula;
		this.peso = peso;
	}
	
	Coche() {
		
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
}