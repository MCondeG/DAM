package ejemplos;

import java.util.Scanner;

public class PruebaCoche {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner sc = new Scanner(System.in);
		Coche c1 = new Coche ("000IJK", "Mercedes", "Sport", "Gris Plata");
		
		String aux;
		
		
		c1.imprimirCoche();
		
		c1.setColor("Amarillo");
		
		System.out.println("\nIntroduce la marca");
		
		aux = sc.next();
		
		c1.setMarca(aux);
		
		System.out.println("\n\nCoche modificado\n");
		
		c1.imprimirCoche();
		
		sc.close();
	}
}