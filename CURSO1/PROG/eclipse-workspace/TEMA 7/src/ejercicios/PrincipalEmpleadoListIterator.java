package ejercicios;

import java.util.*;

public class PrincipalEmpleadoListIterator {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		ListaEmpleado le = new ListaEmpleado();
		
		operacionesLista(le);
		
	}
	
	
	public static int menuPrincipal() {
		
		System.out.println("1. Mostrar listados");
		System.out.println("2. Insertar nuevo empleado");
		System.out.println("3. Modificar tercer empleado por: Teresa Gómez Gómez, 32 años");
		System.out.println("Por defecto - Salir");
		
		return (sc.nextInt());
	}
	
	public static char menu1() {
		
		System.out.println();
		System.out.println("a. Recorrido completo hacia delante");
		System.out.println("b. Recorrido hacia delante desde la posición 2");
		System.out.println("c. Recorrido hacia detrás desde la posición 8");
		System.out.println("Por defecto - Salir");
		
		return (sc.next().charAt(0));
	}
	
	public static char menu2() {
		
		System.out.println();
		System.out.println("a. Al principio de la lista");
		System.out.println("b. En una posición determinada");
		System.out.println("c. Al final de la lista");
		System.out.println("Por defecto - Salir");
		
		return (sc.next().charAt(0));
	}
	
	
	public static void operacionesLista(ListaEmpleado le) {
		
		int n;
		
		do {
			
			n = menuPrincipal();
			
			switch (n) {
			case 1:
				op1(le);
				break;
			case 2:
				op2(le);
				break;
			case 3:
				le.modificar(2);
				break;
			default:
				break;
			}
			
			System.out.println("\n\n");
			
		} while (n == 1 || n == 2 || n == 3);
	}
	
	public static void op1(ListaEmpleado le) {
		
		char c = menu1();
		
		switch (c) {
		case 'a':
			le.listar(0);
			break;
		case 'b':
			le.listar(2);
			break;
		case 'c':
			le.listaInversa(8);
			break;
		default:
			break;
		}
	}
	
	public static void op2(ListaEmpleado le) {
		
		char c = menu2();
		
		switch (c) {
		case 'a':
			le.insertar(0, pedirEmp());
			break;
		case 'b':
			System.out.print("\nIntroduce posición en la lista para el nuevo empleado: ");
			int i = sc.nextInt();
			if (i > le.getTamaño() || i < 0) System.err.println("ERROR. Posición no válida");
			else le.insertar(i, pedirEmp());
			break;
		case 'c':
			le.insertar(le.getTamaño(), pedirEmp());
			break;
		default:
			break;
		}
	}
	
	public static Empleado pedirEmp() {
		
		String nombre, apellido;
		int edad;
		
		System.out.println();
		System.out.print("Introduce nombre del empleado: ");
		nombre = sc.next();
		System.out.print("Introduce apellidos del empleado: ");
		apellido = sc.next();
		System.out.print("Introduce edad del empleado: ");
		edad = sc.nextInt();
		
		return (new Empleado(nombre, apellido, edad));
	}
}