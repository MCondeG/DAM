package ejemplos;

import java.util.Scanner;

public class MiClaseEjemplo {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		try {
			f();
			g();
		} catch (MiExcepcion1 e) {
			System.out.println("Capturada la excepción 1");
		} catch (MiExcepcion2 e) {
			System.out.println("Capturada la excepción 2");
			System.out.println(e);
			System.out.println("Código de Error = "+e.getCod_error());
		}
	}
	
	public static void f() throws MiExcepcion2 {
		
		System.out.println("PRUEBA DE F");
		
		int n = sc.nextInt();
		boolean p = false;
		
		if (n == 1) p = true;
		
		if (p) System.out.println("El método f continua");
		else throw new MiExcepcion2("Se lanzó la excepción 2 en f");
	}
	
	public static void g() throws MiExcepcion1, MiExcepcion2 {
		
		System.out.println("\nPRUEBA DE G");
		
		int a = sc.nextInt();
		
		switch (a) {
		case 1:
			throw new MiExcepcion1();
		case 2:
			throw new MiExcepcion2(34);
		case 3:
			throw new MiExcepcion2("Se lanzó la excepcion 2 en g");
		}
	}
}