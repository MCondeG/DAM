package ejercicios;

public class Excepciones4 {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
		int n[] = new int[10];
		
		try {
			System.out.println(n[80]);
		}catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("ERROR. No existe la posici�n");
			System.out.println(e);
		}
	}
}