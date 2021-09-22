package ejercicios;

public class Funciones3 {
	
	public static int[] filtraPrimos (int[] v, int[] primos) {
		
		int cont = 0;
		boolean p = true;
		
		for (int i = 0;i < v.length;i++) {
			if (v[i] == 0 || v[i] == 1) p = false;
			else {
				for (int j = 2;j < v[i];j++) {
					if (v[i]%j == 0) p = false;
				}
				if (p) {
					primos[cont] = v[i];
					cont++;
				}
				p = true;
			}	
		}
		
		return primos;
	}
	
	public static int cuentaPrimos (int[] v) {
		
		int cont = 0;
		boolean p = true;
		
		for (int i = 0;i < v.length;i++) {
			if (v[i] == 0 || v[i] == 1) p = false;
			else {
				for (int j = 2;j < v[i];j++) {
					if (v[i]%j == 0) p = false;
				}
				if (p) cont++;
				p = true;
			}
		}
			
		return cont;
	}

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		int[] v = new int [100];
		int n;
		
		for (int i = 0;i < v.length;i++) {
			v[i] = (int)(Math.random()*101);
		}
		
		n = cuentaPrimos(v);
		
		if (n == 0) {
			System.out.println("No existe ningún primo en el vector");
		}
		else {
			int[] primos = new int[n];
			
			primos = filtraPrimos(v, primos);
			
			for (int i = 0;i < primos.length;i++) {
				System.out.print(primos[i]+" ");
			}	
		}
	}
}