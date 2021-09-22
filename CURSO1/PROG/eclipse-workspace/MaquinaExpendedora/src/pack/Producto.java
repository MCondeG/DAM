package pack;

public class Producto {			//clase relacionada con la elección de producto
	public double elegir() {	//método para elegir aleatoriamente un producto
		
		int n = (int)(Math.random()*4+1);
		double precio = 0.0;		//precio de los productos elegidos
		
		System.out.println();
		
		switch (n) {
		case 1:
			precio = 0.65;
			System.out.println("Usted ha elegido:");
			System.out.println("1. Botella de agua pequeña: "+precio+" €");
			break;
		case 2:
			precio = 1.10;
			System.out.println("Usted ha elegido:");
			System.out.printf("2. Botella de agua grande: %.2f",precio);
			System.out.println(" €");
			break;
		case 3:
			precio = 0.70;
			System.out.println("Usted ha elegido:");
			System.out.printf("3. Zumo de Naranja: %.2f",precio);
			System.out.println(" €");
			break;
		case 4:
			precio = 0.75;
			System.out.println("Usted ha elegido:");
			System.out.println("4. Batido: "+precio+" €");
			break;
		default:
			break;
		}
		
		return(precio);
	}
}