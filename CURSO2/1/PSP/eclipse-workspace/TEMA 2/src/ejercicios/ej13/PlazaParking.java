package ejercicios.ej13;

//Clase que representa las plazas de parking
public class PlazaParking {
	int nPlaza = 0;					//Número de plaza
	boolean ocupado = false;		//Indicador de ocupación de la plaza
	Coche cocheAparcado = null;		//Coche aparcado para mostrar en la información del parking
	Camion camionAparcado = null;	//Camión aparcado para mostrar en la información del parking

	public PlazaParking (int n) {
		nPlaza = n;
	}
	
	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	
	public int getnPlaza() {
		return nPlaza;
	}

	public Coche getCocheAparcado() {
		return cocheAparcado;
	}

	public void setCocheAparcado(Coche cocheAparcado) {
		this.cocheAparcado = cocheAparcado;
	}

	public Camion getCamionAparcado() {
		return camionAparcado;
	}

	public void setCamionAparcado(Camion camionAparcado) {
		this.camionAparcado = camionAparcado;
	}

	public void setnPlaza(int nPlaza) {
		this.nPlaza = nPlaza;
	}

}
