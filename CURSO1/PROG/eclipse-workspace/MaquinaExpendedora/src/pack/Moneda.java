package pack;

import java.util.Scanner;

public class Moneda {						//clase que controla todo lo relacionado con introducir monedas
	public double pedir() {					//método para introducir monedas
		Scanner sc = new Scanner(System.in);
		double din = 0.0;		//dinero introducido
		
		do {
			System.out.println("Introduzca monedas (€)");
			din = sc.nextDouble();
			if (din < 0) {
				System.out.println("ERROR");
			}
		} while (din < 0);

		/*sc.close();  he intentado cerrar el objeto de la clase scanner,
		 * pero al reabrirlo da problemas, así que he decidido dejarlo en uso*/
		return(din);
	}
	
	public double aumentar(double d) {		/*si se verifica que se necesita más dinero,
	este método llama al método para pedir más monedas y lo suma al dinero acumulado*/
		
		double din = 0.0;
		din = pedir();
		
		d = d + din;
		return(d);
	}
}