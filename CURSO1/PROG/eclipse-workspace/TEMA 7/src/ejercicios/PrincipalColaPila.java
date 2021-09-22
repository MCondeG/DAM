package ejercicios;

import java.util.*;

public class PrincipalColaPila {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		LinkedList<Elemento> cola = new LinkedList<Elemento>();
		LinkedList<Cadena> pila = new LinkedList<Cadena>();
		
		Elemento e = new Elemento();
		Cadena c = new Cadena();
		
		int n1;
		int n2;
		
		do {
			n1 = menu();
			
			switch (n1) {
			case 1:
				n2 = menuCola();
				if (n2 == 1 || n2 == 2 || n2 == 3) opCola(cola, e, n2);
				break;
			case 2:
				n2 = menuPila();
				if (n2 == 1 || n2 == 2 || n2 == 3 || n2 == 4) opPila(pila, c, n2);
				break;
			default:
				break;
			}
		} while (n1 == 1 || n1 == 2);
	}
	
	public static int menu() {
		
		int n;
		
		System.out.println("\n\n¿Qué deseas usar?");
		System.out.println("1. Cola");
		System.out.println("2. Pila");
		System.out.println("Por defecto - Salir");
		
		n = sc.nextInt();
		
		return n;
	}
	
	public static int menuCola() {
		
		int n;
		
		System.out.println("\n\n¿Qué deseas hacer?");
		System.out.println("1. Encolar");
		System.out.println("2. Desencolar");
		System.out.println("3. Listar elementos");
		System.out.println("Por defecto - Salir");
		
		n = sc.nextInt();
		
		return n;
	}
	
	public static int menuPila() {
		
		int n;
		
		System.out.println("\n\n¿Qué deseas hacer?");
		System.out.println("1. Apilar");
		System.out.println("2. Desapilar");
		System.out.println("3. Mostrar cima");
		System.out.println("4. Listar elementos");
		System.out.println("Por defecto - Salir");
		
		n = sc.nextInt();
		
		return n;
	}
	
	public static void opCola(LinkedList<Elemento> cola, Elemento e, int n) {
		
		switch (n) {
		case 1:
			System.out.println("\n\nIntroduce un entero");
			Elemento elem = new Elemento(sc.nextInt());
			e.encolar(cola, elem);
			break;
		case 2:
			e.desencolar(cola);
			break;
		case 3:
			e.listar(cola);
			break;
		default:
			break;
		}
	}
	
	public static void opPila(LinkedList<Cadena> pila, Cadena c, int n) {
		
		switch (n) {
		case 1:
			System.out.println("\n\nIntroduce una cadena");
			Cadena cad = new Cadena(sc.next());
			c.apilar(pila, cad);
			break;
		case 2:
			c.desapilar(pila);
			break;
		case 3:
			c.cima(pila);
			break;
		case 4:
			c.listar(pila);
			break;
		default:
			break;
		}
	}
}