package ejercicios.ej13;

import java.util.ArrayList;
import java.util.List;

public class EntradaParking {
	Object entradaCoches = new Object();	//Objeto usado como "control" para el acceso de coches
	Object entradaCamiones = new Object();	//Objeto usado como "control" para el acceso de camiones
	
	//Método para asignar una plaza de aparcamiento a un coche
	public PlazaParking getPlazaCoche(Coche c) {
		PlazaParking plaza = null;
		
		try {
			//Bloque sincronizado con el control del acceso de coches
			synchronized (entradaCoches) {	
				//Si el parking no tiene plazas disponibles se duerme el hilo y se incrementa el contador de coches en espera hasta que se libere una plaza
				while ((plaza = ParkingCamion.getPlazaCoche()) == null) {
					ParkingCamion.cocheEsperando++;
					entradaCoches.wait();
					ParkingCamion.cocheEsperando--;
				}
				
				//Cuando queda una plaza libre la ocupa un coche
				plaza.setOcupado(true);
				plaza.setCocheAparcado(c);
	
				ParkingCamion.mostrarParking();
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
			Thread.currentThread().interrupt();
		}
		
		return plaza;
	}
	
	//Método para asignar dos plazas de aparcamiento a un camión
	public List<PlazaParking> getPlazaCamion (Camion c) {
		ArrayList<PlazaParking> plazas = null;
		
		try {
			//Bloque sincronizado con el control del acceso de camiones
			synchronized (entradaCamiones) {
				//Si el parking no tiene plazas disponibles se duerme el hilo y se incrementa el contador de camiones en espera hasta que se libere una plaza
				while ((plazas = (ArrayList<PlazaParking>) ParkingCamion.getPlazaCamion()) == null) {
					ParkingCamion.camionEsperando++;
					entradaCamiones.wait();
					ParkingCamion.camionEsperando--;
				}
				
				//Cuando queda una plaza libre la ocupa un camión
				for (int i=0; i<plazas.size(); i++) {
					plazas.get(i).setOcupado(true);
					plazas.get(i).setCamionAparcado(c);
				}
								
				ParkingCamion.mostrarParking();
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
			Thread.currentThread().interrupt();
		}
		
		return plazas;
	}
	
	//Método para liberar una plaza de coche
	public void releasePlazaCoche(PlazaParking plaza) {
		//Sincronizamos con el control de coches
		synchronized (entradaCoches) {	
			//Se libera la plaza y se notifica al resto de coches
			plaza.setOcupado(false);
			plaza.setCocheAparcado(null);
		
			ParkingCamion.mostrarParking();
		
			entradaCoches.notifyAll();
			
			//Sincronizamos con el control de camiones para notificar si hubiera camiones en espera
			synchronized (entradaCamiones) {
				if (ParkingCamion.camionEsperando > 0) {
				entradaCamiones.notifyAll();
				}
			}
		}
	}
	
	
	//Método para liberar las plazas de un camión
	public void releasePlazaCamion(List<PlazaParking> plazas) {
		//Sincronizamos con el control de camiones
		synchronized (entradaCamiones) {
			//Se liberan las plazas y se notifica al resto de camiones
			for (int i=0; i<plazas.size(); i++) {
				plazas.get(i).setOcupado(false);
				plazas.get(i).setCamionAparcado(null);
			}
		
			ParkingCamion.mostrarParking();
		
			entradaCamiones.notifyAll();
			
			//Sincronizamos con el control de coches para notificar si hubiera coches en espera
			synchronized (entradaCoches) {
				if (ParkingCamion.cocheEsperando > 0) {
					entradaCoches.notifyAll();
				}
			}
		}
	}
}
