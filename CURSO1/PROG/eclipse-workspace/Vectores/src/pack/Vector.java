package pack;

import java.util.*;

public class Vector {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Menu m = new Menu();
		Elemento e = new Elemento();
		Operacion o = new Operacion();
		
		int[] n = new int[30];
		
		int n1;
		int n2;
		int pos;				//posicion de los elementos en el vector
		int elem = 0;			//valor de los elementos
		int nelem = 0;			//nº de elementos cargados en el vector
		boolean sentido;		//false para izquierda, true para derecha
		
		System.out.println(" PROYECTO VECTORES");
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
						o.desplazar(n, sentido, pos, nelem);
						e.insertar(n, pos);
						nelem++;
						break;
					case 2:
						pos = nelem;
						e.insertar(n, pos);
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
							o.desplazar(n, sentido, pos, nelem);
						}
						e.insertar(n, pos);
						nelem++;
						break;
					default:
						break;
					}
				}
				else {
					System.out.println("ERROR. Vector completo");
				}
				break;
			case 2:
				System.out.println();
				m.mostrar2();
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
					
					e.insertar(n, pos);
					break;
				case 2:
					System.out.println("Introduce elemento a buscar");
					elem = sc.nextInt();
					pos = e.buscar(n, nelem, elem);
					if (pos >= 0) {
						System.out.println("Elemento "+elem+" encontrado en la posición "+pos);
						e.insertar(n, pos);
					}
					else {
						System.out.println("Elemento no encontrado");
					}
					break;
				default:
					break;
				}
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
					o.desplazar(n, sentido, pos, nelem);
					nelem--;
					break;
				case 2:
					System.out.println("Introduce elemento a buscar");
					elem = sc.nextInt();
					pos = e.buscar(n, nelem, elem);
					if (pos >= 0) {
						System.out.println("Elemento "+elem+" encontrado en la posición "+pos);
						System.out.println("Procediendo a eliminar");
						sentido = false;
						o.desplazar(n, sentido, pos, nelem);
						nelem--;
					}
					else {
						System.out.println("Elemento no encontrado");
					}
					break;
				default:
					break;
				}
				break;
			case 4:
				o.contar(n, nelem);
				break;
			case 5:
				System.out.println();
				m.mostrar5();
				System.out.println();
				n2 = m.elegir();
				System.out.println();
				
				switch (n2) {
				case 1:
					o.burbuja (n, nelem);
					break;
				case 2:
					o.insercion(n, nelem);
					break;
				case 3:
					o.seleccion(n, nelem);
					break;
				default:
					break;
				}
				if (n2 == 1 || n2 == 2 || n2 == 3) {
					System.out.println("¡Vector ordenado!");
					System.out.println();
					System.out.println();
				}
				break;
			case 6:
				o.imprimir(n, nelem);
				System.out.println();
				System.out.println();
				break;
			case 7:
				System.out.println();
				System.out.println("¡Adiós!");
				break;
			default:		
				System.out.println();
				m.mostrardefecto();
				System.out.println();
				n2 = m.elegir();
				System.out.println();
				
				switch (n2) {
				case 1:
					System.out.println("Introduce número de elementos a cargar");
					do {
						nelem = sc.nextInt();
						if ((nelem < 0) || (nelem > 30)) {
							System.out.println("ERROR. nº de elementos debe ser mayor o igual que 0 y menor o igual a 30");
						}
					} while ((nelem < 0) || (nelem > 30));
					o.pruebaordenado(n, nelem);
					System.out.println("Vector de pruebas cargado");
				System.out.println();
				System.out.println();
					break;
				case 2:
					System.out.println("Introduce número de elementos a cargar");
					do {
						nelem = sc.nextInt();
						if ((nelem < 0) || (nelem > 30)) {
							System.out.println("ERROR. nº de elementos debe ser mayor o igual que 0 y menor o igual a 30");
						}
					} while ((nelem < 0) || (nelem > 30));
					o.pruebadesordenado(n, nelem);
					System.out.println("Vector de pruebas cargado");
				System.out.println();
				System.out.println();
					break;
				default:
					break;
				}
			}
		} while (n1 != 7);
		
		sc.close();
	}
}