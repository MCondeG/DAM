package ejercicios;

public class BiArray9 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		int[][] m1 = new int[3][3];
		int[][] m2 = new int[3][3];
		int[][] suma = new int[3][3];
		
		for (int i = 0;i < m1.length;i++) {
			System.out.println("\n\n\n");
			for (int j = 0;j < m1[i].length;j++) {
				m1[i][j] = (int)((Math.random()*10)+1);
				m2[i][j] = (int)((Math.random()*10)+1);
				suma[i][j] = m1[i][j] + m2[i][j];
				System.out.print("\t"+suma[i][j]);
			}
		}
	}
}