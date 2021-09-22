package ejercicios;

import java.util.*;

public class PrincipalPersona {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
				
		operacionesLista();
		
	}
	
	public static int menu() {
		System.out.println("1. Crear lista de 10 personas");
		System.out.println("2. Lista ordenada según apellido");
		System.out.println("3. Lista ordenada según edad");
		System.out.println("4. Salir");
		
		return (sc.nextInt());
	}
	
	public static void operacionesLista() {
		
		ListaPersona lp = new ListaPersona();
		
		int n;
		boolean existe = false;
		
		do {
			
			n = menu();
			
			System.out.println("\n");
			
			switch (n) {
			case 1:
				if (!existe) {
					System.out.println("Lista creada:\n");
					lp.listar();
					existe = true;
				}
				else System.err.println("ERROR. Lista ya creada\n");
				break;
			case 2:
				if (existe) {
					lp.ordenApell();
					System.out.println("Lista ordenada por apellido:\n");
					lp.listar();
				}
				else System.err.println("ERROR. Lista vacía.\n");
				break;
			case 3:
				if (existe) {
					lp.ordenEdad();
					System.out.println("Lista ordenada por edad:\n");
					lp.listar();
				}
				else System.err.println("ERROR. Lista vacía.\n");
				break;
			case 4:
				break;
			default:
				break;
			}
			
			if (n != 1 && n != 2 && n != 3 && n != 4) System.err.println("ERROR\n");
			
		} while (n != 4);
	}
}