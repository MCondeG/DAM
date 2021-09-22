package ejercicios;

import java.util.Scanner;

public class Excepciones3 {
	
	static Scanner sc1 = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		ConjExcepciones3 ce = new ConjExcepciones3();
		int n;
		
		do {
			n = menu();
			switch (n) {
			case 1:
				try {
					ce.añadir();
				}
				catch (TamExcedidoException tee) {
					System.out.println(tee);
				}
				catch (TooLargeNameException tlne) {
					System.out.println(tlne);
				}
				break;
			case 2:
				ce.listar();
				break;
			case 3:
				break;
			default:
				System.err.println("ERROR");
				break;
			}
			System.out.println();
			System.out.println();
		} while (n != 3);
		
	}
	
	public static int menu() {
		
		System.out.println("1. Añadir nombre");
		System.out.println("2. Listar");
		System.out.println("3. Salir");
		
		return (sc1.nextInt());
	}
}