package pack;

import java.util.*;

public class Menu {		//clase con los metodos relacionados con el menu
	
	Scanner sc2 = new Scanner(System.in);
	
	public void mostrar() {
		
		System.out.println("1. Insertar elemento");
		System.out.println("2. Modificar elemento");
		System.out.println("3. Eliminar elemento");
		System.out.println("4. Mostrar n�mero de elementos");
		System.out.println("5. Ordenar elementos");
		System.out.println("6. Imprimir elementos");
		System.out.println("7. Salir");
		System.out.println("OPCI�N POR DEFECTO: Cargar vector de pruebas con n elementos (sobrescribe al vector existente)");
	}
	
	public void mostrar1() {
		
		System.out.println("1.1 En primera posici�n");
		System.out.println("1.2 En �ltima posici�n");
		System.out.println("1.3 En posici�n concreta");
		System.out.println("OPCI�N POR DEFECTO: Cancelar");
	}
	
	public void mostrar2() {
		
		System.out.println("2.1 Seg�n posici�n");
		System.out.println("2.2 B�squeda por valor");
		System.out.println("OPCI�N POR DEFECTO: Cancelar");
	}

	public void mostrar3() {
	
		System.out.println("3.1 Seg�n posici�n");
		System.out.println("3.2 B�squeda por valor");
		System.out.println("OPCI�N POR DEFECTO: Cancelar");
	}

	public void mostrar5() {
	
		System.out.println("Selecciona m�todo de ordenaci�n:");
		System.out.println("5.1 Burbuja");
		System.out.println("5.2 Inserci�n");
		System.out.println("5.3 Selecci�n");
		System.out.println("OPCI�N POR DEFECTO: Cancelar");
	}
	
	public void mostrardefecto() {
		
		System.out.println(".1 Vector de pruebas ordenado");
		System.out.println(".2 Vector de pruebas aleatorio");
		System.out.println("OPCI�N POR DEFECTO: Cancelar");
	}
	
	public int elegir() {

		int n = sc2.nextInt();
		System.out.println();
			
		return n;
	}
}