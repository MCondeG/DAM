package ejemplos;

import java.util.Scanner;

public class Serie1 {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce cuantos terminos de la sucesi�n quieres ver");
		int n = sc.nextInt();
		System.out.println();
		
		long an = 4;
		
		for (int i = 1;i<=n;i++) {
			System.out.print(an+" ");
			an = (3*an)+2;
		}
	}
}