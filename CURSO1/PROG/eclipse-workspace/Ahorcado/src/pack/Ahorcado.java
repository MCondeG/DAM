package pack;

import java.util.Scanner;

public class Ahorcado {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Operacion o = new Operacion();
		Pintar p = new Pintar();
		
		String[] palabra = {"AHORCADO","PROGRAMACION","LOBO","MURCIELAGO","UNANIMIDAD","PENSAMIENTO","INTERNET","MUÑECA","SILLA","PERIQUITO","ALBARICOQUE","AYUNTAMIENTO","DESTINO","MINIATURA","PALINDROMO","MAR","ESPEJISMO","ESTOCASTICO","PERRO","COHETE"};
		String palEleg = "";		//palabra elegida aleatoriamente entre la lista de posibles
		String guion = "";			//cadena con guiones y espacios del mismo tamaño que la palabra elegida
		
		int[] posiciones = new int[15];			//array de posiciones acertadas
		
		char letra;					//letra introducida
		int vidas = 7;				//número de intentos
		int contpista = 0;			//contador de pistas
		boolean acierto;			//booleano para marcar un acierto o fallo de letra
		boolean victoria = false;	//booleano para señalar la victoria
		
		palEleg = o.elegir(palabra, palEleg);
		
		System.out.println("¡BIENVENIDO AL AHORCADO!");
		System.out.println();
		p.pintaAhorcado(vidas);
		
		try {					
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			System.err.println("ERROR");
		}
		
		System.out.println();
		System.out.println();
		guion = p.guion(palEleg, guion);
		guion = guion.replace(" ","");
		char[] guion2 = guion.toCharArray();
		
		while ((vidas > 0) && (victoria != true)) {
			
			System.out.println();
			System.out.println("Introduce una letra (SIN TILDE)");
			System.out.println("Para pedir pista introduce '?' (SOLO 1 PISTA POR PARTIDA)");
			letra = sc.nextLine().toUpperCase().charAt(0);
			
			o.inicializar(posiciones);
			
			if ((letra == '?') && (contpista == 0)) {
				contpista = o.pista(guion2, palEleg);
			}
			else {
				while (letra == '?') {
					System.out.println();
					System.out.println();
					System.out.println("SOLO 1 PISTA POR PARTIDA");
					System.out.println("Introduce una letra (SIN TILDE)");
					letra = sc.nextLine().toUpperCase().charAt(0);
				}
				
				acierto = false;
				acierto = o.comparar(palEleg, letra, posiciones, acierto);
				
				if (acierto) {
					o.cambiar(posiciones, guion2, letra);			
				}
				else {
					System.out.println();
					System.out.println("la letra \""+letra+"\" no es correcta");
					System.out.println();
					vidas--;
					p.pintaAhorcado(vidas);
				}
			}
			
			System.out.println();
			System.out.println();
			
			if (vidas > 0) {
				p.guion2(guion2);
			}
			
			victoria = o.comprobar(guion2, victoria);
		}
		
		System.out.println();
		
		if (victoria) {
			System.out.println("¡ENHORABUENA! has acertado la palabra \""+palEleg+"\" con "+vidas+" vidas restantes." );
		}
		else {
			char[] palEleg2 = palEleg.toCharArray();
			
			for (int i = 0;i < palEleg2.length;i++) {
				System.out.print(palEleg2[i]+" ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}