package modelo;

public class ListaPistas {

	private Pista[] lp;
	
	
	public ListaPistas() {			//clase que envuelve un array de las 4 pistas
		
		this.lp = inicializaPistas();	
	}


	public Pista[] getLp() {
		return lp;
	}

	public void setLp(Pista[] lp) {
		this.lp = lp;
	}
	
	
	// crea las 4 pistas del programa. Se ejecuta con el constructor al iniciar el programa
	public Pista[] inicializaPistas() {
		
		this.lp = new Pista[4];
		
		for (int i = 0; i <= 3; i++) {
			this.lp[i] = new Pista(i+1);
		}
		
		return this.lp;
	}
}