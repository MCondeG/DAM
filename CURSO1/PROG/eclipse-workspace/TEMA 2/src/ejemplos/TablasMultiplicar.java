package ejemplos;

public class TablasMultiplicar {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
		int contador = 0;
		int n = 1;
		
		while (n<=10) {
			System.out.println("TABLA DE MULTIPLICAR DEL "+n);
			while (contador<=10) {
				System.out.println(""+n+" * "+contador+" = "+(n*contador));
				contador++;
			}
		n++;
		contador = 0;
		System.out.println("");
		}
	}
}