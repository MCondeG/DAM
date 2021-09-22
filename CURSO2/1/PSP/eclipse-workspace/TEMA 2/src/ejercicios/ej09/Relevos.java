package ejercicios.ej09;

public class Relevos {

	public static void main(String[] args) throws InterruptedException {
		Relevo rel = new Relevo();
		Corredor[] corredores = new Corredor[4];
		for (int i = 0; i < corredores.length; i++) {
			corredores[i] = new Corredor(rel, i+1);
		}
		System.out.println("Todos los hilos creados");
		System.out.println("Doy la salida");
		corredores[3].start();
		corredores[2].start();
		corredores[1].start();
		corredores[0].start();
		
		for (int i = 0; i < corredores.length; i++) {
			corredores[i].join();
		}
		
		System.out.println("Todos los corredores han finalizado");
	}

}