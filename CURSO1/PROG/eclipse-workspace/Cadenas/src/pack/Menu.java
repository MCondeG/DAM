package pack;

import java.util.*;

public class Menu {		//clase con los metodos relacionados con el menu
	
	Scanner sc2 = new Scanner(System.in);
	
	public void mostrar() {
		
		System.out.println("1. Insertar carácter");
		System.out.println("2. Buscar carácter");
		System.out.println("3. Eliminar carácter");
		System.out.println("4. Ordenar alfabéticamente");
		System.out.println("5. Eliminar vocales");
		System.out.println("6. Sustituir vocales por otro carácter");
		System.out.println("7. Listar elementos");
		System.out.println("8. Mostrar número de elementos");
		System.out.println("9. Salir");
		System.out.println("OPCIÓN POR DEFECTO: Cargar vector de pruebas con n elementos aleatorios (sobrescribe al vector existente)");
	}
	
	public void mostrar1() {
		
		System.out.println("1.1 En primera posición");
		System.out.println("1.2 En última posición");
		System.out.println("1.3 En posición concreta");
		System.out.println("OPCIÓN POR DEFECTO: Cancelar");
	}

	public void mostrar3() {
	
		System.out.println("3.1 Según posición");
		System.out.println("3.2 Según carácter");
		System.out.println("OPCIÓN POR DEFECTO: Cancelar");
	}

	public void mostrar4() {
	
		System.out.println("4.1 Ascendentemente");
		System.out.println("4.2 Descendentemente");
		System.out.println("OPCIÓN POR DEFECTO: Cancelar");
	}
	
	public int elegir() {

		int n = sc2.nextInt();
		System.out.println();
			
		return n;
	}
}