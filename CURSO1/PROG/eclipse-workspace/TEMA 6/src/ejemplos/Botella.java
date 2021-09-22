package ejemplos;

public class Botella {
	
	private String material;
	private String color;
	private double capacidad;
	private double cantidad;
	
	public Botella(String material, String color, double capacidad, double cantidad) {
		this.material = material;
		this.color = color;
		this.capacidad = capacidad;
		this.cantidad = cantidad;
	}

	public Botella() {
		
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad (double cantidad) {
		this.cantidad = cantidad;
	}
	

	public void llenarBotella (double litros) {
		
		this.cantidad = this.cantidad + litros;
		
		if (this.cantidad > this.capacidad) this.cantidad = this.capacidad;
	}
	
	public void vaciarBotella (double litros) {
		
		this.cantidad = this.cantidad - litros;
		
		if (this.cantidad < 0) this.cantidad = 0;
	}
	
	public boolean botellaLlena () {
		
		if (this.cantidad == this.capacidad) return true;
		else return false;
	}
	
	public boolean botellaVacia () {
		
		if (this.cantidad == 0) return true;
		else return false;
	}
	
	public void liquidoEnBotella () {
		
		System.out.println("Cantidad actual: "+this.cantidad+"l");
	}
}