package pack;

import java.util.*;

public class Menu {		//clase con los metodos relacionados con el menu
	
	Scanner sc2 = new Scanner(System.in);
	
	public void mostrar() {
		
		System.out.println("1. Insertar car�cter");
		System.out.println("2. Buscar car�cter");
		System.out.println("3. Eliminar car�cter");
		System.out.println("4. Ordenar alfab�ticamente");
		System.out.println("5. Eliminar vocales");
		System.out.println("6. Sustituir vocales por otro car�cter");
		System.out.println("7. Listar elementos");
		System.out.println("8. Mostrar n�mero de elementos");
		System.out.println("9. Salir");
		System.out.println("OPCI�N POR DEFECTO: Cargar vector de pruebas con n elementos aleatorios (sobrescribe al vector existente)");
	}
	
	public void mostrar1() {
		
		System.out.println("1.1 En primera posici�n");
		System.out.println("1.2 En �ltima posici�n");
		System.out.println("1.3 En posici�n concreta");
		System.out.println("OPCI�N POR DEFECTO: Cancelar");
	}

	public void mostrar3() {
	
		System.out.println("3.1 Seg�n posici�n");
		System.out.println("3.2 Seg�n car�cter");
		System.out.println("OPCI�N POR DEFECTO: Cancelar");
	}

	public void mostrar4() {
	
		System.out.println("4.1 Ascendentemente");
		System.out.println("4.2 Descendentemente");
		System.out.println("OPCI�N POR DEFECTO: Cancelar");
	}
	
	public int elegir() {

		int n = sc2.nextInt();
		System.out.println();
			
		return n;
	}
}