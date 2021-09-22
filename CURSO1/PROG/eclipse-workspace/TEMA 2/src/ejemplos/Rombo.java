package ejemplos;

import java.util.Scanner;

public class Rombo {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce la altura del rombo");
		int h = sc.nextInt();
		int i = 1;
		int j = 1;
		
		while (i<=(h/2)+1) {
			while (j<=(h/2)-i+1) {
				System.out.print(" ");
				j++;
			}
			j = 1;
			while (j<=(i*2-1)) {
				System.out.print("*");
				j++;
			}
			j = 1;
			System.out.println();
			i++;
		}
		i = 1;
		j = 1;
		while (i<=(h/2)) {
			while (j<=i) {
				System.out.print(" ");
				j++;
			}
			j = 1;
			while (j <= (h-(2*i))) {
				System.out.print("*");
				j++;
			}
			System.out.println();	
			i++;
			j = 1;
		}
	}
}