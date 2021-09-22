package ejemplos;

import java.util.Scanner;

public class PruebaBotella {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner sc = new Scanner(System.in);
		Botella b1 = new Botella();
		
		b1.setMaterial("Plástico");
		b1.setColor("Azul");
		b1.setCapacidad(2);
		b1.setCantidad(1);
		
		int n;
		double litros;
		
		do {
			
			System.out.println("1. Comprobar botella llena");
			System.out.println("2. Comprobar botella vacía");
			System.out.println("3. Llenar botella");
			System.out.println("4. Vaciar botella");
			System.out.println("5. Comprobar cantidad actual");
			System.out.println("6. Salir");
			
			do {
				n = sc.nextInt();
			} while (n<1 || n>6);
			
			System.out.println();
			
			switch (n) {
			case 1:
				if (b1.botellaLlena()) System.out.println("La botella está llena");
				else System.out.println("La botella no está llena");
				break;
			case 2:
				if (b1.botellaVacia()) System.out.println("La botella está vacía");
				else System.out.println("La botella no está vacía");
				break;
			case 3:
				System.out.println("¿Cuántos litros?");
				litros = sc.nextDouble();
				b1.llenarBotella(litros);
				break;
			case 4:
				System.out.println("¿Cuántos litros?");
				litros = sc.nextDouble();
				b1.vaciarBotella(litros);
				break;
			case 5:
				b1.liquidoEnBotella();
			default:
				break;
			}
			
			System.out.println("\n");
			
		} while (n != 6);
		
		sc.close();
	}
}