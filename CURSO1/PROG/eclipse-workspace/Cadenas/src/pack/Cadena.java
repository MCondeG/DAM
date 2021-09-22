package pack;

import java.util.*;

public class Cadena {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Menu m = new Menu();
		Elemento e = new Elemento();
		Operacion o = new Operacion();
		
		char[] c = new char[30];
		
		int n1;
		int n2;
		int pos;						//posicion de los elementos en el vector
		int nelem = 0;					//nº de elementos cargados en el vector
		int contVocal = 0;				//cuenta las vocales eliminadas o modificadas en el vector
		char elem;						//valor de los elementos
		boolean sentido;				//false para izquierda, true para derecha
		boolean orden = false;			//false para vector desordenado, true para ordenado
		boolean ascend = true; 			//en caso de vector ordenado: false para descendente, true para ascendente
		
		System.out.println(" PROYECTO CADENA");
		System.out.println("___________________");
		System.out.println();
		System.out.println();
		
		do {
			m.mostrar();
			System.out.println();
			n1 = m.elegir();
			
			switch (n1) {
			case 1:
				if (nelem < 30) {
					System.out.println();
					m.mostrar1();
					System.out.println();
					n2 = m.elegir();
					System.out.println();
					
					switch (n2) {
					case 1:
						pos = 0;
						sentido = true;
						o.desplazar(c, sentido, pos, nelem);
						e.insertar(c, pos);
						nelem++;
						break;
					case 2:
						pos = nelem;
						e.insertar(c, pos);
						nelem++;
						break;
					case 3:
						System.out.println("Introduce posición");
						do {
							pos = sc.nextInt();
							if ((pos < 0) || (pos > nelem)) {
								System.out.println("ERROR. Posición no válida");
							}
						} while ((pos < 0) || (pos > nelem));
						System.out.println();
						sentido = true;
						if (pos != nelem) {
							o.desplazar(c, sentido, pos, nelem);
						}
						e.insertar(c, pos);
						nelem++;
						break;
					default:
						break;
					}
					orden = false;
				}
				else {
					System.out.println("ERROR. Vector completo");
				}
				System.out.println();
				System.out.println();
				break;
			case 2:
				System.out.println("Introduce elemento a buscar");
				elem = sc.next().charAt(0);
				if (orden) {
					pos = e.busquedaBinaria(c, nelem, elem, ascend);
				}
				else {
					pos = e.buscar(c, nelem, elem);
				}
				if (pos >= 0) {
					System.out.println("Elemento "+elem+" encontrado en la posición "+pos);
				}
				else {
					System.out.println("Elemento no encontrado");
				}
				System.out.println();
				System.out.println();
				break;
			case 3:
				System.out.println();
				m.mostrar3();
				System.out.println();
				n2 = m.elegir();
				System.out.println();
				
				switch (n2) {
				case 1:
					System.out.println("Introduce posición");
					do {
						pos = sc.nextInt();
						if ((pos < 0) || (pos >= nelem)) {
							System.out.println("ERROR. Posición no válida");
						}
					} while ((pos < 0) || (pos >= nelem));
					
					sentido = false;
					o.desplazar(c, sentido, pos, nelem);
					nelem--;
					break;
				case 2:
					System.out.println("Introduce elemento a eliminar");
					elem = sc.next().charAt(0);
					if (orden) {
						pos = e.busquedaBinaria(c, nelem, elem, ascend);
					}
					else {
						pos = e.buscar(c, nelem, elem);
					}
					if (pos >= 0) {
						System.out.println("Elemento '"+elem+"' encontrado en la posición "+pos);
						System.out.println("Procediendo a eliminar");
						sentido = false;
						o.desplazar(c, sentido, pos, nelem);
						nelem--;
					}
					else {
						System.out.println("Elemento no encontrado");
					}
					break;
				default:
					break;
				}
				System.out.println();
				System.out.println();
				break;
			case 4:
				System.out.println();
				m.mostrar4();
				System.out.println();
				n2 = m.elegir();
				System.out.println();
				
				switch (n2) {
				case 1:
					ascend = true;
					o.burbuja (c, nelem, ascend);
					break;
				case 2:
					ascend = false;
					o.burbuja (c, nelem, ascend);
					break;
				default:
					break;
				}
				if ((n2 == 1) || (n2 == 2)) {
					System.out.println("Vector ordenado");
					orden = true;
				}
				System.out.println();
				System.out.println();
				break;
			case 5:
				for (int i = 0;i < nelem;i++) {
					if ((c[i] == 'A') || (c[i] == 'E') || (c[i] == 'I') || (c[i] == 'O') || (c[i] == 'U') || (c[i] == 'a') || (c[i] == 'e') || (c[i] == 'i') || (c[i] == 'o') || (c[i] == 'u')) {
						sentido = false;
						pos = i;
						o.desplazar(c, sentido, pos, nelem);
						contVocal++;
						i = 0;
					}
				}
				nelem = nelem - contVocal;
				if (contVocal != 0) System.out.println(contVocal+" vocal(es) eliminadas");
				contVocal = 0;
				System.out.println();
				System.out.println();
				break;
			case 6:
				for (int i = 0;i < nelem;i++) {
					if ((c[i] == 'A') || (c[i] == 'E') || (c[i] == 'I') || (c[i] == 'O') || (c[i] == 'U') || (c[i] == 'a') || (c[i] == 'e') || (c[i] == 'i') || (c[i] == 'o') || (c[i] == 'u')) {
						pos = i;
						e.insertar(c, pos);
						contVocal++;
						i = 0;
					}
				}
				if (contVocal != 0) {
					System.out.println(contVocal+" vocal(es) intercambiadas");
					orden = false;
				}
				contVocal = 0;
				System.out.println();
				System.out.println();
				break;
			case 7:
				o.imprimir(c, nelem);
				System.out.println();
				System.out.println();
				break;
			case 8:
				o.contar(nelem);
				System.out.println();
				System.out.println();
				break;
			case 9:
				System.out.println();
				System.out.println("¡Adiós!");
				break;
			default:
				System.out.println();
				System.out.println("Introduce número de elementos a cargar");
				do {
					nelem = sc.nextInt();
					if ((nelem < 0) || (nelem > 30)) {
						System.out.println("ERROR. nº de elementos debe ser mayor o igual que 0 y menor o igual a 30");
					}
				} while ((nelem < 0) || (nelem > 30));
				o.prueba(c, nelem);
				System.out.println("Vector de pruebas cargado");
				System.out.println();
				System.out.println();
				break;
			}
		} while (n1 != 9);
		
		sc.close();
	}
}