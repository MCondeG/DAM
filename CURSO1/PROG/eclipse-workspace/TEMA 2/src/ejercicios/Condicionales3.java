package ejercicios;

import java.util.Scanner;

public class Condicionales3 {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente

		Scanner s = new Scanner(System.in);
		
		System.out.println("Introduce una operaci�n");
		String p = s.nextLine();
		
		System.out.println("Introduce 1 n�mero");
		double x = s.nextDouble();
		
		System.out.println("Introduce otro n�mero");
		double y = s.nextDouble();

		char op = p.charAt(0);
		
		switch (op) {
		case '+' :
			System.out.println(x+" + "+y+" = "+(x+y));
			break;
		case '-' :
			System.out.println(x+" - "+y+" = "+(x-y));
			break;
		case '*' :
			System.out.println(x+" * "+y+" = "+(x*y));
			break;
		case '/' :
			System.out.println(x+" / "+y+" = "+(x/y));
			break;
		default :
			System.out.println("ERROR");
			break;		
		}
		
		// ejemplo con if anidado
		
		/*if (op == '+') {
			System.out.println(x+" + "+y+" = "+(x+y));
		}
		else if (op == '-') {
			System.out.println(x+" + "+y+" = "+(x-y));
		}
		else if (op == '*') {
			System.out.println(x+" + "+y+" = "+(x*y));
		}
		else if (op == '/') {
			System.out.println(x+" + "+y+" = "+(x/y));
		}
		else {
			System.out.println("ERROR");
		}*/
	}
}
