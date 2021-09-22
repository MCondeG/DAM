package ejercicios;

public class Vehiculo {

	private static int vehiculosCreados = 0;
	private static double kilometrajeTotal = 0;
	
	private String marca;
	private String modelo;
	private String color;
	private double kilometros;
	
	Vehiculo(String marca, String modelo, String color, double kilometros) {
		
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.kilometros = kilometros;
	}
	
	Vehiculo() {
		
	}

	public static int getVehiculosCreados() {
		return vehiculosCreados;
	}

	public static void setVehiculosCreados(int vehiculosCreados) {
		Vehiculo.vehiculosCreados = vehiculosCreados;
	}

	public static double getKilometrajeTotal() {
		return kilometrajeTotal;
	}

	public static void setKilometrajeTotal(double kilometrajeTotal) {
		Vehiculo.kilometrajeTotal = kilometrajeTotal;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getKilometros() {
		return kilometros;
	}

	public void setKilometros(double kilometros) {
		this.kilometros = kilometros;
	}

	
	
	private void kmTotal (double kilometros) {
		
		Vehiculo.kilometrajeTotal += this.kilometros;		
	}
	
	public void recorre (double km) {
		
		this.kilometros += km;
		kmTotal (this.kilometros);
	}
	
	public void creaVehiculo() {
		
		Vehiculo.vehiculosCreados++;
	}
}