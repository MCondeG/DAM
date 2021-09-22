package pack;

import java.util.Scanner;

public class Elemento {			//clase con metodos para trabajar con los elementos del vector
	
	Scanner sc3 = new Scanner(System.in);

	public void insertar (char[] c,int pos) {
		
		char elem;
		
		System.out.println("Introduce elemento");
		elem = sc3.nextLine().charAt(0);
		c[pos] = elem;
	}
	
	public int buscar (char[] c, int nelem, char elem) {							//busqueda desordenada
		
		int pos = -1;
		int cont = 0;
		boolean flag = false;
		
		while ((flag == false) && (cont < nelem)) {
			if (c[cont] == elem) {
				pos = cont;
				flag = true;
			}
			cont++;
		}
		
		return (pos);
	}
	
	public int busquedaBinaria(char c[], int nelem, char elem, boolean ascend) {	//busqueda ordenada
		
		int pos = -1;
		int centro;
		int inf = 0;
		int sup = nelem - 1;
		boolean flag = false;
		
		if (ascend) {									//busqueda binaria si el vector está ordenado ascendentemente
			while((inf <= sup) && (flag == false)){
				centro = (sup+inf)/2;
				if (c[centro] == elem) {
					pos = centro;
					flag = true;
				}
				else if(elem < c[centro]) {
					sup = centro - 1;
				}
				else {
					inf = centro + 1;
				}
			}
		}
		else {											//busqueda binaria si el vector está ordenado descendentemente
			while((inf <= sup) && (flag == false)){
				centro = (sup+inf)/2;
				if (c[centro] == elem) {
					pos = centro;
					flag = true;
				}
				else if(elem > c[centro]) {
					sup = centro - 1;
				}
				else {
					inf = centro + 1;
				}
			}
		}
		
		return (pos);
	}
}