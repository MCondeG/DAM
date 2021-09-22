package ejercicios;

public class Random4 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		int n;
		int sus = 0;
		int suf = 0;
		int bien = 0;
		int not = 0;
		int sob = 0;
		
		for (int i = 1;i <= 20;i++) {
			n = (int)(Math.random()*5+1);
			switch (n) {
			case 1:
				System.out.println("Suspenso");
				sus++;
				break;
			case 2:
				System.out.println("Suficiente");
				suf++;
				break;
			case 3:
				System.out.println("Bien");
				bien++;
				break;
			case 4:
				System.out.println("Notable");
				not++;
				break;
			case 5:
				System.out.println("Sobresaliente");
				sob++;
				break;
			default:
				break;
			}
		}
		System.out.println();
		System.out.println("Suspenso: "+sus);
		System.out.println("Suficiente: "+suf);
		System.out.println("Bien: "+bien);
		System.out.println("Notable: "+not);
		System.out.println("Sobresaliente: "+sob);
	}
}