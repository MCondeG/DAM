package pack;

public class Figura {
	
	protected double area;
	protected static int figurasTotales = 0;
	protected static double figuraAreaTotal = 0;
	
	public Figura() {
		
	}
	
	public Figura(double area) {
		this.area = area;
	}
	
	
	
	public double getArea() {
		return area;
	}

	public static int getFigurasTotales() {
		return figurasTotales;
	}

	public static double getFiguraAreaTotal() {
		return figuraAreaTotal;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public static void setFigurasTotales(int figurasTotales) {
		Figura.figurasTotales = figurasTotales;
	}

	public static void setFiguraAreaTotal(double figuraAreaTotal) {
		Figura.figuraAreaTotal = figuraAreaTotal;
	}

	
	@Override
	public String toString() {
		
		Figura.figurasTotales = Circulo.getCirculosTotales() + Cuadrado.getCuadradosTotales() + Rectangulo.getRectangulosTotales();
		
		return ("\nFiguras totales = "+Figura.figurasTotales+"\nArea total figuras = "+Figura.figuraAreaTotal);
	}
	
	
	public double calculaArea() {
		
		Figura.figuraAreaTotal = Circulo.getCirculoAreaTotal() + Cuadrado.getCuadradoAreaTotal() + Rectangulo.getRectanguloAreaTotal();
		
		return area;
	}
	
	public void mostrarArea() {
		
		System.out.println(area);
	}
}