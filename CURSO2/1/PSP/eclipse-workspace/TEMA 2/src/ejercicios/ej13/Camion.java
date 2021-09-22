package ejercicios.ej13;

import java.util.ArrayList;
import java.util.Random;

public class Camion extends Thread {
	Random r = new Random();									//Aleatorio usado para usar en los Thread.sleep
	EntradaParking entrada;										//Objeto entrada compartido por todos los hilos para garantiza el acceso concurrente
	ArrayList<PlazaParking> plazaOcupada = new ArrayList<>();	//Plazas ocupadas por el camión cuando está aparcado
	private int idCamion;										//Número de camión
	
	public Camion (int id, EntradaParking e) {
		idCamion = id;
		entrada = e;		
	}
	
	public int getIdCamion() {
		return idCamion;
	}

	public void setIdCamion(int idCamion) {
		this.idCamion = idCamion;
	}

	@Override
	public void run() {
		try {
			//El camion pasa un tiempo circulando antes de intentar aparcar
			ParkingCamion.showMessage("INFO: El camión " + this.getIdCamion() + " está circulando");
			Thread.sleep(r.nextInt(10) * 1_000L);
			
			//Cuando pasa el tiempo en que está circulando llega a la entrada del parking e intenta entrar y aparcar en una plaza
			ParkingCamion.showMessage("INFO: El camión " + this.getIdCamion() + " llega a la entrada del parking");
			plazaOcupada = (ArrayList<PlazaParking>) entrada.getPlazaCamion(this);
			
			//Si obtiene una plaza de aparcamiento se mantiene aparcado urante un tiempo aleatorio
			ParkingCamion.showMessage("ENTRADA: El camión " + this.getIdCamion() + " aparca en la plaza " + plazaOcupada.get(0).getnPlaza());
			Thread.sleep(r.nextInt(10) * 3_000L);
			
			//Una vez pasa el tiempo que está aparcado deja la plaza y sale del parking
			ParkingCamion.showMessage("SALIDA: El camión " + this.getIdCamion() + " sale de la plaza " + plazaOcupada.get(0).getnPlaza());
			entrada.releasePlazaCamion(plazaOcupada);
						
		} catch (InterruptedException e) {
			e.printStackTrace();
			// Restore interrupted state...
		    Thread.currentThread().interrupt();
		}
	}
}
