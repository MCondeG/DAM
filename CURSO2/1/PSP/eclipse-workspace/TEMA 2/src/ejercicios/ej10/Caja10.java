package ejercicios.ej10;

public class Caja10 {

	//Variable para almacenar el número de caja
	private int numCaja;
	//Variable para controlar si la caja está libre
	private boolean ocupado;
	//Variable para identificar el siguiente cliente que debe pasar por la caja
	private int siguiente;
	//Variable para asignar turnos ordenados a los clientes que llegan a la caja
	private int turno;

	public Caja10(int num) {
		this.numCaja = num; 
		this.ocupado = false; //Inicialment la caja está libre
		this.siguiente = 1; //El primer cliente es el siguiente inicial
		this.turno = 0; //Se inicializan los turnos para asignar el 1 al primer cliente
	}

	public synchronized void entrar(int numCliente, int pago, int espera, int turno) {
		//Un cliente entra en la caja si está libre y si su turno es el del siguiente cliente esperado
		while (this.ocupado || turno != this.siguiente) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
				// Restore interrupted state...
			    Thread.currentThread().interrupt();

			}
		}
		//Al entrar en la caja la marca como ocupada
		setOcupado(true);
		System.out.println("Soy el cliente " + numCliente + ", entro a la caja " + this.numCaja);
		try {
			Thread.sleep(espera);
		} catch (InterruptedException e) {
			e.printStackTrace();
			// Restore interrupted state...
		    Thread.currentThread().interrupt();
		}
		System.out.println("Soy el cliente " + numCliente + ", pago " + pago);
		//El cliente realiza el pago
		cobrar(pago);
	}

	public synchronized void cobrar(int cantidad) {
		//Cuando el cliente paga se incrementa la cuenta de resultados, se marca la caja como libre y se avanza el turno.
		Resultado10.resultado += cantidad;
		this.ocupado = false;
		siguiente++;
		//Una vez que se han actualizado todas las variables se activan todos los hilos para que pase el siguiente.
		notifyAll();
	}

	public int getNumCaja() {
		return this.numCaja;
	}

	public boolean isOcupado() {
		return this.ocupado;
	}

	public void setOcupado(boolean oc) {
		this.ocupado = oc;
	}

	public int getSiguiente() {
		return this.siguiente;
	}

	public void incrementarTurno() {
		turno++;
	}

	public int getTurno() {
		return this.turno;
	}
}
