package ejercicios;

public class Array3 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		int[] num = new int[20];
		int[] cuad = new int[20];
		int[] cubo = new int[20];
		
		for (int i = 0;i < num.length;i++) {
			num[i] = (int)(Math.random()*101);
			cuad[i] = (int)Math.pow(num[i],2);
			cubo[i] = (int)Math.pow(num[i],3);
		}
		
		for (int i = 0;i < num.length;i++) {
			System.out.println(num[i]+"     "+cuad[i]+"     "+cubo[i]);
		}
	}
}