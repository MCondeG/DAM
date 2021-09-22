package pack;

import java.util.Scanner;

public class Pregunta1 {
	
	public static int NumCifras (long n) { //subprograma que devuelve el numero de cifras de n
		
		int cifras = 1;
		
		while (n >= 10) {
			n = n/10;
			cifras++;
		}
		return cifras;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		long n,naux;
		long n2 = 0; 
		long a = 0; //cifra concreta de cada iteración del bucle
		int d = 10;
		boolean signo = false;
		
		System.out.println("Introduce un número entero");
		n = sc.nextLong();
		
		if (n<0) {
			signo = true;
			n = Math.abs(n);
		}
		
		int cifras = NumCifras(n);
		int cont = cifras;
		
		while (cont > 0) {
			naux = (n/d)*d; //trunca la variable y añade un 0 al final
			a = (n - naux)/(d/10); //restando la variable original aislamos el dígito que buscamos
			n2 = n2 + (a*(int)Math.pow(10, cont-1)); //contruimos el número al revés
			d = d*10;
			cont--;
		}
		
		if (signo) {	//cambia de signo si negativo
			n2 = -n2;
		}
		
		System.out.println(n2);
		
		sc.close();
	}
}