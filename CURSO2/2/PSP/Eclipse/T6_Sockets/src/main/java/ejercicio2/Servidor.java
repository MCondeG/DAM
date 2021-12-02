package ejercicio2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

import ejercicio1.Server;

public class Servidor {

	public static void main(String[] args) {
		final int PUERTO = 5000;
		byte[] buffer = new byte[1024];
		
		try {
			System.out.println("Iniciado el server UDP");
			//creacion del socket
			DatagramSocket socketUDP = new DatagramSocket(PUERTO);
			//DatagramSocket es equivalente a nuestro socket anterior
			//Siempre atenderá peticiones
			while(true) {
				
				//Preparo la respuesta (creo un paquete con info del buffer donde guardar y la longitud del mismo
				DatagramPacket peticion =new DatagramPacket(buffer, buffer.length);
				
				//Recibo el datagrama (como el inputReader)
				//no se sabe quien contacta aun
				socketUDP.receive(peticion);
				System.out.println("Recibo informacion del cliente");
				
				//convierto lo recibido
				String mensaje = new String(peticion.getData());
				System.out.println(mensaje);
				
				//obtengo el puerto y la direccion de origen
				//Si no se quiere responder, no es necesario
				int puertoCliente = peticion.getPort();
				InetAddress direccion = peticion.getAddress();
				
				mensaje="Hola mundo desde el servidor";
				buffer = mensaje.getBytes();
				
				//creo el datagrama
				DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);
				
				//envio la información
				System.out.println("Envio la informacion del cliente");
				socketUDP.send(respuesta);
			
			}
		}catch(SocketException ex) {
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE,null,ex);
		}catch(IOException ex) {
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE,null,ex);
		}
	}
}
