package ejercicios;

import java.util.Scanner;

public class Bucles2 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner sc = new Scanner(System.in);
		
		boolean p = true;
		
		do {
			System.out.println("Introduce un numero");
			int n = sc.nextInt();
			
			System.out.println("Quiere continuar? Y/N");
			String s = sc.next();
			char c = s.charAt(0);
			if (c == 'Y') {
				p = true;
			}
			else if (c == 'N') {
				p = false;
				System.out.println("Adios");
			}
			else {
				System.out.println("ERROR");
			}	
		}while (p);
		
	}

}
