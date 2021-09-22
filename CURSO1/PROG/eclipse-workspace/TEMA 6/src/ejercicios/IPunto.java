package ejercicios;

public interface IPunto {

	public double getX();
	public double getY();
	public void setX(double x);
	public void setY(double y);
	public void mover(double x, double y);
	public void mover(IPunto p);
	public void borrar();
	public double distancia(IPunto p);
	public double distanciaOrigen();
	public void imprime();
}