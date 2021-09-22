package pack;

public class Cuadrado extends Figura {
	
	protected double lado;
	protected static int cuadradosTotales = 0;
	protected static double cuadradoAreaTotal = 0;


	public Cuadrado(double area, double lado) {
		super(area);
		this.lado = lado;
	}
	
	public Cuadrado() {
		
	}

	
	
	
	public double getLado() {
		return lado;
	}

	public static int getCuadradosTotales() {
		return cuadradosTotales;
	}

	public static double getCuadradoAreaTotal() {
		return cuadradoAreaTotal;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	public static void setCuadradosTotales(int cuadradosTotales) {
		Cuadrado.cuadradosTotales = cuadradosTotales;
	}

	public static void setCuadradoAreaTotal(double cuadradoAreaTotal) {
		Cuadrado.cuadradoAreaTotal = cuadradoAreaTotal;
	}

	
	@Override
	public String toString() {
		
		return ("Lado = "+this.lado+"\nArea = "+this.area+"\nCuadrados creados = "+Cuadrado.cuadradosTotales+"\nArea total cuadrados = "+Cuadrado.cuadradoAreaTotal+super.toString());
	}
	
	
	public double calculaArea(double lado) {
		
		this.area = Math.pow(this.lado, 2);
		
		Cuadrado.cuadradoAreaTotal += this.area;
		
		return super.calculaArea();
	}
	
	@Override
	public void mostrarArea() {
		
		super.mostrarArea();
	}
}