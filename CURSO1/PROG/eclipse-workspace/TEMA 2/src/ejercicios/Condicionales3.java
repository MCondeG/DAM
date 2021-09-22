package ejercicios;

import java.util.Scanner;

public class Condicionales3 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner s = new Scanner(System.in);
		
		System.out.println("Introduce una operación");
		String p = s.nextLine();
		
		System.out.println("Introduce 1 número");
		double x = s.nextDouble();
		
		System.out.println("Introduce otro número");
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
