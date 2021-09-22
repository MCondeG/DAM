package ejemplos;

public class MiExcepcion2 extends Exception {
	
	private int cod_error;

	public MiExcepcion2 () {
		
	}
	
	public MiExcepcion2 (String texto) {
		super(texto);
	}
	
	public int getCod_error() {
		return cod_error;
	}

	public MiExcepcion2 (int valor) {
		this.cod_error = valor;
	}
}