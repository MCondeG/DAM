package ejercicios.ej09;

public class Relevo {
	private boolean enMano;
	private int siguiente=1; //variable para controlar el orden de los hilos en la carrera

	public Relevo() {
		enMano = false;
	}

	public synchronized void coger(int nCorredor) throws InterruptedException {
		//se comprueba si el relevo está libre y si es el turno correspondiente al hilo
		while (enMano || nCorredor != siguiente) {
			//en caso de que no se cumplan las dos condiciones se espera a su turno
			wait();
		} 
		//el hilo coge el relevo
		enMano = true;
	}

	public synchronized void dar() {
		//cuando el hilo termina actualiza el turno para el siguiente, y suelta el relevo
		siguiente++;
		enMano = false;
		//se activan todos los hilos que estuvieran esperando para que corra el siguiente según el turno establecido
		notifyAll();
	}
}