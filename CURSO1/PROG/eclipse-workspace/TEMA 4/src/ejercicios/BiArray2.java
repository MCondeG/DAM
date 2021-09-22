package ejercicios;

public class BiArray2 {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
		int[][] matriz = new int[4][5];
		int[] sumaf = new int[4];
		int[] sumac = new int[5];
		int sumatotal = 0;
		
		for (int i = 0;i < matriz.length;i++) {
			for (int j = 0;j < matriz[i].length;j++) {
				matriz[i][j] = (int)((Math.random()*900)+100);
			}
		}
		
		for (int i = 0;i < matriz.length;i++) {
			for (int j = 0;j < matriz[i].length;j++) {
				sumaf[i] += matriz[i][j];
				sumac[j] += matriz[i][j];
				sumatotal += matriz[i][j];
			}
		}
		
		for (int i = 0;i < matriz.length;i++) {
			System.out.println("\n\n");
			for (int j = 0;j < matriz[i].length;j++) {
				System.out.print(matriz[i][j]+"\t");
				if (j == 4) {
					System.out.println(sumaf[i]);
				}
			}
		}
		System.out.println("\n\n");
		for (int i = 0;i < sumac.length;i++) {
			System.out.print(sumac[i]+"\t");
		}
		System.out.println(sumatotal);
	}	
}