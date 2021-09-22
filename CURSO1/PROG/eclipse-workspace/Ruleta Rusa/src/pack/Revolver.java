package pack;

public class Revolver {
	
	
	//ATRIBUTOS
	
	private static final int posBala = (int)((Math.random()*9)+1);
	private static int posAct = 1;
	
	
	//CONSTRUCTOR
	
	public Revolver() {
		
	}
	
	public Revolver(int posAct) {
		Revolver.posAct = posAct;
	}
	
	
	//GETTERS & SETTERS
	
	public static int getPosbala() {
		return posBala;
	}
	
	public int getPosAct() {
		return posAct;
	}
	
	
	//M�TODOS
	
	@Override
	public String toString() {
		return ("Bala: "+posBala+"\nPosici�n actual: "+posAct);
	}
	
	public boolean disparar() {
		
		if (posBala == posAct) return true;
		else {
			siguienteBala();
			return false;
		}
	}
	
	public void siguienteBala() {
		
		if (posAct == 9) Revolver.posAct = 0;
		else Revolver.posAct++;
	}
}