package controlador.sockets;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cliente extends ConexionSockets {

	public Cliente() {
		
		super("cliente");

		try {
			this.flujoEntrada = new DataInputStream(this.socketCliente.getInputStream());
			this.flujoSalida = new DataOutputStream(this.socketCliente.getOutputStream());
			
			//this.objetoEntrada = new ObjectInputStream(this.socketCliente.getInputStream());
			//this.objetoSalida = new ObjectOutputStream(this.socketCliente.getOutputStream());
		} catch (IOException ex) {
			Logger.getLogger(ConexionSockets.class.getName()).log(Level.SEVERE,null,ex);
		}
	}
	
	
	public ServerSocket getSocketServidor() {
		return socketServidor;
	}

	public void setSocketServidor(ServerSocket socketServidor) {
		this.socketServidor = socketServidor;
	}

	public Socket getSocketCliente() {
		return socketCliente;
	}

	public void setSocketCliente(Socket socketCliente) {
		this.socketCliente = socketCliente;
	}

	public DataInputStream getFlujoEntrada() {
		return flujoEntrada;
	}

	public void setFlujoEntrada(DataInputStream flujoEntrada) {
		this.flujoEntrada = flujoEntrada;
	}

	public DataOutputStream getFlujoSalida() {
		return flujoSalida;
	}

	public void setFlujoSalida(DataOutputStream flujoSalida) {
		this.flujoSalida = flujoSalida;
	}
	
	public ObjectInputStream getObjetoEntrada() {
		return objetoEntrada;
	}

	public void setObjetoEntrada(ObjectInputStream objetoEntrada) {
		this.objetoEntrada = objetoEntrada;
	}

	public ObjectOutputStream getObjetoSalida() {
		return objetoSalida;
	}

	public void setObjetoSalida(ObjectOutputStream objetoSalida) {
		this.objetoSalida = objetoSalida;
	}

	public int getPUERTO() {
		return PUERTO;
	}

	public String getHOST() {
		return HOST;
	}
}