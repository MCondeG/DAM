package ejercicios;

public class Random1 {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente

		int n;
		int max = 0;
		int min = 1000;
		
		for (int i = 1;i<=50;i++) {
			n = (int)(Math.random()*100+100);
			System.out.print(n+" ");
			if (n>max) {
				max = n;
			}
			if (n<min) {
				min = n;
			}
		}
		double media = ((double)min+(double)max)/2;
		
		System.out.println("");
		System.out.println("El m�nimo es "+min+" y el m�ximo es "+max);
		System.out.println("La media es "+media);	
	}
}