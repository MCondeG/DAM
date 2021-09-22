package pack;

public class CuadradoColoreado extends Cuadrado {
	
	private String color;
	
	public CuadradoColoreado(double area, double lado, String color) {
		super(area, lado);
		this.color = color;
	}
	
	public CuadradoColoreado() {
		
	}

	
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	
	@Override
	public String toString() {
		
		return ("CUADRADO:\nColor = "+this.color+"\n"+super.toString());
	}
	
	@Override
	public double calculaArea(double lado) {
		
		return super.calculaArea(this.lado);
	}
	
	@Override
	public void mostrarArea() {
		
		super.mostrarArea();
	}
}