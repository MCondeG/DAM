package ejemplos;

public class Cubo {

	String material;
	double capacidad;
	double cantidad;
	String color;
	boolean asa;
	
	public Cubo() {
		
	}
	
	public Cubo(String material, double capacidad, double cantidad, String color, boolean asa) {
		
		this.material = material;
		this.capacidad = capacidad;
		this.cantidad = cantidad;
		this.color = color;
		this.asa = asa;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
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

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isAsa() {
		return asa;
	}

	public void setAsa(boolean asa) {
		this.asa = asa;
	}

	@Override
	public String toString() {
		return "Cubo [material=" + material + ", capacidad=" + capacidad + ", cantidad=" + cantidad + ", color=" + color
				+ ", asa=" + asa + "]";
	}
	
	
}
