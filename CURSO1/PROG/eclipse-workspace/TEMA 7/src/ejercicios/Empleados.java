package ejercicios;

public class Empleados {
	
	private int codigo;
	private static int cont = 1;
	
	public Empleados() {
		this.codigo = cont;
		cont++;
	}
	
	@Override
	public String toString() {
		
		return ("Empleado "+this.codigo);
	}
}