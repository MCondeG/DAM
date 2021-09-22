package pack;

public class Pregunta3 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		int[][] mapa = new int[3][3];
		int[][] mapaActualizado = new int[3][3];
		int[][] posiciones = {{0,2},{1,1},{2,0}};
 		int cont = 1;
		
		for (int i = 0;i < mapa.length;i++) {
			for (int j = 0;j < mapa[i].length;j++) {
				mapa[i][j] = cont;
				mapaActualizado[i][j] = cont;
				cont++;
			}
		}
		
		mapaActualizado[posiciones[0][0]][posiciones[0][1]] = -99;
		mapaActualizado[posiciones[1][1]][posiciones[1][1]] = -99;
		mapaActualizado[posiciones[2][0]][posiciones[2][1]] = -99;
		
		System.out.println("\tMapa");
		
		for (int i = 0;i < mapa.length;i++) {
			System.out.println();
			for (int j = 0;j < mapa[i].length;j++) {
				System.out.print(mapa[i][j]+"\t");		
			}
		}
		
		System.out.println("\n\n\n\tPosiciones");
		
		for (int i = 0;i < posiciones.length;i++) {
			System.out.println();
			for (int j = 0;j < posiciones[i].length;j++) {
				System.out.print(posiciones[i][j]+"\t");		
			}
		}
		
		System.out.println("\n\n\n\tMapaActualizado");
		
		for (int i = 0;i < mapaActualizado.length;i++) {
			System.out.println();
			for (int j = 0;j < mapaActualizado[i].length;j++) {
				System.out.print(mapaActualizado[i][j]+"\t");		
			}
		}
	}

}
