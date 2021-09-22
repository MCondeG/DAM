package ejercicios;

import java.util.Scanner;

public class PruebaBiblioteca {
	
	static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {

		ConjLibro l = new ConjLibro ();
		int a = 0;
		
		do {
			
			System.out.println();			
			
			System.out.println("BIBLIOTECA");
			
			System.out.println();	
					  
			System.out.println("1.- Insertar nuevo libro");
			
			System.out.println();
			
			System.out.println("2.- Eliminar libro (según código)");
			
			System.out.println();
			
			System.out.println("3.- Consultar libro");
			
			System.out.println();
			
			System.out.println("4.- Buscar libro");
			
			System.out.println();
			
			System.out.println("5.- Listar");

			System.out.println();
			
			System.out.println("6.- Salir");
			
			System.out.println();
			
			System.out.println("Elige una opción: ");
			a = sc.nextInt();
			
		switch (a) {
			
			case 1: 
				
				Libros aux = new Libros ();
				aux = aux.pedirDatosT();
				l.insertar(aux);
				
			
			break;
			
			case 2:
				
				System.out.println("Introduce el código a eliminar: ");
				int cod = sc.nextInt();
				
				l.eliminar(cod);
				
			break;
			
			case 3:
				
			int s = 0;
			l.consultarLibro(s);
				
			break;
			
			case 4: 
				
			int x = 0;
			l.buscar(x);
				
			break;
			
			case 5: 
				
			l.listar();	
			
			default:
				
			break;	
				
			}
			
		} while (a != 6);
		
		System.out.println("Ha salido de la Biblioteca");
		
	}

}

