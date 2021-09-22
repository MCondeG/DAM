package ejercicios.ej10;

import java.util.Random;

public class Cliente10 implements Runnable {
	private Caja10 caja; //Caja donde pagar� el cliente
	private int numCliente;
	private Random r = new Random();
	private int turno; //Turno asignado en la caja
	Thread t;

	public Cliente10(int num) {
		this.numCliente = num;
		t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		System.out.println("Soy el cliente " + numCliente + ", entro al super");
		int espera = r.nextInt(100); 
		//El cliente compra durante un tiempo aleatorio
		try {
			Thread.sleep(espera);
		} catch (InterruptedException e) {
			e.printStackTrace();
			// Restore interrupted state...
		    Thread.currentThread().interrupt();
		}
		//El cliente pide una caja cuando terminade comprar
		escogerCaja();
		//El ciente entra en la caja asignada
		entrarACaja();
	}
	
	//M�todo creado para poder acceder al hilo y ejecutar el m�todo join en el programa principal
	public Thread getThread() {
		return t;
	}

	//M�todo para pasar por caja una vez ha comprado
	public void entrarACaja() {
		int pago = r.nextInt(50);
		int espera = r.nextInt(100);
		caja.entrar(this.numCliente, pago, espera, this.turno);

	}

	//M�todo para escoger una caja aleatoria
	private void escogerCaja() {
		caja = SuperMarket.asignarCaja();
		turno = caja.getTurno();
		System.out.println("Soy el cliente " + numCliente + " elijo la caja " + caja.getNumCaja() + " con turno " + turno);
	}

}
