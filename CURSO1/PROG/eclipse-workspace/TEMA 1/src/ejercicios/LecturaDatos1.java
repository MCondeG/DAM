package ejercicios;

import java.util.Scanner;

public class LecturaDatos1 {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Introduce tu nombre");
		String nombre = s.nextLine();
		System.out.println("Ahora introduce tu edad");
		int edad = s.nextInt();
		System.out.println("Tu nombre es "+nombre+" y tu edad es "+edad);

	}

}