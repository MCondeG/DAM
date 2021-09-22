package ejercicios;

import java.util.*;

public class Matriz {

	private ArrayList<ArrayList<Elemento>> a;

	private int nfil;
	private int ncol;

	
	public Matriz() {
		
	}

	public Matriz(int fil, int col, boolean aleatoria) {

		inicializa(fil, col, aleatoria);
	}

	public Matriz(int fil, int col, Elemento[][] array) {

		inicializa(fil, col, array);
	}
	
	
	public void inicializa(int fil, int col, boolean p) {
		
		this.nfil = fil;
		this.ncol = col;
		this.a = new ArrayList<>();

		for (int i = 0;i < fil;i++) {
			
			this.a.add(new ArrayList<Elemento>());
						
			for (int j = 0;j < col;j++) {
				
				Elemento e = new Elemento(p);
				this.a.get(i).add(e);
			}
		}
	}
	
	public void inicializa(int fil, int col, Elemento[][] array) {
		
		this.nfil = fil;
		this.ncol = col;
		this.a = new ArrayList<>();

		for (int i = 0;i < fil;i++) {
			
			ArrayList<Elemento> aux = new ArrayList<>();
			
			for (int j = 0;j < col;j++) {
				
				Elemento e = new Elemento(array[i][j]);
				aux.add(e);
			}
		}
	}
	
	public void set (int fil, int col, Elemento e) {
		a.get(fil).set(col, e);
	}
	
	public Elemento get (int fil, int col) {
		return a.get(fil).get(col);
	}

	public void espejo() {
		
		for (int i = 0; i < this.a.size(); i++) {
			Collections.reverse(this.a.get(i));
		}
	}
	
	public Elemento[][] trasponer() {
		
		Elemento[][] orig = new Elemento[this.nfil][this.ncol];
		Elemento[][] trasp = new Elemento[this.ncol][this.nfil];
		
		orig = this.a.toArray(orig);
		trasp = this.a.toArray(trasp);
		
		for (int i = 0;i < trasp.length;i++) {
			
			for (int j = 0;j < trasp[i].length;j++) {
			
				trasp[i][j] = orig[j][i];
			}
		}
		
		return trasp;
	}
	
	public void imprimir() {
		
		for (int i = 0; i < this.nfil;i++) {
			
			System.out.println();
			
			for (int j = 0;j < this.ncol;j++) {
				
				System.out.print(this.a.get(i).get(j).getE()+" ");
			}
		}
	}
}