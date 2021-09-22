package ejercicios;

public class BiArray6 {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente

		int min = 1000;
		int max = 0;
		int suma = 0;
		int media;
		int[][] matriz = new int[10][10];
		
		for (int i = 0;i < matriz.length;i++) {
			for (int j = 0;j < matriz[i].length;j++) {
				matriz[i][j] = (int)((Math.random()*101)+200);
			}
		}
		
		for (int i = 0;i < matriz.length;i++) {
			System.out.println("\n\n");
			for (int j = 0;j < matriz[i].length;j++) {
				if (i == j) {
					System.out.print(matriz[i][j]+"\t");
					min = Math.min(min, matriz[i][j]);
					max = Math.max(max, matriz[i][j]);
					suma += matriz[i][j];
				}
				else {
					System.out.print("\t");
				}
			}
		}
		
		media = suma/10;
		System.out.println("\n\n");
		System.out.println("El m�nimo es: "+min+" y el m�ximo es: "+max);
		System.out.println("La media de los elementos de la diagonal es: "+media);
	}
}