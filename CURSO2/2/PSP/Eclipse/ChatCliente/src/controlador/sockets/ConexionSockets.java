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


public class ConexionSockets {
	
	protected final int PUERTO = 9999; 			//Puerto para la conexión
	protected final String HOST = "127.0.0.1";	//Host para la conexión	
	
	protected ServerSocket socketServidor; 		//Socket del servidor
	protected Socket socketCliente; 			//Socket del cliente
	protected DataInputStream flujoEntrada; 	//Flujo de datos de entrada
	protected DataOutputStream flujoSalida; 	//Flujo de datos de salida
	protected ObjectInputStream objetoEntrada;	//Objetos de entrada
	protected ObjectOutputStream objetoSalida;	//Objetos de salida

	
	public ConexionSockets(String tipo) {
				
		try {
			if (tipo.equalsIgnoreCase("servidor")) {
				this.socketServidor = new ServerSocket(this.PUERTO);		//Se crea el socket para el servidor en puerto 9999
				this.socketCliente = new Socket(); 							//Socket para comunicarse con el cliente
			}
			else this.socketCliente = new Socket(this.HOST, this.PUERTO); 	//Socket para el cliente en localhost en puerto 9999
		}
		catch(IOException ex) {
			Logger.getLogger(ConexionSockets.class.getName()).log(Level.SEVERE,null,ex);
		}	
	}
	
	
	public void cerrar() {
		
		if (!this.socketCliente.isClosed()) {
			try {
				this.socketCliente.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}