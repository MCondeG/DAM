package ejercicios;

import java.util.Scanner;

public class ConjExcepciones3 {
	
	static Scanner sc2 = new Scanner(System.in);
	
	private Nombre[] conjN = new Nombre[6];
	private static int nElem = 0;
	
	public ConjExcepciones3() {
		
	}

	public Nombre[] getConjN() {
		return conjN;
	}

	public static int getnElem() {
		return nElem;
	}

	public void setConjN(Nombre[] conjN) {
		this.conjN = conjN;
	}


	public void añadir () throws TooLargeNameException, TamExcedidoException {
		
		if (nElem == 6) throw new TamExcedidoException("ERROR. Tamaño excedido");
		else {
			String nom;
			
			Nombre n = new Nombre();
			System.out.println("\nIntroduce el nombre");
			nom = sc2.next();
			
			if (nom.length() > 20) throw new TooLargeNameException("ERROR. Nombre demasiado largo");
			else {
				n.setNombre(nom);
				System.out.println("\nIntroduce el código");
				n.setCodigo(sc2.nextInt());
				this.conjN[nElem] = n;
				nElem++;
			}
		}
	}
	
	public void ordenar () {
		
		Nombre aux = new Nombre();
		
		for(int i = 0; i < nElem - 1; i++) {
            for(int j = 0; j < nElem - 1; j++) {
                if (this.conjN[j].getNombre().compareToIgnoreCase(this.conjN[j+1].getNombre()) > 0) {
                    aux = this.conjN[j+1];
                    this.conjN[j+1] = this.conjN[j];
                    this.conjN[j] = aux;
                }
            }
        }
	}
	
	public void listar () {
		
		ordenar();
		
		for (int i = 0; i < nElem; i++) {
			System.out.println(conjN[i].getNombre()+", "+conjN[i].getCodigo());
		}
	}
}
