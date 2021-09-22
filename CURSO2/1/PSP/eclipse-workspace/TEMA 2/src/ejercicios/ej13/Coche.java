package ejercicios.ej13;

import java.util.Random;


public class Coche extends Thread {
	Random r = new Random(); 			//Aleatorio usado para usar en los Thread.sleep
	EntradaParking entrada;  			//Objeto entrada compartido por todos los hilos para garantiza el acceso concurrente
	PlazaParking plazaOcupada = null;	//Plaza ocupada por el coche cuando está aparcado
	private int idCoche;				//Número de coche
	
	public Coche (int id, EntradaParking e) {
		idCoche = id;
		entrada = e;
	}
	
	public int getIdCoche() {
		return idCoche;
	}

	public void setIdCoche(int idCoche) {
		this.idCoche = idCoche;
	}

	@Override
	public void run() {
		try {
			//El coche pasa un tiempo circulando antes de intentar aparcar
			ParkingCamion.showMessage("INFO: El coche " + this.getIdCoche() + " está circulando");
			Thread.sleep(r.nextInt(10) * 1_000L);
			
			//Cuando pasa el tiempo en que está circulando llega a la entrada del parking e intenta entrar y aparcar en una plaza
			ParkingCamion.showMessage("INFO: El coche " + this.getIdCoche() + " llega a la entrada del parking");
			plazaOcupada = entrada.getPlazaCoche(this);
			
			//Si obtiene una plaza de aparcamiento se mantiene aparcado urante un tiempo aleatorio
			ParkingCamion.showMessage("ENTRADA: El coche " + this.getIdCoche() + " aparca en la plaza " + plazaOcupada.getnPlaza());
			Thread.sleep(r.nextInt(10) * 3_000L);
			
			//Una vez pasa el tiempo que está aparcado deja la plaza y sale del parking
			ParkingCamion.showMessage("SALIDA: El coche " + this.getIdCoche() + " sale de la plaza " + plazaOcupada.getnPlaza());
			entrada.releasePlazaCoche(plazaOcupada);
						
		} catch (InterruptedException e) {
			e.printStackTrace();
			// Restore interrupted state...
		    Thread.currentThread().interrupt();
		}
	}
}
