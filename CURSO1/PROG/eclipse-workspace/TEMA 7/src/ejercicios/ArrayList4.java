package ejercicios;

import java.util.*;

public class ArrayList4 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> a = new ArrayList<String>();
		
		for (int i = 0; i < 10; i++) {
			a.add(sc.nextLine());
		}
		
		a.sort(null);
		
		for (int i = 0; i < 10; i++) {
			System.out.println(a.get(i));
		}
		
		sc.close();
	}
}