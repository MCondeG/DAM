package pack;

import java.util.Scanner;

public class Elemento {			//clase con metodos para trabajar con los elementos del vector
	
	Scanner sc3 = new Scanner(System.in);

	public void insertar (int[] n,int pos) {
		
		int elem;
		
		System.out.println("Introduce elemento");
		elem = sc3.nextInt();
		n[pos] = elem;
	}
	
	public int buscar (int[] n, int nelem, int elem) {
		
		int pos = -1;
		int cont = 0;
		boolean flag = false;
		
		while ((flag == false) && (cont < nelem)) {
			if (n[cont] == elem) {
				pos = cont;
				flag = true;
			}
			cont++;
		}
		
		return (pos);
	}
}