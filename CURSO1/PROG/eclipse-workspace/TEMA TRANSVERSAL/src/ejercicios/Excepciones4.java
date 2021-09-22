package ejercicios;

public class Excepciones4 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		int n[] = new int[10];
		
		try {
			System.out.println(n[80]);
		}catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("ERROR. No existe la posición");
			System.out.println(e);
		}
	}
}