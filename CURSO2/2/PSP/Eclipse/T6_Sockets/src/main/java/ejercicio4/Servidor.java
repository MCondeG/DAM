package ejercicio4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
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
			System.out.println("Servidor UDP iniciado");
			//creacion del socket
			DatagramSocket socketUDP = new DatagramSocket(PUERTO);
			//DatagramSocket es equivalente a nuestro socket anterior
			//Siempre atenderá peticiones
			while(true) {
				
				//Preparo la respuesta (creo un paquete con info del buffer donde guardar y la longitud del mismo
				DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
				
				//Recibo el datagrama (como el inputReader)
				//no se sabe quien contacta aun
				socketUDP.receive(peticion);
				System.out.println("Recibo informacion del cliente");
				

				//convierto lo recibido
				ByteArrayInputStream bais = new ByteArrayInputStream(peticion.getData());
				DataInputStream dis = new DataInputStream(bais);
				
				//muestro datos
				int numero=dis.readInt();
				String mensaje="";
				for(int i=numero; i<=numero+10; i++) {
					mensaje+=i+" ";
				}
				
				//obtengo el puerto y la direccion de origen
				//Si no se quiere responder, no es necesario
				int puertoCliente = peticion.getPort();
				InetAddress direccion = peticion.getAddress();
				
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				DataOutputStream dos = new DataOutputStream(baos); 
				
				System.out.println("Envio el mensaje: "+mensaje);
				dos.writeUTF(mensaje); // write some data (String)
				dos.flush(); 
				dos.close(); // !!! flush and close
				buffer = baos.toByteArray(); // buf contains written data
				
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
		}catch(NumberFormatException ex) {
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE,null,ex);
		}
	}
}
