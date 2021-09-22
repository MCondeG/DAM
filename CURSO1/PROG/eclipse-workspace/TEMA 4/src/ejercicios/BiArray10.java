package ejercicios;

public class BiArray10 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		int[][] m1 = new int[3][3];
		int[][] m2 = new int[3][3];
		int[][] mult = new int[3][3];
		
		for (int i = 0;i < m1.length;i++) {
			for (int j = 0;j < m1[i].length;j++) {
				m1[i][j] = (int)((Math.random()*10)+1);
				m2[i][j] = (int)((Math.random()*10)+1);
			}
		}
		
		System.out.println("Matriz A =");
		
		for (int i = 0;i < m1.length;i++) {
			System.out.println("\n\n\n");
			for (int j = 0;j < m1[i].length;j++) {
				System.out.print("\t"+m1[i][j]);
			}
		}
		
		System.out.println("\n\n\n\n\nMatriz B =");
		
		for (int i = 0;i < m1.length;i++) {
			System.out.println("\n\n\n");
			for (int j = 0;j < m1[i].length;j++) {
				System.out.print("\t"+m2[i][j]);
			}
		}
		
		for (int i = 0;i < m1.length;i++) {
			for (int j = 0;j < m1[i].length;j++) {
				for (int k = 0;k < m1.length;k++) {
					mult[i][j] += m1[i][k]*m2[k][j];
				}
			}
		}
		
		System.out.println("\n\n\n\n\nA*B = \n");
		
		for (int i = 0;i < m1.length;i++) {
			System.out.println("\n\n\n");
			for (int j = 0;j < m1[i].length;j++) {
				System.out.print("\t"+mult[i][j]);
			}
		}
	}
}