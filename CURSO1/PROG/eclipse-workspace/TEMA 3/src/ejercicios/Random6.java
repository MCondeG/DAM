package ejercicios;

public class Random6 {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
		int cont = 1;
		int n,m;
		
		do {
			System.out.println("Tirada de 2 dados n�mero "+cont);
			n = (int)(Math.random()*6+1);
			m = (int)(Math.random()*6+1);
			System.out.println(n+" "+m);
			System.out.println();
			cont++;
		} while (n != m);
	}
}