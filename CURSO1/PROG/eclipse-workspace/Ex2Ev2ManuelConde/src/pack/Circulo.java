package pack;

public class Circulo extends Figura {

	private static final double pi = Math.PI;
	private double radio;
	private static int circulosTotales = 0;
	private static double circuloAreaTotal = 0;

	
	public Circulo(double area, double radio) {
		super(area);
		this.radio = radio;
	}
	
	public Circulo() {
		
	}

	
	
	public double getRadio() {
		return radio;
	}

	public static int getCirculosTotales() {
		return circulosTotales;
	}

	public static double getCirculoAreaTotal() {
		return circuloAreaTotal;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public static void setCirculosTotales(int circulosTotales) {
		Circulo.circulosTotales = circulosTotales;
	}

	public static void setCirculoAreaTotal(double circuloAreaTotal) {
		Circulo.circuloAreaTotal = circuloAreaTotal;
	}

	
	@Override
	public String toString() {
		
		return ("CIRCULO:\nRadio = "+this.radio+"\nArea = "+this.area+"\nCirculos creados = "+Circulo.circulosTotales+"\nArea total circulos = "+Circulo.circuloAreaTotal+super.toString());
	}
	
	public double calculaArea(double radio) {
		
		this.area = Math.pow(this.radio, 2)*pi;
		
		Circulo.circuloAreaTotal += this.area;
		
		return super.calculaArea();
	}
	
	@Override
	public void mostrarArea() {
		
		super.mostrarArea();
	}
}