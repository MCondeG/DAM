package pack;

import java.util.Scanner;

public class Matriz {

	public static void main(String[] args) throws InterruptedException {
	
		Scanner sc = new Scanner(System.in);
		Menu m = new Menu();
		Elemento e = new Elemento();
		Operacion o = new Operacion();
		
		int[][] matriz = new int[4][4];
		int[][] aux = new int[4][4];
		
		int n;
		int nfc;				//numero de fila o columna
		boolean fila;			//true para filas, false para columnas
		boolean diagprinc;		//true para diagonal principal, false para diagonal inversa
		
		System.out.println(" PROYECTO MATRIZ");
		System.out.println("_________________");
		
		do {
			m.mostrar();
			n = sc.nextInt();
			
			System.out.println("\n");
			
			switch (n) {
			case 1:
				o.rellenar(matriz);
				Thread.sleep(2000);
				System.out.println("\n");
				break;
			case 2:
				System.out.println("Introduce la fila a sumar (1 a 4)");
				
				do {
					nfc = sc.nextInt();
					if ((nfc < 1) || (nfc > 4)) System.err.println("ERROR. Introduzca fila válida (1 a 4)");
				} while ((nfc < 1) || (nfc > 4));
				
				System.out.println();
				nfc--;					//para poder trabajar con los valores reales de la fila (0 a 3)
				fila = true;
				e.sumafc(matriz, nfc, fila);
				System.out.println("\n");
				break;
			case 3:
				System.out.println("Introduce la columna a sumar (1 a 4)");
				
				do {
					nfc = sc.nextInt();
					if ((nfc < 1) || (nfc > 4)) System.err.println("ERROR. Introduzca columna válida (1 a 4)");
				} while ((nfc < 1) || (nfc > 4));
				
				System.out.println();
				nfc--;					//para poder trabajar con los valores reales de la columna (0 a 3)
				fila = false;
				e.sumafc(matriz, nfc, fila);
				System.out.println("\n");
				break;
			case 4:
				diagprinc = true;
				e.sumad(matriz, diagprinc);
				System.out.println("\n");
				break;
			case 5:
				diagprinc = false;
				e.sumad(matriz, diagprinc);
				System.out.println("\n");
				break;
			case 6:
				e.media(matriz);
				System.out.println("\n");
				break;
			case 7:
				o.trasponer(matriz, aux);
				System.out.println("\n");
				break;
			case 8:
				o.tabla(matriz);
				System.out.println("\n");
				break;
			case 9:
				System.out.println("\n¡Adios!");
				break;
			default:
				o.prueba(matriz);
				System.out.println("\n");
				break;	
			}
		} while (n != 9);
		
		sc.close();
	}
}