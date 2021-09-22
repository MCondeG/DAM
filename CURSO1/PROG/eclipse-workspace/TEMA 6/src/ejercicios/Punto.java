package ejercicios;

public class Punto implements IPunto {

	protected double x;
	protected double y;
	protected static Punto o = new Punto();
	
	public Punto() {
		this.x = 0;
		this.y = 0;
	}
	
	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public void setX(double x) {
		this.x = x;
	}

	@Override
	public void setY(double y) {
		this.y = y;
	}

	
	@Override
	public void mover(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void mover(IPunto p) {
		this.setX(getX());
		this.setY(getY());
	}

	@Override
	public void borrar() {
		this.x = 0;
		this.y = 0;
	}
	
	@Override
	public double distanciaOrigen() {

		return (Math.sqrt(Math.pow(this.getX(), 2) + (Math.pow(this.getY(), 2))));
	}

	@Override
	public double distancia(IPunto p) {
		
		return Math.abs(p.distanciaOrigen() - this.distanciaOrigen());
	}

	@Override
	public void imprime() {
		
		System.out.println(this.x+", "+this.y);;
	}
}