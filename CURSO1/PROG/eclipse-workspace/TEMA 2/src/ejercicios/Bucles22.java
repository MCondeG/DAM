package ejercicios;

import java.util.Scanner;

public class Bucles22 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un entero positivo");

		int n = sc.nextInt();

		long fact = 1;

		if (n>0){	
			for (int i = n;i>1;i--){
				fact = fact*i;
			}
			System.out.println(n+"! = "+fact);
		}
		else if (n == 0){
			System.out.println("0! = "+fact);
		}
		else{
			System.out.println("ERROR");
		}
	}
}