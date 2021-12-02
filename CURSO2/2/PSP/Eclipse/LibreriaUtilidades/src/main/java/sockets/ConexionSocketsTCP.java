package sockets;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexionSocketsTCP extends ConexionSockets {
	
	protected final String HOST = "127.0.0.1"; //Host para la conexión	
	protected ServerSocket ss; //Socket del servidor
	protected Socket cs; //Socket del cliente
	protected DataInputStream dis; //Flujo de datos de entrada
	protected DataOutputStream dos; //Flujo de datos de salida

	
	public ConexionSocketsTCP(String tipo) {
		
		super();
		
		try {
			if (tipo.equalsIgnoreCase("servidor")) {
				this.ss = new ServerSocket(this.PUERTO);//Se crea el socket para el servidor en puerto 5000
				this.cs = new Socket(); //Socket para el cliente
			}
			else this.cs = new Socket(this.HOST, this.PUERTO); //Socket para el cliente en localhost en puerto 5000
		}
		catch(IOException ex) {
			Logger.getLogger(ConexionSocketsUDP.class.getName()).log(Level.SEVERE,null,ex);
		}	
	}
}