package pack;

public class Operacion {		//clase con metodos para operar con el vector en su conjunto
	
	public char[] aux = new char[31];
	
	public void contar (int nelem) {
			
			System.out.println();
			System.out.println("Hay "+nelem+" elementos en el vector");
			if (nelem == 30) {
				System.out.println("Vector completo");
			}
		}
	
	public void imprimir (char[] c, int nelem) {
		
		for (int i = 0; i < nelem;i++) {
			System.out.print(c[i]+" ");
		}
		
		contar(nelem);
	}
	
	public void copiar (char[] c) {
		
		for (int i = 0;i < c.length;i++) {
			aux[i] = c[i];
		}
	}
	
	public void prueba (char[] c, int nelem) {
		
		int nrandom;
		
		for (int i = 0;i < nelem;i++) {
			nrandom = (int)((Math.random()*222)+33);
			c[i] = (char)nrandom;
		}
	}
	
	public void desplazar (char[] c, boolean sentido, int pos, int nelem) {
		
		copiar(c);
		
		if (sentido) {								//desplazar a la derecha
			for (int i = pos;i < nelem;i++) {
				c[i+1] = aux[i];
			}
		}
		else {										//desplazar a la izquierda
			for (int i = pos;i < nelem;i++) {
				c[i] = aux[i+1];
			}
			
		}
	}
	
	public void burbuja (char[] c, int nelem, boolean ascend) {
		
		char caux;
		
		if (ascend) {									//burbuja para ordenar ascendentemente
			for (int i = 0;i < nelem;i++) {
				for (int j = 0;j < nelem;j++) {
					if ((j < nelem - 1) && (c[j] > c[j+1])) {
						caux = c[j];
						c[j] = c[j+1];
						c[j+1] = caux;
					}
				}
			}	
		}
		else {											//burbuja para ordenar descendentemente
			for (int i = 0;i < nelem;i++) {
				for (int j = 0;j < nelem;j++) {
					if ((j < nelem - 1) && (c[j] < c[j+1])) {
						caux = c[j];
						c[j] = c[j+1];
						c[j+1] = caux;
					}		
				}
			}
		}
	}
}