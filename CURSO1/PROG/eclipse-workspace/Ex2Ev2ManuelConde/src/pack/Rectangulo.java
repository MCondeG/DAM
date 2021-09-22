package pack;

public class Rectangulo extends Figura {
	
	private double base;
	private double altura;
	private static int rectangulosTotales = 0;
	private static double rectanguloAreaTotal = 0;
	
	public Rectangulo(double area, double base, double altura) {
		super(area);
		this.base = base;
		this.altura = altura;
	}
	
	public Rectangulo() {
		
	}

	
	
	public double getBase() {
		return base;
	}

	public double getAltura() {
		return altura;
	}

	public static int getRectangulosTotales() {
		return rectangulosTotales;
	}

	public static double getRectanguloAreaTotal() {
		return rectanguloAreaTotal;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public static void setRectangulosTotales(int rectangulosTotales) {
		Rectangulo.rectangulosTotales = rectangulosTotales;
	}

	public static void setRectanguloAreaTotal(double rectanguloAreaTotal) {
		Rectangulo.rectanguloAreaTotal = rectanguloAreaTotal;
	}
	
	
	@Override
	public String toString() {
		
		return ("RECTANGULO:\nBase = "+this.base+"\nAltura = "+this.altura+"\nArea = "+this.area+"\nRectangulos creados = "+Rectangulo.rectangulosTotales+"\nArea total rectangulos = "+Rectangulo.rectanguloAreaTotal+super.toString());
	}

	
	
	public double calculaArea(double base, double altura) {
		
		this.area = this.base*this.altura;
		
		Rectangulo.rectanguloAreaTotal += this.area;
		
		return super.calculaArea();
	}

	
	@Override
	public void mostrarArea() {
		
		super.mostrarArea();
	}
}