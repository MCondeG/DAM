//Mostrar multiplos de 5 de 0 a 100 usando while

package ejemplos;

public class Multiplos5 {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
		int n = 5;
		int contador = 5;
		
		while (contador<=100) {
			if (n%5 == 0) {
				System.out.print(""+n+" ");
			}
			n++;
			contador++;
		}

	}

}
