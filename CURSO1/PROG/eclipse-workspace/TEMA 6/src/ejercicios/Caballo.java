package ejercicios;

public class Caballo {
	
	private String color;
	private int edad;
	private double peso;
	private boolean sexo;
	
	Caballo(String color, int edad, double peso, boolean sexo) {
		
		this.color = color;
		this.edad = edad;
		this.peso = peso;
		this.sexo = sexo;
	}
	
	Caballo() {
		
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public boolean isSexo() {
		return sexo;
	}

	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}
	
	
	public void relinchar() {
		
		System.out.println("brrrrrr");
	}
}