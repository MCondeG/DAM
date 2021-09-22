package ejemplos;

import java.util.Scanner;

public class Serie2 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce cuantos terminos de la sucesión quieres ver");
		int n = sc.nextInt();
		System.out.println();
		
		long a1 = 1;
		long a2 = 2;
		long a3 = 3;
		long an = (a1*a3)+1;
		
		System.out.print(a1+" "+a2+" "+a3+" ");
		
		for (int i = 1;i<=n-3;i++) {
			System.out.print(an+" ");
			a1 = a2;
			a2 = a3;
			a3 = an;
			an = (a1*a3)+1;
		}
	}
}