package pack;

public class Pregunta2 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		
		int[] v = {5,8,3,1,1,5,9,8,7,6};
		int[] aux = {5,8,3,1,1,5,9,8,7,6};
		int cont = 0;
		
		System.out.println("Vector original:");
		for (int i = 0;i < v.length;i++) {
			System.out.print(v[i]+" ");
		}
		

		
		for (int i = 0;i < v.length;i++) {
			for (int j = 0;j < i;j++) {
				if (v[i] == v[j]) {
					v[i] = 0;
				}
			}
		}
		
		for (int i = 0;i < v.length;i++) {
			if (v[i] == 0) {
				cont++;
			}
		}
		
		for (int i = 0;i < v.length;i++) {
			if (v[i] == 0) {
				for (int j = i;i < v.length-i-2;j++) {
					v[j] = aux[j+1];
				}
			}
		}
		
		System.out.println("\nVector sin elementos repetidos. Han quedado "+(v.length-cont)+" elementos");
		
		for (int i = 0;i < v.length;i++) {
			System.out.print(v[i]+" ");
		}
	}
}


