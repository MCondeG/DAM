package ejercicios;

public class ConjuntoSecuencias {

	private static final int max = 10;
	private ListaNumeros[] ln = new ListaNumeros[max];
	
	
	public ConjuntoSecuencias(ListaNumeros listaOriginal) {
		
		creaTabla(this.ln);
		llenaTabla(this.ln, listaOriginal);
	}


	public static int getMax() {
		return max;
	}

	public ListaNumeros[] getLn() {
		return ln;
	}

	public void setLn(ListaNumeros[] ln) {
		this.ln = ln;
	}
	
	
	public static void creaTabla(ListaNumeros[] ln) {
		
		for (int i = 0; i < max; i++) {
			
			ln[i] = new ListaNumeros(false);
		}
	}
	
	public static void llenaTabla(ListaNumeros[] ln, ListaNumeros lo) {
		
		int n = 0;
		
		for (int i = 0; i < max; i++) {
			
			if (i > 0) n += ln[i-1].getA().size();
			
			ln[i].setA(lo.encuentraSecuencia(n));
		}
	}
	
	public void listar() {
		
		for (int i = 0; i < max; i++) {
			
			if (!(this.ln[i].getA().isEmpty())) this.ln[i].listar();
		}
	}
}