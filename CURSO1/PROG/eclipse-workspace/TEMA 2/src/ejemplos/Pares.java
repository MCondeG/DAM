//Mostrar pares entre 160 y 320 y contar cuantos son

package ejemplos;

public class Pares {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		int n = 160;
		int contador = 160;
		int cont2 = 0;
		
		while (contador<=320) {
			if (n%2 == 0) {
				System.out.print(""+n+" ");
				cont2++;
			}
			n++;
			contador++;
		}
		
		System.out.println("");
		System.out.println("Hay "+cont2+" numeros pares");
	}
}
