package ejercicios.ej13;

import java.util.ArrayList;
import java.util.Random;

public class Camion extends Thread {
	Random r = new Random();									//Aleatorio usado para usar en los Thread.sleep
	EntradaParking entrada;										//Objeto entrada compartido por todos los hilos para garantiza el acceso concurrente
	ArrayList<PlazaParking> plazaOcupada = new ArrayList<>();	//Plazas ocupadas por el cami�n cuando est� aparcado
	private int idCamion;										//N�mero de cami�n
	
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
			ParkingCamion.showMessage("INFO: El cami�n " + this.getIdCamion() + " est� circulando");
			Thread.sleep(r.nextInt(10) * 1_000L);
			
			//Cuando pasa el tiempo en que est� circulando llega a la entrada del parking e intenta entrar y aparcar en una plaza
			ParkingCamion.showMessage("INFO: El cami�n " + this.getIdCamion() + " llega a la entrada del parking");
			plazaOcupada = (ArrayList<PlazaParking>) entrada.getPlazaCamion(this);
			
			//Si obtiene una plaza de aparcamiento se mantiene aparcado urante un tiempo aleatorio
			ParkingCamion.showMessage("ENTRADA: El cami�n " + this.getIdCamion() + " aparca en la plaza " + plazaOcupada.get(0).getnPlaza());
			Thread.sleep(r.nextInt(10) * 3_000L);
			
			//Una vez pasa el tiempo que est� aparcado deja la plaza y sale del parking
			ParkingCamion.showMessage("SALIDA: El cami�n " + this.getIdCamion() + " sale de la plaza " + plazaOcupada.get(0).getnPlaza());
			entrada.releasePlazaCamion(plazaOcupada);
						
		} catch (InterruptedException e) {
			e.printStackTrace();
			// Restore interrupted state...
		    Thread.currentThread().interrupt();
		}
	}
}
