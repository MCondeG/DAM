package ejercicios;

public class Array1 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		int[] num = new int[12];
		
		num[0] = 1;
		num[2] = 66;
		num[3] = 7; 
		num[7] = 47;
		num[10] = 2;
		
		for (int i = 0;i < num.length;i++) {
			System.out.print(num[i]+" "); //los elementos del array no inicializados toman el valor 0
		}
	}

}
