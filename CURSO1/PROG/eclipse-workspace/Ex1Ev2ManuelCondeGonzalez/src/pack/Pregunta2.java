package pack;

public class Pregunta2 {
	/*
	public static void mezcla (int[] v1, int[] v2, int[] vmezcla) {
		
		boolean repetido = false;
		int cont = 0;
		
		for (int i = 0; i < v1.length; i++) {
				for (int j = 0;j <= i;j++) {
					if (vmezcla[j] == v1[i]) repetido = true;
					if (!repetido) {
						vmezcla[i] = v1[i];
						cont++;
					}
					repetido = false;
				}
		}
		
		for (int i = 0; i < v2.length; i++) {
			do {
				for (int j = 0;j <= i;j++) {
					if (vmezcla[j] == v2[i]) repetido = true;
					if (!repetido) {
						vmezcla[i] = v2[i];
					}
					repetido = false;
				}
			} while (repetido);
		}
	}
	

	public static void main(String[] args) {
		
		int[] v1 = {2,55,7,100,5,55,12,49,33,1};
		int[] v2 = {55,9,12,50,100,7,41,1,100,100};
		int[] vmezcla = new int[12];
		
		mezcla(v1,v2,vmezcla);
		
		for (int i = 0; i < vmezcla.length; i++) {
			System.out.print(vmezcla[i]+" ");
		}
	}
*/
	
	public static boolean buscar (int[] conj, int elemento) {
		
		for (int i = 0; i < conj.length; i++) {
			if (conj[i] == elemento) return true;
			else return false;
		}
		
		return true;
	}
	
	public static int mezcla (int[] conj1, int[] conj2, int[] conjresultado) {
		
		int cont = 0;
		
		for (int i = 0; i < conj1.length; i++) {
			if (!buscar(conjresultado, conj1[i])) {
				conjresultado[cont] = conj1[i];
				cont++;
			}
		}
		
		for (int i = 0; i < conj1.length; i++) {
			if (!buscar(conjresultado, conj2[i])) {
				conjresultado[cont] = conj2[i];
				cont++;
			}
		}
		
		return cont;
	}
	
	public static void main(String[] args) {
		
		int[] conj1 = {2,55,7,100,5,55,12,49,33,1};
		int[] conj2 = {55,9,12,50,100,7,41,1,100,100};
		int[] conjresultado = new int[20];
		
		int cont = mezcla(conj1, conj2, conjresultado);
		
		
	}
}
