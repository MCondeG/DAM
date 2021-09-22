package ejercicios;

import java.util.*;

public class ArrayList3 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			a.add(sc.nextInt());
		}
		
		Collections.sort(a);
		
		for (int i = 0; i < 10; i++) {
			System.out.println(a.get(i));
		}
		
		sc.close();
	}
}