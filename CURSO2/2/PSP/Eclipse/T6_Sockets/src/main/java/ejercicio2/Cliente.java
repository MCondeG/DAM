package ejercicio2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import ejercicio1.Server;

public class Cliente {

	public static void main(String[] args) {
		final int PUERTO_SERVIDOR = 5000;
		byte[] buffer = new byte[1024];
		
		try {
			//obtengo la localizacion de localhost
			InetAddress direccionServidor = InetAddress.getByName("localhost");
			
			DatagramSocket socketUDP= new DatagramSocket();
			
			String mensaje="�Hola mundo desde el cliente!";
			
			//Convierto el mensaje a bytes
			buffer=mensaje.getBytes();
			
			//creo un datagrama
			DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);
			
			//lo envio con send
			System.out.println("Envio el datagrama");
			socketUDP.send(pregunta);
			
			//preparo la respuesta
			DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
			
			//recibo la respuesta
			socketUDP.receive(peticion);
			System.out.println("Recibo la peticion");
			
			//cojo los datos y lo muestro
			mensaje=new String(peticion.getData());
			System.out.println(mensaje);
			
			socketUDP.close();
		}catch (SocketException ex) {
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE,null,ex);
		}catch(UnknownHostException ex) {
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE,null,ex);
		}catch(IOException ex) {
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE,null,ex);
		}
	}
}
