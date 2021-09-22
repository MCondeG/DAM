package ejemplos;

public class MiExcepcion1 extends Exception {
	
	public MiExcepcion1 () {
		
	}
	
	public MiExcepcion1 (String texto) {
		super(texto);
	}
}