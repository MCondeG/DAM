package ejercicios;

public class Random3 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		int n,m;
		
		for (int i = 1;i<=10;i++) {
			n = (int)(Math.random()*6+1);
			m = (int)(Math.random()*40+1);
			switch (n) {
			case 1:
				for (int e = 1;e <= m;e++) {
					System.out.print("*");
				}
				break;
			case 2:
				for (int e = 1;e <= m;e++) {
					System.out.print("-");
				}
				break;
			case 3:
				for (int e = 1;e <= m;e++) {
					System.out.print("=");
				}
				break;
			case 4:
				for (int e = 1;e <= m;e++) {
					System.out.print(".");
				}
				break;
			case 5:
				for (int e = 1;e <= m;e++) {
					System.out.print("|");
				}
				break;
			case 6:
				for (int e = 1;e <= m;e++) {
					System.out.print("@");
				}
				break;
			default:
				break;
			}
			System.out.println();
		}
	}
}