package ejercicios;

public class Excepciones1 {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
		int n = 10;
		
		try {
			n = n/0;
		}catch (ArithmeticException e) {
			System.err.println("ERROR. No se puede dividir entre cero");
			System.out.println(e);
		}

	}

}
