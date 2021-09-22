package pack;

import java.util.Scanner;

public class Pregunta2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n;
		int m = 0;
		
		do {
			System.out.println("Introduce un n�mero natural");
			n = sc.nextInt();
			
			if (n >= 0) {
				System.out.println("Divisores:");
				for (int i = 1;i<n;i++) {
					if (n%i == 0) {
						m = m + i; //m guarda la suma de los divisores de n para comparar posteriormente
						System.out.print(i+" ");
					}
				}
				if (n == m) {
					System.out.println(". El n�mero "+n+" SI es un n�mero perfecto");
				}
				else {
					System.out.println(". El n�mero "+n+" NO es un n�mero perfecto");
				}
				m = 0;
				System.out.println();	
			}
			else {
				System.out.println("NEGATIVO. FIN DE LA EJECUCI�N");
			}
		} while (!(n<0));
		
		sc.close();
	}
}