package pack;

public class Pintar {
	
	public String guion (String palEleg, String guion) {	//pinta los guiones vacios
		
		for (int i = 0;i < palEleg.length();i++) {
			guion = guion.concat("_ ");
		}
		
		System.out.println(guion);
		
		return guion;
	}
	
	public void guion2 (char[] guion2) {		//pinta los guiones con al menos una letra acertada
		
		for (int i = 0;i < guion2.length;i++) {
			System.out.print(guion2[i]+" ");
		}
		System.out.println();
	}
	
	public void pintaAhorcado (int vidas) {		//pinta el estado del ahorcado en funcion de las vidas
		
		switch (vidas) {
		case 7:
			System.out.println("     ____ ");
			System.out.println("         |");
			System.out.println("         |");
			System.out.println("         |                    TIENES");
			System.out.println("         |                    "+vidas+" VIDAS");
			System.out.println("         |");
			System.out.println("         |");
			System.out.println("         |");
			System.out.println("_________|___");
			break;
		case 6:
			System.out.println("     ____ ");
			System.out.println("    |    |");
			System.out.println("    |    |");
			System.out.println("         |                    TIENES");
			System.out.println("         |                    "+vidas+" VIDAS");
			System.out.println("         |");
			System.out.println("         |");
			System.out.println("         |");
			System.out.println("_________|___");
			break;
		case 5:
			System.out.println("     ____ ");
			System.out.println("    |    |");
			System.out.println("    |    |");
			System.out.println("    O    |                    TE QUEDAN");
			System.out.println("         |                     "+vidas+" VIDAS");
			System.out.println("         |");
			System.out.println("         |");
			System.out.println("         |");
			System.out.println("_________|___");
			break;
		case 4:
			System.out.println("     ____ ");
			System.out.println("    |    |");
			System.out.println("    |    |");
			System.out.println("    O    |                    TE QUEDAN");
			System.out.println("    |    |                     "+vidas+" VIDAS");
			System.out.println("    |    |");
			System.out.println("         |");
			System.out.println("         |");
			System.out.println("_________|___");
			break;
		case 3:
			System.out.println("     ____ ");
			System.out.println("    |    |");
			System.out.println("    |    |");
			System.out.println("    O    |                    TE QUEDAN");
			System.out.println("   /|    |                     "+vidas+" VIDAS");
			System.out.println("    |    |");
			System.out.println("         |");
			System.out.println("         |");
			System.out.println("_________|___");
			break;
		case 2:
			System.out.println("     ____ ");
			System.out.println("    |    |");
			System.out.println("    |    |");
			System.out.println("    O    |                    TE QUEDAN");
			System.out.println("   /|\\   |                     "+vidas+" VIDAS");
			System.out.println("    |    |");
			System.out.println("         |");
			System.out.println("         |");
			System.out.println("_________|___");
			break;
		case 1:
			System.out.println("     ____ ");
			System.out.println("    |    |");
			System.out.println("    |    |");
			System.out.println("    O    |                    TE QUEDA");
			System.out.println("   /|\\   |                     "+vidas+" VIDA");
			System.out.println("    |    |");
			System.out.println("   /     |");
			System.out.println("         |");
			System.out.println("_________|___");
			break;
		case 0:
			System.out.println();
			System.err.println("     ____ ");
			System.err.println("    |    |");
			System.err.println("    |    |");
			System.err.println("    O    |                    ¡ESTÁS");
			System.err.println("   /|\\   |                    MUERTO!");
			System.err.println("    |    |");
			System.err.println("   / \\   |");
			System.err.println("         |");
			System.err.println("_________|___");
			break;
		default:
			break;
		}
	}
}