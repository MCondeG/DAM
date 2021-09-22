package ejercicios;

public class Random7 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		int n,m,p;
		
		do {
			n = (int)(Math.random()*6+1);
			m = (int)(Math.random()*6+1);
			p = (int)(Math.random()*6+1);
		} while ((n == p) || (n == m) || (m == p));
		
		System.out.println("Los 3 nuevos colores son: ");
		
		switch (n) {
		case 1:
			System.out.println("Rojo");
			break;
		case 2:
			System.out.println("Azul");
			break;
		case 3:
			System.out.println("Verde");
			break;
		case 4:
			System.out.println("Amarillo");
			break;
		case 5:
			System.out.println("Violeta");
			break;
		case 6:
			System.out.println("Naranja");
			break;
		default:
			break;
		}
		switch (m) {
		case 1:
			System.out.println("Rojo");
			break;
		case 2:
			System.out.println("Azul");
			break;
		case 3:
			System.out.println("Verde");
			break;
		case 4:
			System.out.println("Amarillo");
			break;
		case 5:
			System.out.println("Violeta");
			break;
		case 6:
			System.out.println("Naranja");
			break;
		default:
			break;
	}
		switch (p) {
		case 1:
			System.out.println("Rojo");
			break;
		case 2:
			System.out.println("Azul");
			break;
		case 3:
			System.out.println("Verde");
			break;
		case 4:
			System.out.println("Amarillo");
			break;
		case 5:
			System.out.println("Violeta");
			break;
		case 6:
			System.out.println("Naranja");
			break;
		default:
			break;
		}
	}
}