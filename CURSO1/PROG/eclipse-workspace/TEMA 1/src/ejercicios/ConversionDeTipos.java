package ejercicios;

public class ConversionDeTipos {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		int x = 2;
		int y = 9;
		double division;
		division = (double)y / (double)x;
		//division = y / x; // Comenta esta l�nea y
		// observa la diferencia.
		// al realizar la operacion y/x sin efectuar el cambio de tipo, el resultado es 4.0 . Es decir, se trunca el resultado real (4.5) y se guarda como double

		System.out.println("El resultado de la divisi�n es " + division);
	}
}