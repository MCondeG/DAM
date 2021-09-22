package ejercicios;

import java.util.Scanner;

public class Condicionales7 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Introduce 3 notas");
		
		double n1 = s.nextDouble();
		double n2 = s.nextDouble();
		double n3 = s.nextDouble();
		
		double media = (n1+n2+n3)/3.0;
		
		if (n1>=0 && n1<=10 && n2>=0 && n2<=10 && n3>=0 && n3<=10) {
			if (media>=5 && media<6) {
				System.out.println("Suficiente");
			}
			else if (media>=6 && media<8) {
				System.out.println("Bien");
			}
			else if (media>=8 && media<9) {
				System.out.println("Notable");
			}
			else if (media>=9) {
				System.out.println("Sobresaliente");
			}
			else {
				System.out.println("Insuficiente");
			}	
		}
		else {
			System.out.println("ERROR");
		}

	}

}
