package controlador;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Servidor extends ConexionSockets {

	public Servidor(int puerto) {
		
		this.puerto = puerto;
				
		try {
			this.ip = Network.getFirstNonLoopbackAddress(true, false).getHostAddress();

			this.socketServidor = new ServerSocket(this.puerto);		//Se crea el socket para el servidor en puerto 9999
		} catch (IOException ex) {
			Logger.getLogger(ConexionSockets.class.getName()).log(Level.SEVERE,null,ex);
		}
	}
	
	
	public void abrir() {
		try {
			this.socketCliente = this.socketServidor.accept();			//Socket para comunicarse con el cliente
			
			this.flujoEntrada = new DataInputStream(this.socketCliente.getInputStream());
			this.flujoSalida = new DataOutputStream(this.socketCliente.getOutputStream());
			
			this.objetoEntrada = new ObjectInputStream(this.flujoEntrada);
			this.objetoSalida = new ObjectOutputStream(this.flujoSalida);
			
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
	
	public int getPuerto() {
		return puerto;
	}

	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}