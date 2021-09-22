package pack;

public class Elemento {			//clase para gestionar las operaciones con los elementos de la matriz
	
	public void sumafc (int[][] matriz, int nfc, boolean fila) {
		
		int suma = 0;
		
		if (fila) {
			
			for (int j = 0;j < matriz[nfc].length;j++) {
				suma += matriz[nfc][j];
			}
			
			System.out.println("La suma de la fila "+(nfc+1)+" es: "+suma);
		}
		else {
			
			for (int i = 0;i < matriz.length;i++) {
				suma += matriz[i][nfc];
			}
			
			System.out.println("La suma de la columna "+(nfc+1)+" es: "+suma);
		}	
	}
	
	public void sumad (int[][] matriz, boolean diagprinc) {

		int suma = 0;
		
		if (diagprinc) {
			
			for (int i = 0;i < matriz.length;i++) {
				System.out.println("\n\n\n");
				for (int j = 0;j < matriz[i].length;j++) {
					if (i == j) {
						System.out.print(matriz[i][j]+"\t");
						suma += matriz[i][j];
					}
					else {
						System.out.print("\t");
					}
				}
			}
			
			System.out.println("\n");
			System.out.println("La suma de los elementos de la diagonal principal es: "+suma);
		}
		else {
			for (int i = 0;i < matriz.length;i++) {
				System.out.println("\n\n\n");
				for (int j = 0;j < matriz[i].length;j++) {
					if (i + j == (matriz.length - 1)) {
						System.out.print(matriz[i][j]+"\t");
						suma += matriz[i][j];
					}
					else {
						System.out.print("\t");
					}
				}
			}
			
			System.out.println("\n");
			System.out.println("La suma de los elementos de la diagonal inversa es: "+suma);
		}
	}
	
	public void media (int[][] matriz) {
		
		int cont = 0;
		double sumatotal = 0;
		double media;
		
		for (int i = 0;i < matriz.length;i++) {
			for (int j = 0;j < matriz[i].length;j++) {
				sumatotal += matriz[i][j];
				cont++;
			}
		}
		
		media = sumatotal/(double)cont;
		
		System.out.println("La media de los elementos de la matriz es: "+media);
	}

}