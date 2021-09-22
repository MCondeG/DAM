package ejercicios;

public class BiArray4 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		int[][] matriz = new int[6][10];
		int min = 1000;
		int max = 0;
		int filamin = 0;
		int colmin = 0;
		int filamax = 0;
		int colmax = 0;
		
		for (int i = 0;i < matriz.length;i++) {
			for (int j = 0;j < matriz[i].length;j++) {
				matriz[i][j] = (int)(Math.random()*1001);
			}
		}
		
		for (int i = 0;i < matriz.length;i++) {
			System.out.println("\n\n");
			for (int j = 0;j < matriz[i].length;j++) {
				System.out.print(matriz[i][j]+"\t");
				if (matriz[i][j] < min ) {
					filamin = i;
					colmin = j;
					min = matriz[i][j];
				}
				if (matriz[i][j] > max) {
					filamax = i;
					colmax = j;
					max = matriz[i][j];
				}
			}
		}
		
		System.out.println("\n\n\n");
		System.out.println("El mínimo es: "+min+" y el máximo es: "+max);
		System.out.println("El mínimo se encuentra en la posición "+(filamin+1)+","+(colmin+1));
		System.out.println("El máximo se encuentra en la posición "+(filamax+1)+","+(colmax+1));
	}
}