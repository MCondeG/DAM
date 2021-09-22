package pack;

public class Cambio {								//clase para gestionar el cambio
	public double devolver(double cambio) {			//devuelve cambio intentando reducir el número de monedas al mínimo
		
		if (cambio >= 2.0) {
			System.out.println("Moneda de 2€");
			cambio = cambio - 2.0;
			return (cambio);
		}
		else if (cambio >= 1.0) {
			System.out.println("Moneda de 1€");
			cambio = cambio - 1.0;
			return (cambio);
		}
		else if (cambio >= 0.5) {
			System.out.println("Moneda de 50 céntimos");
			cambio = cambio - 0.5;
			return (cambio);
		}
		else if (cambio >= 0.2) {
			System.out.println("Moneda de 20 céntimos");
			cambio = cambio - 0.2;
			return (cambio);
		}
		else if (cambio >= 0.1) {
			System.out.println("Moneda de 10 céntimos");
			cambio = cambio - 0.1;
			return (cambio);
		}
		else if (cambio >= 0.05) {
			System.out.println("Moneda de 5 céntimos");
			cambio = cambio - 0.05;
			return (cambio);
		}
		else if (cambio >= 0.02) {
			System.out.println("Moneda de 2 céntimos");
			cambio = cambio - 0.02;
			return (cambio);
		}
		else if (cambio >= 0.00000001) {		//mismo caso que el explicado en la linea 40 del main
			System.out.println("Moneda de 1 céntimo");
			cambio = cambio - 0.01;
			return (cambio);
		}
		else {
			return(cambio);
		}
	}
}