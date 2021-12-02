package sockets;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexionSocketsUDP extends ConexionSockets {
	
	protected byte[] buffer;	//buffer para guardar mensajes
	protected InetAddress direccionServidor;	//direccion del servidor
	protected DatagramSocket socketUDP;		//socket
	protected DatagramPacket packetUDP;		//paquete para compartir informacion entre cliente-servidor
	
	
	public ConexionSocketsUDP() {
		
		super();
		
		try {
			this.buffer = new byte[1024];
			this.direccionServidor = InetAddress.getByName("localhost");
			this.socketUDP = new DatagramSocket();
			this.packetUDP = new DatagramPacket(this.buffer, this.buffer.length, this.direccionServidor, this.PUERTO);
		}
		catch(IOException ex) {
			Logger.getLogger(ConexionSocketsUDP.class.getName()).log(Level.SEVERE,null,ex);
		}
	}
}